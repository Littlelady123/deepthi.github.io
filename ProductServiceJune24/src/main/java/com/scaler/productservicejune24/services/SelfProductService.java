package com.scaler.productservicejune24.services;

import com.scaler.productservicejune24.exceptions.ProductNotFoundException;
import com.scaler.productservicejune24.models.Category;
import com.scaler.productservicejune24.models.Product;
import com.scaler.productservicejune24.repositories.CategoryRepository;
import com.scaler.productservicejune24.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService
{
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository,
                              CategoryRepository categoryRepository)

    {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long productId)
    {
        // Make a call to DB to fetch a product with given Id

        Optional<Product> productOptional = productRepository.findById(productId);

        if (productOptional.isEmpty())
        {
            throw new ProductNotFoundException("Product with Id : " + productId + " doesn't exist");
        }
            return productOptional.get();


    }

    @Override
    public List<Product> getAllProducts()
    {
        return productRepository.findAll();
    }

    // PATCH
    @Override
    public Product updateProduct(Long id, Product product)
    {
        // Whenever we are finding a product with some Id , there is a case of getting null product.
        // So, to avoid this we use Optional Product.
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty())
        {
            throw new ProductNotFoundException("Product with id: " + id + " doesn't exist");
        }

        Product productInDB = optionalProduct.get();

        if(product.getTitle() != null)
        {
            productInDB.setTitle(product.getTitle());
        }

        if(product.getPrice() != null)
        {
            productInDB.setPrice(product.getPrice());
        }

        return productRepository.save(productInDB);


    }

    // PUT
    @Override
    public Product replaceProduct(Long id, Product product)
    {
        return null;
    }

    @Override
    public void deleteProduct(Long id)
    {
        productRepository.deleteById(id);

    }

    @Override
    public Product addNewProduct(Product product)
    {
        Category category = product.getCategory();

        if(category.getId() == null)
        {
            // We need to create a new Category object in DB first.
            category  = categoryRepository.save(category);
            product.setCategory(category);
        }

        return productRepository.save(product);

    }
}

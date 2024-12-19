package com.scaler.productservicejune24.services;

import com.scaler.productservicejune24.dtos.FakeStoreProductDto;
import com.scaler.productservicejune24.models.Category;
import com.scaler.productservicejune24.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.*;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
//@Primary
public class FakeStoreProductService implements ProductService
{
    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate)
    {
         this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long productId)
    {
         //throw new RuntimeException("Something went wrong");
        //Call Fakestore to fetch the product with given id => HTTP call.
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(
               "https://fakestoreapi.com/products/" + productId,
             FakeStoreProductDto.class
        );

         //Convert FakeStoreProductDto into Product.
        return convertFakeStoreProductToProduct(fakeStoreProductDto);
    }



    @Override
    public List<Product> getAllProducts()
    {
        FakeStoreProductDto [] fakeStoreProductDtos = restTemplate.getForObject(
                "https://fakestoreapi.com/products", FakeStoreProductDto[].class

        );
        //convert list of FakeStoreProductDto into List of Product.
        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos)
        {
            products.add(convertFakeStoreProductToProduct(fakeStoreProductDto));
        }
        return products;
    }

    // Partial Update
    @Override
    public Product updateProduct(Long id, Product product)
    {
        //PATCH Method

        RequestCallback requestCallback = restTemplate.httpEntityCallback(product, FakeStoreProductDto.class);
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor = new HttpMessageConverterExtractor(FakeStoreProductDto.class,
                restTemplate.getMessageConverters());
        FakeStoreProductDto response = restTemplate.execute("https://fakestoreapi.com/products/" + id,
                HttpMethod.PATCH, requestCallback, responseExtractor);


          return convertFakeStoreProductToProduct(response);
    }

    @Override
    public Product replaceProduct(Long id, Product product)
    {
        return null;
    }

    @Override
    public void deleteProduct(Long id)
    {

    }

    @Override
    public Product addNewProduct(Product product) {
        return null;
    }


    private Product convertFakeStoreProductToProduct(FakeStoreProductDto fakeStoreProductDto)
    {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());

        Category category = new Category();
        category.setDescription(fakeStoreProductDto.getCategory());
        product.setCategory(category);

        return product;

    }


}

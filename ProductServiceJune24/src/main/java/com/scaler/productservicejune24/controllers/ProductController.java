package com.scaler.productservicejune24.controllers;

import com.scaler.productservicejune24.models.Product;
import com.scaler.productservicejune24.services.FakeStoreProductService;
import com.scaler.productservicejune24.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(@Qualifier("selfProductService")
                             ProductService productService)
    {
        this.productService = productService;
    }

    //http://localhost:8080/products/id
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id)
    {
        //throw new RuntimeException("Something went wrong");

        try {
            ResponseEntity<Product> responseEntity = new ResponseEntity<>(
                    productService.getSingleProduct(id),
                    HttpStatus.OK
            );
            return responseEntity;
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping()
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long productId)
    {
         productService.deleteProduct(productId);
    }

    // PATCH call to http://localhost:8080/products/1
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id,@RequestBody Product product)
    {
        return productService.updateProduct(id,product);
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product)
    {
        return null;
    }

    @PostMapping
    public Product addNewProduct(@RequestBody Product product)
    {
         return productService.addNewProduct(product);
    }

}

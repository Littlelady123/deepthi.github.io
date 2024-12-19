package com.scaler.productservicejune24.repositories;

import com.scaler.productservicejune24.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>
{
   // Product Repo should contain all the methods (CRUD) related to Product model.

         List<Product> findByPriceIsGreaterThan(Double price);
         // select * from products where price > 1000.

          List<Product> findProductByTitleLike(String word);
        // select * from products where title like '%abc%'

        List<Product> findByTitleLikeIgnoreCase(String word);  // case insensitive

        List<Product> findTop5ByTitleContains(String word);
        // select * from products where title like LIMIT 5

        Optional<Product> findById(Long id);

        @Override
        List<Product> findAll();
}
/*  ProductRepository should be compatible with JPARepository for that
    we need to follow few things , those are:

    1. Repository should be an interface
    2. Repository should extend JPARepository

 */

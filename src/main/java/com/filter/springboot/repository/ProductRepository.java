package com.filter.springboot.repository;

import com.filter.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE " +
            "p.name LIKE CONCAT('%', :query , '%') " +
            "OR p.description LIKE CONCAT('%', :query, '%')")
    List<Product> searchProducts(String query);

    //native Sql query where , we search in table
    @Query(value = "SELECT * FROM products p WHERE " +
            "p.name LIKE CONCAT('%', :query , '%') " +
            "OR p.description LIKE CONCAT('%', :query, '%')", nativeQuery = true)
    List<Product> searchProductsSQL(String query);
}
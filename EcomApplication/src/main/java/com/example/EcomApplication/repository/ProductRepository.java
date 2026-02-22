package com.example.EcomApplication.repository;

import com.example.EcomApplication.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {


    List<Product> findByName(String name);

    List<Product> findByPriceGreaterThan(float price);

    List<Product> findByNameAndPrice(String name,float price);

   //JPQL
    @Query("SELECT p FROM Product p WHERE p.name=:name")
    List<Product> findByNameJPQL(@Param("name") String name);


    //Native Query

    @NativeQuery(value = "SELECT * FROM ecom_products WHERE name=:name")
    List<Product> findByNameNative(@Param("name") String name);
}

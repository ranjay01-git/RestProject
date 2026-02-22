package com.example.EcomApplication.service;

import com.example.EcomApplication.entity.Product;
import com.example.EcomApplication.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // vs component
public class ProductService {

    // Dependency Injection -> Inversion of control (IOC)

    //1. field Injection
    @Autowired
    private ProductRepository repo;

  // 2. Constructor Injection
    private ProductRepository repo2;
    public ProductService(ProductRepository repo2)
    {
        this.repo2=repo2;
    }

    public List<Product> getAllProducts()
    {
        return repo.findAll();
    }

    public String createProduct(Product product)
    {
        repo.save(product);
        return "Product created";
    }

   public List<Product> getProductsByName(String name, float price)
   {
       return repo.findByNameAndPrice(name,price);
   }

   public List<Product> getProductsByNameJPQL(String name)
   {
       return repo.findByNameJPQL(name);
   }
}

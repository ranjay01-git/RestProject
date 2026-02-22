package com.example.EcomApplication.controller;

import com.example.EcomApplication.entity.Product;
import com.example.EcomApplication.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RestControllerAdvice
public class ProductController {

    List<String> products=new ArrayList<>();

    @Autowired
    private ProductService service;


//    @GetMapping("/hello")
//    public String hello()
//    {
//        return "Hello World";
//    }

    @PostMapping("/products")
    public String createProduct(@RequestBody Product product)
    {
      //products.add(product);
      return service.createProduct(product);
    }

    @GetMapping("products")
    public List<Product> getProducts()
    {
        return service.getAllProducts();
    }

    @PutMapping("products/{id}")
    public String updateProduct(@PathVariable int id, @RequestBody String product)
    {
        if(id>=0 && id< products.size())
        {
            products.set(id,product);
            return "product updated!";
        }
        else
        {
            return "product not found";
        }


    }

    @DeleteMapping("products/query")
    public String deleteProdcut(@RequestParam int id)
    {
        if(id>=0 && id< products.size())
        {
            products.remove(id);
            return "product deleted!";
        }
        else
        {
            return "product not found";
        }
    }

//    @ExceptionHandler(Exception.class)
//    public String handleException(Exception e)
//    {
//        return "An error occurred"+ e.getMessage();
//    }

   @GetMapping("/products/search")
    public List<Product> searchProducts(@RequestParam String name, @RequestParam float price)
   {
       return service.getProductsByName(name,price);
   }

   @GetMapping("/products/search/jpql")
    public List<Product> searchProductsJPQL(@RequestParam String name)
   {
       return service.getProductsByNameJPQL(name);
   }
}

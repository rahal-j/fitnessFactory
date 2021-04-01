package com.school.school.repository;

import com.school.school.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {


    List<Product> findAllByStatus (String status);
    Product findByName(String name );










}




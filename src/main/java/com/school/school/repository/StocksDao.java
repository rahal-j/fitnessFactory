package com.school.school.repository;

import com.school.school.entity.Product;
import com.school.school.entity.Stocks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StocksDao extends JpaRepository<Stocks,Integer> {

    List<Stocks> findStocksByProductOrderByBatchNoDesc(Integer productId);

    List<Stocks> findAllByProduct(Product product);


}

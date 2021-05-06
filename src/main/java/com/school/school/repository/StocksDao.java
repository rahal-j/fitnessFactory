package com.school.school.repository;

import com.school.school.entity.Product;
import com.school.school.entity.RoomCourseSchedule;
import com.school.school.entity.Stocks;
import com.school.school.enums.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;

public interface StocksDao extends JpaRepository<Stocks,Integer> {

    List<Stocks> findStocksByProductOrderByBatchNoDesc(Integer productId);

    List<Stocks> findAllByProduct(Product product);

    @Query(value = "SELECT * FROM stocks WHERE product=?1 order by batch_no desc ", nativeQuery = true)
    List<Stocks>findStocksByProductId(int productId);

    Stocks findByProduct(int product);

    @Query(value = "SELECT * FROM stocks WHERE product=?1 and status ='ACTIVE' ", nativeQuery = true)
    List<Stocks> findByProductAndStatusDetail(int productId);







}

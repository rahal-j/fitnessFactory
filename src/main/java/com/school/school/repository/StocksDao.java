package com.school.school.repository;

import com.school.school.entity.Stocks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StocksDao extends JpaRepository<Stocks,Integer> {



}

package com.school.school.service;

import com.school.school.dto.ResponseDto;
import com.school.school.dto.StocksDto;
import com.school.school.entity.Stocks;

import java.util.List;

public interface StocksService {


    ResponseDto addStock(StocksDto stocksDto);

    List<Stocks> fetchStocks();

    ResponseDto getLastStockId(int productId);
}

package com.school.school.service;

import com.school.school.dto.StocksDto;
import com.school.school.entity.Stocks;

public interface StocksService {

    Stocks addStocks(StocksDto stocksDto);
}

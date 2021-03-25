package com.school.school.service.impl;

import com.school.school.dto.StocksDto;
import com.school.school.dtoToEntityMapper.StocksDtoToEntityMapper;
import com.school.school.entity.Product;
import com.school.school.entity.Stocks;
import com.school.school.repository.ProductDao;
import com.school.school.repository.StocksDao;
import com.school.school.service.StocksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StocksServiceImpl implements StocksService {

    @Autowired
    private StocksDao stocksDao;

    @Autowired
    private ProductDao productDao;

    @Override
    public Stocks addStocks(StocksDto stocksDto) {

        Product product = productDao.getOne(stocksDto.getProduct());
        Stocks stocks = StocksDtoToEntityMapper.getStocksEntity(stocksDto, new Stocks(), product);
        return stocksDao.save(stocks);


    }


}

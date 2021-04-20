package com.school.school.dtoToEntityMapper;

import com.school.school.dto.StocksDto;
import com.school.school.entity.Product;
import com.school.school.entity.Stocks;

import java.util.Date;

public class StocksDtoToEntityMapper {

    public static Stocks getStocksEntity(StocksDto stocksDto, Stocks stocks, Product product){

       stocks.setId(stocks.getId()!= 0 ? stocks.getId() : stocksDto.getId() );
        stocks.setBatchNo(stocksDto.getBatchNo());
        stocks.setDateCreated(new Date());
        stocks.setQuantity(stocksDto.getQuantity());
        stocks.setUnit(stocksDto.getUnit());
        stocks.setProduct(product);
        return stocks;




    }






}

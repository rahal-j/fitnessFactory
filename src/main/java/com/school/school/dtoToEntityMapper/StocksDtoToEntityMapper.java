package com.school.school.dtoToEntityMapper;

import com.school.school.dto.StocksDto;
import com.school.school.entity.Product;
import com.school.school.entity.Stocks;

import java.util.Date;

public class StocksDtoToEntityMapper {

    public static Stocks getStocksEntity(StocksDto stocksDto, Stocks stocks, Product product){

       stocks.setId(stocks.getId() !=null? stocks.getId() : null);
        stocks.setBatchNo(stocksDto.getBatchNo());
        stocks.setBuyingPrice(stocksDto.getBuyingPrice());
        stocks.setSellingPrice(stocksDto.getSellingPrice());
        stocks.setDateCreated(new Date());
        stocks.setQuantity(stocksDto.getQuantity());
        stocks.setUnit(stocksDto.getUnit());
        stocks.setProduct(product);
        stocks.setStatus(stocksDto.getStatus());
        return stocks;




    }






}

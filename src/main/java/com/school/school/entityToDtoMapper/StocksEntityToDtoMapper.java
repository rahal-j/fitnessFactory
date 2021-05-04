package com.school.school.entityToDtoMapper;

import com.school.school.dto.StocksDto;
import com.school.school.entity.Stocks;
import com.sun.xml.bind.v2.model.core.ID;

public class StocksEntityToDtoMapper {

    public static StocksDto getStocksDto(Stocks stocks){
        StocksDto stocksDto = new StocksDto();
        stocksDto.setProduct(stocks.getProduct());
        stocksDto.setBatchNo(stocks.getBatchNo());
        stocksDto.setExpireDate(stocks.getExpireDate());
        stocksDto.setQuantity(stocks.getQuantity());
        stocksDto.setDateCreated(stocks.getDateCreated());


        return stocksDto;






    }


}

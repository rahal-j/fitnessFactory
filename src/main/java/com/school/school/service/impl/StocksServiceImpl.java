package com.school.school.service.impl;

import com.school.school.dto.ResponseDto;
import com.school.school.dto.StocksDto;
import com.school.school.dtoToEntityMapper.StocksDtoToEntityMapper;
import com.school.school.entity.Product;
import com.school.school.entity.Stocks;
import com.school.school.enums.ResponseEnum;
import com.school.school.repository.ProductDao;
import com.school.school.repository.StocksDao;
import com.school.school.service.StocksService;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StocksServiceImpl implements StocksService {

    @Autowired
    private StocksDao stocksDao;

    @Autowired
    private ProductDao productDao;



    @Override
  public ResponseDto addStock(StocksDto stocksDto){

      ResponseDto responseDto = new ResponseDto(ResponseEnum.FAIL.getCode(),"Transaction Failed");

      try{
          Product product = productDao.getOne(stocksDto.getProduct());

          Stocks stocks = StocksDtoToEntityMapper.getStocksEntity(stocksDto, new Stocks(), product);
          stocksDao.save(stocks);
          responseDto.setCode(ResponseEnum.SUCCESS.getCode());
          responseDto.setMessage("Stocks Save Successful");
          return responseDto;

      }catch (Exception e){

          return responseDto;

      }


  }


  @Override
    public List<Stocks> fetchStocks(){return stocksDao.findAll();}

    @Override
    public ResponseDto getLastStockId(int productId){

        Integer batchNo = 1;
        List<Stocks> stockList = new ArrayList<>();
        Product prod = productDao.getOne(productId);
        stockList  = stocksDao.findAllByProduct(prod);

        if (stockList == null){


          return new ResponseDto(batchNo);

        }else {
            Stocks  stocks = stocksDao.findStocksByProductOrderByBatchNoDesc(productId).get(0);
            batchNo += stocks.getBatchNo();
            return new ResponseDto(batchNo);

        }
     }













}

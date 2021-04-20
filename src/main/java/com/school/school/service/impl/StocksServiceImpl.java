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
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public ResponseDto getLastStockId(int productId){

        Integer batchNo = 1;
        List<Stocks> stockList ;
        Product prod = productDao.getOne(productId);

       stockList = stocksDao.findAllByProduct(prod);

        if (stockList == null || stockList.isEmpty()){


          return new ResponseDto(batchNo);

        }else {

            List<Stocks> dataList  = stocksDao.findStocksByProductId(productId);
                  batchNo = dataList.get(0).getBatchNo()+1;

            return new ResponseDto(batchNo);

        }
    }













}

package com.school.school.service.impl;

import com.school.school.dto.ResponseDto;
import com.school.school.dto.StocksDto;
import com.school.school.dto.StocksProductDto;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        StocksDto stocksDto = new StocksDto();

        Product prod = productDao.getOne(productId);
        stocksDto.setIsExpire(prod.getIsExpire());
       stockList = stocksDao.findAllByProduct(prod);

        if (stockList == null || stockList.isEmpty()){
            stocksDto.setBatchNo(batchNo);
          return new ResponseDto(stocksDto);

        }else {

            List<Stocks> dataList  = stocksDao.findStocksByProductId(productId);
                  batchNo = dataList.get(0).getBatchNo()+1;
                  stocksDto.setBatchNo(batchNo);
            return new ResponseDto(stocksDto);

        }
    }

    @Override
    public ResponseDto saveStocksArray(StocksProductDto stocksProductDto){
        ResponseDto responseDto = new ResponseDto(ResponseEnum.FAIL.getCode() , "Transaction Fail");

        try{
        for (int i = 0; i < stocksProductDto.getProducts().size();i++ ){

            Date date1 ;
            Stocks stocks = new Stocks();
            stocks.setBatchNo(Integer.parseInt(stocksProductDto.getBatchNos().get(i)));
            Product product = productDao.getOne(Integer.parseInt(stocksProductDto.getProducts().get(i)));
            stocks.setProduct(product);
            stocks.setQuantity(Integer.parseInt(stocksProductDto.getQuantities().get(i)));
       //     date1= new SimpleDateFormat("dd/MM/yyyy").parse(stocksProductDto.getDatesCreated().get(i));
          //  stocks.setDateCreated(new Date());

          stocks.setDateCreated(new Date());
            if(!stocksProductDto.getExpiredates().get(i).isEmpty() ) {
                try {
                     date1= new SimpleDateFormat("dd/MM/yyyy").parse(stocksProductDto.getExpiredates().get(i));
                    stocks.setExpireDate(date1);

                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            stocksDao.save(stocks);
            responseDto.setCode(ResponseEnum.SUCCESS.getCode());
            responseDto.setMessage("Stocks Save Successful");


        }   }catch (Exception e){

        return responseDto;

    }


        return responseDto;


    }


    public ResponseDto getStocksDto(){
        Stocks stocks = null;
        Product product = new Product();
        ResponseDto responseDto = new ResponseDto();
        StocksDto stocksDto = new StocksDto();






        return null;

    }




















}

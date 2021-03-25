package com.school.school.controller;

import com.school.school.dto.StocksDto;
import com.school.school.entity.Stocks;
import com.school.school.service.StocksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("stocks")
@Controller
public class StocksController {

    @Autowired
    private StocksService stocksService;

    @RequestMapping("/")
    private String addPage(){return "stocks_form";}

    @PostMapping("/save")
    @ResponseBody
    public Stocks saveStocks(@RequestBody StocksDto stocksDto){
        return stocksService.addStocks(stocksDto);

    }



}

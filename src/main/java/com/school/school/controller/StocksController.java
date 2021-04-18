package com.school.school.controller;

import com.school.school.dto.ProductDto;
import com.school.school.dto.ResponseDto;
import com.school.school.dto.StocksDto;
import com.school.school.entity.Stocks;
import com.school.school.service.ProductService;
import com.school.school.service.StocksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/stocks")
@Controller
public class StocksController {

    @Autowired
    private StocksService stocksService;

    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String addStocks(Model model){
        model.addAttribute("stocks",stocksService.fetchStocks());
        return "stocks_list";

    }

    @GetMapping("/insertPage")
    public String addPage(Model model){
        List<ProductDto> productDtos = productService.getActiveProductList();
        model.addAttribute("products", productDtos);
        return "stocks_form";
    }


    @PostMapping("/save")
    @ResponseBody
    public ResponseDto saveStocks(@RequestBody StocksDto stocksDto){
        return stocksService.addStock(stocksDto);
    }

    @GetMapping("/productList")
    @ResponseBody
    public ResponseDto getAllproducts(){
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(productService.getActiveProductList());
        return responseDto;

    }


@GetMapping("/getBatchNo")
    @ResponseBody
    public ResponseDto getLastStockId(@RequestParam (value = "id") String id){
        return stocksService.getLastStockId(Integer.parseInt(id));



}




}

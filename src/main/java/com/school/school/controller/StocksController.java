package com.school.school.controller;

import com.lowagie.text.DocumentException;
import com.school.school.PdfExporter.StocksPdfExporter;
import com.school.school.PdfExporter.SubscriptionPdfExporter;
import com.school.school.dto.ProductDto;
import com.school.school.dto.ResponseDto;
import com.school.school.dto.StocksDto;
import com.school.school.dto.StocksProductDto;
import com.school.school.entity.Stocks;
import com.school.school.entity.Subscription;
import com.school.school.service.ProductService;
import com.school.school.service.StocksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    public ResponseDto saveStocks(@RequestBody StocksProductDto stocksProductDto){
        return stocksService.saveStocksArray(stocksProductDto);

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

    @GetMapping("/export")
    public void exportToPdf(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        String headerKey = "content-deposition";
        String headerValue = "attachment; filename = subscription.pdf";

        response.setHeader(headerKey,headerValue);

        List<Stocks> listStocks = stocksService.fetchStocks();

        StocksPdfExporter exporter = new StocksPdfExporter(listStocks);
        exporter.export(response);






    }




}

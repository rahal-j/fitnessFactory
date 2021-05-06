package com.school.school.controller;

import com.school.school.dto.InvoiceDto;
import com.school.school.dto.ProductDto;
import com.school.school.dto.ResponseDto;
import com.school.school.dto.StocksInvoiceDto;
import com.school.school.service.InvoiceService;
import com.school.school.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("invoice")
@Controller
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private ProductService productService;


    @RequestMapping("/")
    public String addInvoice(Model model){
        model.addAttribute("invoice",invoiceService.fetchInvoice());
        return "invoice_list";
    }



    @GetMapping("/insertPage")
    public String addPage(Model model){
        List<ProductDto> productDtos = productService.getActiveProductList();
        model.addAttribute("products",productDtos);
        return "invoice_form";
    }




    @PostMapping("/save")
    @ResponseBody
    public ResponseDto saveInvoice(@RequestBody StocksInvoiceDto stocksInvoiceDto){
        return invoiceService.saveInvoiceArray(stocksInvoiceDto);}



    @GetMapping("/productList")
    @ResponseBody
    public ResponseDto getAllProducts(){
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(productService.getActiveProductList());
        return responseDto;
    }



    @GetMapping("/searchMember")
    @ResponseBody
    public ResponseDto getInvoiceDto(@RequestParam String nic){return invoiceService.getInvoiceDto(nic);}



    @GetMapping("/getStockDetails")
    @ResponseBody
    public ResponseDto getLastStockId(@RequestParam (value = "id") String id){
        return stocksService.getLastStockId(Integer.parseInt(id));



    }





}

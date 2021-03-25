package com.school.school.controller;

import com.school.school.dto.ProductDto;
import com.school.school.dto.ResponseDto;
import com.school.school.dto.SubscriptionDto;
import com.school.school.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("product")
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String addPage(Model model) {
        model.addAttribute("products", productService.fetchProductList());
        return "product_list";
    }

    @GetMapping("/insertPage")
    public String getInsertPage() {
        return "product_form";
    }


    @PostMapping("/save")
    @ResponseBody
    public ResponseDto saveProduct(@RequestBody ProductDto productDto){
        return productService.addProduct(productDto);
    }


    @GetMapping("/activate")
    @ResponseBody
    public ResponseDto activateProduct(@RequestParam int id) {
        return productService.activateProduct(id);
    }

    @GetMapping("/deactivate")
    @ResponseBody
    public ResponseDto deactivateProduct(@RequestParam int id) {
        return productService.deactivateProduct(id);
    }


    @PostMapping("/update")
    @ResponseBody
    public ResponseDto update(@RequestBody ProductDto productDto) {
        return productService.update(productDto);
    }

    @GetMapping("/getUpdateData")
    public String getProductData(@RequestParam int id,Model model){
        model.addAttribute("product",productService.getProductData(id).getData());
        return "product_form";



    }















}

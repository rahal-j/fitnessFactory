package com.school.school.service.impl;

import com.school.school.dto.ProductDto;
import com.school.school.dto.ResponseDto;
import com.school.school.dtoToEntityMapper.ProductDtoToEntityMapper;
import com.school.school.entity.Product;
import com.school.school.entity.Subscription;
import com.school.school.entityToDtoMapper.ProductEntityToDtoMapper;
import com.school.school.enums.ResponseEnum;
import com.school.school.enums.TransactionStatus;
import com.school.school.repository.ProductDao;
import com.school.school.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public ResponseDto addProduct(ProductDto productDto) {

        ResponseDto responseDto = new ResponseDto(ResponseEnum.FAIL.getCode(), "Transaction Fail");
        try {
            Product product = ProductDtoToEntityMapper.getProductEntity(productDto, new Product());
            productDao.save(product);
            responseDto.setCode(ResponseEnum.SUCCESS.getCode());
            responseDto.setMessage("Product save successful");
            return responseDto;


        } catch (Exception e) {
            return responseDto;
        }


    }

    @Override
    public List<Product> fetchProductList() {
        return productDao.findAll();
    }



    @Override
    public ResponseDto activateProduct(int id) {
        ResponseDto responseDto = new ResponseDto(ResponseEnum.FAIL.getCode(), ResponseEnum.FAIL.getMsg());
        Product product = productDao.getOne(id);
        if (product != null) {
            product.setStatus(TransactionStatus.ACTIVE.getCode());
            productDao.save(product);
            return new ResponseDto(ResponseEnum.SUCCESS.getCode(), "Product activated successfully");
        }
        return responseDto;


    }

    @Override
    public ResponseDto deactivateProduct(int id) {
        ResponseDto responseDto = new ResponseDto(ResponseEnum.FAIL.getCode(), ResponseEnum.FAIL.getMsg());
        Product product = productDao.getOne(id);
        if (product != null) {
            product.setStatus(TransactionStatus.DEACTIVE.getCode());
            productDao.save(product);
            return new ResponseDto(ResponseEnum.SUCCESS.getCode(), "Product deactivated successfully");
        }
        return responseDto;
    }


    @Override
    public ResponseDto getProductData(int id){

        return new ResponseDto(ProductEntityToDtoMapper.getProductDto(new ProductDto(),productDao.getOne(id)));
    }

    @Override
    public ResponseDto update(ProductDto productDto){
        ResponseDto responseDto = new ResponseDto(ResponseEnum.FAIL.getCode(),ResponseEnum.FAIL.getMsg());
        Product product = productDao.findByName(productDto.getName());
        if(product != null){
            productDao.save(ProductDtoToEntityMapper.getProductEntity(productDto,product));
            return new ResponseDto(ResponseEnum.SUCCESS.getCode(),"Product updated successfully");

        }
        return responseDto;
    }


    @Override
    public List<ProductDto>getActiveProductList(){
        List<ProductDto> productDtos = new ArrayList<>();
        List<Product> products = productDao.findAllByStatus("ACTIVE");
        for (Product product : products){
            ProductDto productDto = ProductEntityToDtoMapper.getProductDto(new ProductDto(),product);
            productDtos.add(productDto);
        }
        return productDtos;
    }























}

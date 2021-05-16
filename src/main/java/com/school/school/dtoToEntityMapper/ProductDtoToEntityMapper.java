package com.school.school.dtoToEntityMapper;

import com.school.school.dto.ProductDto;
import com.school.school.entity.Product;
import com.school.school.enums.TransactionStatus;

import java.util.Date;

public class ProductDtoToEntityMapper {

    public static Product getProductEntity(ProductDto productDto, Product product){
        product.setId(product.getId() != null? product.getId() : productDto.getId());
        product.setName(productDto.getName());
        product.setStatus(TransactionStatus.ACTIVE.getCode());
        product.setIsExpire(productDto.getIsExpire());
        product.setDateCreated(new Date());
        product.setUnitPrice(productDto.getUnitPrice());

        return product;

    }







}

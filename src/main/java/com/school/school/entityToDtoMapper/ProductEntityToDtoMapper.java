package com.school.school.entityToDtoMapper;

import com.school.school.dto.ProductDto;
import com.school.school.entity.Product;

public class ProductEntityToDtoMapper {

    public static ProductDto getProductDto(ProductDto productDto, Product product){
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setIsExpire(product.getIsExpire());
        productDto.setStatus(product.getStatus());
        productDto.setDateCreated(product.getDateCreated());
       productDto.setUnitPrice(product.getUnitPrice());

        return productDto;

    }




}

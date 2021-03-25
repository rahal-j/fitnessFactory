package com.school.school.service;

import com.school.school.dto.ProductDto;
import com.school.school.dto.ResponseDto;
import com.school.school.entity.Product;

import java.util.List;

public interface ProductService {

    ResponseDto addProduct(ProductDto productDto);

    List<Product> fetchProductList();

    ResponseDto activateProduct(int id);

    ResponseDto deactivateProduct(int id);

    ResponseDto getProductData(int id);

    ResponseDto update(ProductDto productDto);
}

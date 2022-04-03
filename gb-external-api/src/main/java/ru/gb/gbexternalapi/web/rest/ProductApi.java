package ru.gb.gbexternalapi.web.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.gb.gbexternalapi.web.dto.ProductDto;

import java.util.List;

public interface ProductApi {

    List<ProductDto> getProductList();
    ResponseEntity<?> getProduct(Long id);
    ResponseEntity<?> handlePost(ProductDto productDto);
    ResponseEntity<?> handleUpdate(Long id, ProductDto productDto);
    void deleteById(Long id);

}

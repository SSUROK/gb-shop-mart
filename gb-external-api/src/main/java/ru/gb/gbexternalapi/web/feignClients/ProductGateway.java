package ru.gb.gbexternalapi.web.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.gb.gbexternalapi.web.dto.ProductDto;
import ru.gb.gbexternalapi.web.rest.ProductApi;

import java.util.List;

@FeignClient(url = "http://localhost:8080/api/v1/product", name = "ProductGateway")
public interface ProductGateway extends ProductApi {
    @Override
    @GetMapping
    List<ProductDto> getProductList();

    @Override
    @GetMapping("/{productId}")
    ResponseEntity<?> getProduct(@PathVariable("productId") Long id);

    @Override
    @PostMapping
    ResponseEntity<?> handlePost(@Validated @RequestBody ProductDto productDto);

    @Override
    @PutMapping("/{productId}")
    ResponseEntity<?> handleUpdate(@PathVariable("productId") Long id, @Validated @RequestBody ProductDto productDto);

    @Override
    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteById(@PathVariable("productId") Long id);
}

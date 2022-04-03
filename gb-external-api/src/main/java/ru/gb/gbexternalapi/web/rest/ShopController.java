package ru.gb.gbexternalapi.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.gbexternalapi.web.dto.ProductDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/shop")
public class ShopController {

    final ProductApi productApi;

    @GetMapping("/products")
    public List<ProductDto> getProductList() {
        return productApi.getProductList();
    }
}

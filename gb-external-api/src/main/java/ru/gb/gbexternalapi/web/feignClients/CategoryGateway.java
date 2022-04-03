package ru.gb.gbexternalapi.web.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import ru.gb.gbexternalapi.web.dto.CategoryDto;
import ru.gb.gbexternalapi.web.rest.CategoryApi;

import java.util.List;

@FeignClient(url = "http://localhost:8080/api/v1/category", name = "CategoryGateway")
public interface CategoryGateway extends CategoryApi {
    @Override
    List<CategoryDto> getCategoryList();

    @Override
    ResponseEntity<?> getCategory(Long id);

    @Override
    ResponseEntity<?> handlePost(CategoryDto categoryDto);

    @Override
    ResponseEntity<?> handleUpdate(Long id, CategoryDto categoryDto);

    @Override
    void deleteById(Long id);
}

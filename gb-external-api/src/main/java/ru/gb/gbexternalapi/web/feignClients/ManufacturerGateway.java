package ru.gb.gbexternalapi.web.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import ru.gb.gbexternalapi.web.dto.ManufacturerDto;
import ru.gb.gbexternalapi.web.rest.ManufacturerApi;

import java.util.List;

@FeignClient(url = "http://localhost:8080/api/v1/manufacturer", name = "ManufacturerGateway")
public interface ManufacturerGateway extends ManufacturerApi {
    @Override
    List<ManufacturerDto> getManufacturerList();

    @Override
    ResponseEntity<?> getManufacturer(Long id);

    @Override
    ResponseEntity<?> handlePost(ManufacturerDto manufacturerDto);

    @Override
    ResponseEntity<?> handleUpdate(Long id, ManufacturerDto manufacturerDto);

    @Override
    void deleteById(Long id);
}

package ru.gb.gbexternalapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import ru.gb.gbexternalapi.web.feignClients.CategoryGateway;
import ru.gb.gbexternalapi.web.feignClients.ManufacturerGateway;
import ru.gb.gbexternalapi.web.feignClients.ProductGateway;

@SpringBootApplication
@EnableFeignClients(clients = {CategoryGateway.class,
        ProductGateway.class, ManufacturerGateway.class})
public class GbExternalApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(GbExternalApiApplication.class, args);
    }

}

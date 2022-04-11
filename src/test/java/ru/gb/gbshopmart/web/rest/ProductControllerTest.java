package ru.gb.gbshopmart.web.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.gb.gbapi.category.dto.CategoryDto;
import ru.gb.gbapi.common.enums.Status;
import ru.gb.gbapi.manufacturer.dto.ManufacturerDto;
import ru.gb.gbapi.product.dto.ProductDto;
import ru.gb.gbshopmart.entity.Category;
import ru.gb.gbshopmart.entity.Manufacturer;
import ru.gb.gbshopmart.entity.Product;
import ru.gb.gbshopmart.service.CategoryService;
import ru.gb.gbshopmart.service.ManufacturerService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductControllerTest {

    @Mock
    CategoryService categoryService;
    @Mock
    ManufacturerService manufacturerService;

    @InjectMocks
    ManufacturerController manufacturerController;
    @InjectMocks
    CategoryController categoryController;

    List<ManufacturerDto> manufacturers = new ArrayList<>();
    List<CategoryDto> categories = new ArrayList<>();

    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        manufacturers.add(ManufacturerDto.builder().manufacturerId(1L).name("Apple").build());
        manufacturers.add(ManufacturerDto.builder().manufacturerId(2L).name("Microsoft").build());

        categories.add(CategoryDto.builder().id(1L).title("Phone").build());

        mockMvc = MockMvcBuilders.standaloneSetup(manufacturerController, categoryController).build();
    }

//    @Test
//    void getProductList() {
//    }
//
//    @Test
//    void getProduct() {
//    }

    @Test
    void handlePost() throws Exception {
        given(manufacturerService.findAll()).willReturn(manufacturers);
        given(categoryService.findAll()).willReturn(categories);
        mockMvc.perform(post("/api/v1/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\" : \"Iphone 12\",\n" +
                                "    \"cost\": 150.00,\n" +
                                "    \"manufactureDate\": \"01.04.2022\",\n" +
                                "    \"status\": \"ACTIVE\",\n" +
                                "    \"manufacturer\": \"Apple\",\n" +
                                "    \"categories\":[\n" +
                                "        {\n" +
                                "            \"id\": 1\n" +
                                "        }\n" +
                                "    ]}"))
//                        .content(objectMapper
//                                .writeValueAsString(ProductDto.builder()
//                                        .title("Iphone")
//                                        .cost(new BigDecimal("150.00"))
//                                        .manufactureDate(LocalDate.now())
//                                        .status(Status.ACTIVE)
//                                        .manufacturer("Apple")
//                                        .categories(new HashSet<>(Arrays.asList(categories.get(0))))
//                                        .build())))
                .andExpect(status().isCreated());
    }

//    @Test
//    void handleUpdate() {
//    }
//
//    @Test
//    void deleteById() {
//    }
}
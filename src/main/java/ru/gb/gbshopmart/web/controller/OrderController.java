package ru.gb.gbshopmart.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.gbapi.product.dto.ProductDto;
import ru.gb.gbshopmart.service.ProductService;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

	@GetMapping()
	public String createOrder(Model model) {
		return "order-create";
	}

	@GetMapping("/status")
	public String getProduct(Model model) {
		return "order-status";
	}

}
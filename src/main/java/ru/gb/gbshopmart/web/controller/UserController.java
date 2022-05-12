package ru.gb.gbshopmart.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.gbapi.security.AuthenticationUserDto;
import ru.gb.gbapi.security.UserDto;
//import ru.gb.gbshopmart.entity.User;
import ru.gb.gbshopmart.service.UserService;


import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

	private final UserService userService;


	@GetMapping("/register")
	public String getRegister(Model model) {
		UserDto user = new UserDto();
		model.addAttribute("user", user);
		return "signin";
	}

	@PostMapping
	public String registerUser(UserDto user) {
		ResponseEntity<UserDto> response = userService.register(user);
		if (response.getStatusCode() == HttpStatus.CREATED)
			return "redirect:/product";
		else
			return "signin";
	}
}

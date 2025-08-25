package com.example.demo.thymeleaf.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.common.dao.entity.User;
import com.example.demo.common.dao.mapper.UserMapper;

import jakarta.validation.Valid;

@Controller
public class HomePageController {
	@Autowired
	private UserMapper userMapper;
	
	@GetMapping("/")
	public String stratView() {
		return "homePage";
	}
	
	@GetMapping("/register")
	public String registarView(@ModelAttribute("user") User user) {
		return "register";
	}
	
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute User user,
								BindingResult result,
								Model model) {
		if(userMapper.existsByUsername(user.getUsername())) {
			result.rejectValue("username", "error.user", "このユーザー名はすでに使用されています");
		}
		if(result.hasErrors()) {
			return "register";
		}
		
		userMapper.save(user);
		return "redirect:/login";
	}

}

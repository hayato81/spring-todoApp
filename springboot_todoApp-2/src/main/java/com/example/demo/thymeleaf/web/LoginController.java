package com.example.demo.thymeleaf.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.common.dao.entity.Login;
import com.example.demo.common.dao.mapper.LoginMapper;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	@Autowired
	LoginMapper loginMapper;
	
	public LoginController(LoginMapper loginMapper) {
        this.loginMapper = loginMapper;
    }
	
	@GetMapping("/login")
	public String loginVuew() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam String username,
						@RequestParam String password,
						HttpSession session,
						Model model){
		
		Login login = loginMapper.findByUsername(username).orElse(null);
		
		if(login == null) {
			model.addAttribute("error", "パスワードが違います");
			return "login";
		}
		 session.setAttribute("loginUser", login);
	     return "redirect:/tasks";
	     
	}
	@GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // セッション破棄
        return "redirect:/login";
    }
}

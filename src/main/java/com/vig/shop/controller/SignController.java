package com.vig.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignController {
	@RequestMapping(value = "home")
	public String homey() {
		return "index";
	}
}

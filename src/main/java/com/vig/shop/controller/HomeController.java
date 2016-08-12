package com.vig.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vig.shop.model.Register;
import com.vig.shop.service.RegisterService;

@Controller
public class HomeController {
	@Autowired
	RegisterService rs;

	@ModelAttribute("ion")
	public Register newuser() {
		return new Register();
	}

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "Login")
	public String log() {
		return "sign";
	}

	@RequestMapping(value = "Register")
	public String reg() {
		return "register";
	}

	@RequestMapping(value = "/brand")
	public String brand() {
		return "brand";

	}

	@RequestMapping(value = "/viewprod")
	public String prod() {
		return "viewprod";
	}

	@RequestMapping(value = "fregister", method = RequestMethod.POST)

	public ModelAndView reg(@ModelAttribute("ion") Register regs) {
		ModelAndView mv = new ModelAndView("sign");
		rs.saveOrUpdate(regs);
		return mv;
	}

}

package com.vig.shop.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vig.shop.model.Product;
import com.vig.shop.service.ProductService;

@Controller(value = "products")
public class ProductController {
	@Autowired(required = true)
	ProductService ps;

	@ModelAttribute("ob")
	public Product link() {
		return new Product();
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String setForm() {
		return "products";
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String doActions(@ModelAttribute("ob") Product product, BindingResult result, @RequestParam String action,
			Map<String, Object> map) {
		Product productResult = new Product();
		switch (action.toLowerCase()) { // only in Java7 you can put String in
										// switch
		case "save":
			ps.save(product);
			System.out.println(ps);
			productResult = product;
			break;
		case "update":
			ps.update(product);
			productResult = product;
			break;
		case "delete":
			ps.delete(product.getProductId());
			productResult = new Product();
			break;
		case "search":
			Product searchedProduct = ps.getproduct(product.getProductId());
			productResult = searchedProduct != null ? searchedProduct : new Product();
			break;
		}
		map.put("product", productResult);
		map.put("productList", ps.getAllproduct());
		return "products";
	}
}

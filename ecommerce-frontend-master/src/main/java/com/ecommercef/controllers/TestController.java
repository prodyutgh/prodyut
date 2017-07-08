package com.ecommercef.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.model.Product;
import com.ecommerce.service.ProductService;


@Controller
public class TestController {
	
	@Autowired
	private ProductService productService;
	@RequestMapping (value="/test")
	public String getIndex(ModelMap map){
		List<Product> products = productService.getAllProducts();
		map.addAttribute("products", products);
		return "index";
	}
}

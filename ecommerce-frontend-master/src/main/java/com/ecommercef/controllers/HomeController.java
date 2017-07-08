package com.ecommercef.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.model.Product;
import com.ecommerce.model.ProductCategory;
import com.ecommerce.service.ProductCategoryService;
import com.ecommerce.service.ProductService;


@Controller
public class HomeController extends BaseController{
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductCategoryService productCategoryService;
	
	@RequestMapping (value={"/"})
	public String getIndex(ModelMap model){
		this.getHomePage(model);
		return "home";
	}
	
	@RequestMapping (value={"/{productCategoryId}"})
	public String getIndexByCategory(@PathVariable int productCategoryId, ModelMap model){
		ProductCategory selectedProductCategory = productCategoryService.getProductCategory(productCategoryId);
		model.addAttribute("selectedProductCategory", selectedProductCategory);
		this.getHomePage(model);
		return "home";
	}
	
	private void getHomePage(ModelMap model){
		List<ProductCategory> productCategories = productCategoryService.getAllProductCategories();
		model.addAttribute("productCategories", productCategories);
		List<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);
		model.addAttribute("loggedInUser", getPrincipal());
	}	
	 @RequestMapping("/about")
	    public String about(){
	        return "about";
	    }
}

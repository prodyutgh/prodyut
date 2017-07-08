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
public class ProductDetailsController extends BaseController{
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductCategoryService productCategoryService;
	
	@RequestMapping (value={"/product/{productId}"})
	public String getProductDetail(@PathVariable int productId, ModelMap model){
		List<ProductCategory> productCategories = productCategoryService.getAllProductCategories();
		model.addAttribute("productCategories", productCategories);
		Product selectedProduct = productService.getProduct(productId);
		model.addAttribute("selectedProduct", selectedProduct);
		model.addAttribute("selectedProductCategory", selectedProduct.getProductCategory());

		model.addAttribute("loggedInUser", getPrincipal());
		return "product-details";
	}	
}

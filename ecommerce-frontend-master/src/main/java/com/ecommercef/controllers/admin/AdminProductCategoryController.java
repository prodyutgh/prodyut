package com.ecommercef.controllers.admin;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecommerce.model.ProductCategory;
import com.ecommerce.service.ProductCategoryService;
import com.ecommercef.controllers.BaseController;


@Controller
public class AdminProductCategoryController extends BaseController{
	@Autowired
	private ProductCategoryService productCategoryService;
	
	@Autowired
	private ProductCategory productCategory;
	
	@RequestMapping (value="/admin/product-categories/list", method = RequestMethod.GET)
	public String getProductList(ModelMap model){
		List<ProductCategory> productCategories = productCategoryService.getAllProductCategories();
		model.addAttribute("productCategories", productCategories);
		model.addAttribute("loggedInUser", getPrincipal());
		return "admin/product-categories/list";
	}
	
	@RequestMapping (value="/admin/product-categories/add", method = RequestMethod.GET)
	public String addProductCategory(ModelMap model){
		model.addAttribute("productCategory", productCategory);
		model.addAttribute("loggedInUser", getPrincipal());
		return "admin/product-categories/edit";
	}
	
	@RequestMapping (value="/admin/product-categories/add", method = RequestMethod.POST)
	public String addProductCategorySubmit(@ModelAttribute("productCategory") ProductCategory productCategory){
		System.out.println("add post -> addProductCategorySubmit executed");
		productCategoryService.addProductCategory(productCategory);
		return "redirect:/admin/product-categories/list";
	}
	
	@RequestMapping (value="/admin/product-categories/edit/{productCategoryId}", method = RequestMethod.GET)
	public String editProduct(@PathVariable int productCategoryId, ModelMap model){
		List<ProductCategory> productCategories = productCategoryService.getAllProductCategories();
		model.addAttribute("productCategories", productCategories);
		ProductCategory productCategory = productCategoryService.getProductCategory(productCategoryId);
		model.addAttribute("productCategory", productCategory);
		model.addAttribute("loggedInUser", getPrincipal());
		return "admin/product-categories/edit";
	}
	
	@RequestMapping (value="/admin/product-categories/edit/{productCategoryId}", method = RequestMethod.POST)
	public String editProductSubmit(@ModelAttribute("productCategory") ProductCategory productCategory, @PathVariable int productCategoryId){
		System.out.println("edit post -> editProductCategorySubmit executed");
		productCategory.setId(productCategoryId);
		productCategoryService.updateProductCategory(productCategory);
		//return "admin/products/edit";
		return "redirect:/admin/product-categories/list";
	}
	
	@RequestMapping (value="/admin/product-categories/confirm-delete/{productCategoryId}", method = RequestMethod.GET)
	public String confirmProductCategoryDelete(@PathVariable int productCategoryId, ModelMap model){
		ProductCategory productCategory = productCategoryService.getProductCategory(productCategoryId);
		model.addAttribute("productCategory", productCategory);
		model.addAttribute("loggedInUser", getPrincipal());
		return "admin/product-categories/confirm-delete";
	}

	@RequestMapping (value="/admin/product-categories/delete", method = RequestMethod.POST)
	public String productCategoryDelete(@ModelAttribute("productCategory") ProductCategory productCategory){
		System.out.println("productCategory to be deleted: productCategoryId : " + productCategory.getId());
		productCategoryService.deleteProductCategory(productCategory);
		return "redirect:/admin/product-categories/list";
	}

}

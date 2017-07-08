package com.ecommercef.controllers.admin;


import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.model.Product;
import com.ecommerce.model.ProductCategory;
import com.ecommerce.model.UserSupplier;
import com.ecommerce.service.ProductCategoryService;
import com.ecommerce.service.ProductService;
import com.ecommerce.service.UserSupplierService;
import com.ecommercef.controllers.BaseController;


@Controller
public class AdminProductController extends BaseController{
	
	private Path path;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductCategoryService productCategoryService;
	
	@Autowired
	private UserSupplierService userSupplierService;
	
	@Autowired
	private Product product;
	
	@RequestMapping (value="/admin/products/list", method = RequestMethod.GET)
	public String getProductList(ModelMap model){
		List<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);
		model.addAttribute("loggedInUser", getPrincipal());
		return "admin/products/list";
	}
	
	@RequestMapping (value="/admin/products/add", method = RequestMethod.GET)
	public String addProduct(ModelMap model, HttpServletRequest request){
		List<UserSupplier> userSuppliers = userSupplierService.getAllSuppliers();
		model.addAttribute("userSuppliers", userSuppliers);
		List<ProductCategory> productCategories = productCategoryService.getAllProductCategories();
		model.addAttribute("productCategories", productCategories);
		model.addAttribute("product", product);
		model.addAttribute("loggedInUser", getPrincipal());
		return "admin/products/edit";
	}
	
	@RequestMapping (value="/admin/products/add", method = RequestMethod.POST)
	public String addProductSubmit(@Valid @ModelAttribute("product") Product product, @RequestParam("file") MultipartFile file, HttpServletRequest request){
		System.out.println("addProductSubmit executed");
		String productImageName = this.handleProductImageUpload(request, product);
		if(!productImageName.isEmpty()){
			product.setImage_name(productImageName);
		}
		productService.addProduct(product);
		
		return "redirect:/admin/products/list";
	}
	
	/* This function will be used upload product image from add/edit form.
	 * 
	 * @param HttpServletRequest request
	 * @param Product product Submitted product form
	 * 
	 * @return String product image name uploaded on sevrer.
	 */
	private String handleProductImageUpload(HttpServletRequest request, Product product){
		MultipartFile image = product.getFile();
		String productImageName = image.getOriginalFilename();
		if(!productImageName.isEmpty()){
			String productImageNameExt = productImageName.substring(productImageName.lastIndexOf('.'));
			productImageName = product.getId() + productImageNameExt;
			String rootDir = request.getSession().getServletContext().getRealPath("/");
			path = Paths.get(rootDir + "/resources/uploads/products/" + productImageName);
			if(image != null && !image.isEmpty()){
				try{
					System.out.println("Product Image upload: " + path.toString());
					image.transferTo(new File(path.toString()));
					
				}catch(Exception e){
					e.printStackTrace();
					throw new RuntimeException("Image save failed" + e);
				}
			}
		}
		
		return productImageName;
	}
	
	@RequestMapping (value="/admin/products/edit/{productId}", method = RequestMethod.GET)
	public String editProduct(@PathVariable int productId, ModelMap model){
		List<UserSupplier> userSuppliers = userSupplierService.getAllSuppliers();
		model.addAttribute("userSuppliers", userSuppliers);
		List<ProductCategory> productCategories = productCategoryService.getAllProductCategories();
		model.addAttribute("productCategories", productCategories);
		Product product = productService.getProduct(productId);
		model.addAttribute("product", product);
		model.addAttribute("loggedInUser", getPrincipal());
		return "admin/products/edit";
	}
	
	@RequestMapping (value="/admin/products/edit/{productId}", method = RequestMethod.POST)
	public String editProductSubmit(@ModelAttribute("product") Product product, @PathVariable int productId, @RequestParam("file") MultipartFile file, HttpServletRequest request){
		System.out.println("edit post -> editProductSubmit executed");
		product.setId(productId);
		String productImageName = this.handleProductImageUpload(request, product);
		if(!productImageName.isEmpty()){
			product.setImage_name(productImageName);
		}
		productService.updateProduct(product);
		//return "admin/products/edit";
		return "redirect:/admin/products/list";
	}
	
	@RequestMapping (value="/admin/products/confirm-delete/{productId}", method = RequestMethod.GET)
	public String confirmProductDelete(@PathVariable int productId, ModelMap model){
		Product product = productService.getProduct(productId);
		model.addAttribute("product", product);
		model.addAttribute("loggedInUser", getPrincipal());
		return "admin/products/confirm-delete";
	}

	@RequestMapping (value="/admin/products/delete", method = RequestMethod.POST)
	public String productDelete(@ModelAttribute("product") Product product){
		System.out.println("Product to be deleted: ProductId : " + product.getId());
		productService.deleteProduct(product);
		return "redirect:/admin/products/list";
	}

}

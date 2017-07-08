package com.ecommercef.controllers.admin;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecommerce.model.Inventory;
import com.ecommerce.model.Product;
import com.ecommerce.model.UserSupplier;
import com.ecommerce.service.InventoryService;
import com.ecommerce.service.ProductCategoryService;
import com.ecommerce.service.ProductService;
import com.ecommerce.service.UserSupplierService;
import com.ecommercef.controllers.BaseController;

@Controller
public class SupplierInventoryController extends BaseController {
	
	@Autowired
	private UserSupplierService userSupplierService;
	
	@Autowired
	private Inventory inventory;

	@Autowired
	private InventoryService inventoryService;

	@Autowired
	private ProductService productService;
	
	@Autowired
	private Product product;
	
	@RequestMapping(value = "/admin/suppliers/{userSupplierId}/inventory/list", method = RequestMethod.GET)
	public String getUserSupplierInventoryList(@PathVariable int userSupplierId, ModelMap model) {
		UserSupplier userSupplier = userSupplierService.getSupplier(userSupplierId);
		List<Inventory> inventoryList = inventoryService.getAllInventoryBySupplier(userSupplierId);
		model.addAttribute("userSupplier", userSupplier);
		model.addAttribute("inventoryList", inventoryList);
		model.addAttribute("loggedInUser", getPrincipal());
		return "admin/suppliers/inventory/list";
	}

	@RequestMapping(value = "/admin/suppliers/{userSupplierId}/inventory/add", method = RequestMethod.GET)
	public String getAddUserSupplierInventoryForm(@PathVariable int userSupplierId, ModelMap model) {
		List<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);
		UserSupplier userSupplier = userSupplierService.getSupplier(userSupplierId);
		model.addAttribute("userSupplier", userSupplier);
		model.addAttribute("inventory", inventory);
		model.addAttribute("loggedInUser", getPrincipal());
		return "admin/suppliers/inventory/edit";
	}

	@RequestMapping(value = "/admin/suppliers/{userSupplierId}/inventory/add", method = RequestMethod.POST)
	public String submitAddUserSupplierInventoryForm(@PathVariable int userSupplierId, @Valid @ModelAttribute("inventory") Inventory inventory) {
		Product product = productService.getProduct(inventory.getProduct().getId());
		inventory.setProduct(product);
		UserSupplier userSupplier = userSupplierService.getSupplier(userSupplierId);
		inventory.setSupplier(userSupplier);
		inventoryService.addProductInventory(inventory);
		System.out.println("Supplier inventory added successfully!!!");
		return "redirect:/admin/suppliers/" + userSupplierId +"/inventory/list";
	}
	
	@RequestMapping(value = "/admin/suppliers/{userSupplierId}/inventory/edit/{userSupplierInventoryId}", method = RequestMethod.GET)
	public String getEditUserSupplierInventoryForm(@PathVariable int userSupplierId, @PathVariable int userSupplierInventoryId, ModelMap model) {
		List<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);
		Inventory inventory = inventoryService.getProductInventory(userSupplierInventoryId); 
		model.addAttribute("userSupplier", inventory.getSupplier());
		model.addAttribute("inventory", inventory);
		model.addAttribute("loggedInUser", getPrincipal());
		return "admin/suppliers/inventory/edit";
	}

	@RequestMapping(value = "/admin/suppliers/{userSupplierId}/inventory/edit/{userSupplierInventoryId}", method = RequestMethod.POST)
	public String submitEditUserSupplierInventoryForm(@PathVariable int userSupplierId, @PathVariable int userSupplierInventoryId, @Valid @ModelAttribute("inventory") Inventory inventoryForm) {
		Inventory inventory = inventoryService.getProductInventory(userSupplierInventoryId);
		Product product = productService.getProduct(inventoryForm.getProduct().getId());
		inventory.setProduct(product);
		inventory.setQuantity(inventoryForm.getQuantity());
		inventory.setProduct_title(inventoryForm.getProduct_title());
		inventoryService.updateProductInventory(inventory);
		System.out.println("Product Inventory added successfully!!!");
		return "redirect:/admin/suppliers/" + userSupplierId +"/inventory/list";
	}
	
	
	@RequestMapping (value="/admin/suppliers/{userSupplierId}/inventory/confirm-delete/{userSupplierInventoryId}", method = RequestMethod.GET)
	public String confirmProductCategoryDelete(@PathVariable int userSupplierId, @PathVariable int userSupplierInventoryId, ModelMap model){
		Inventory inventory = inventoryService.getProductInventory(userSupplierInventoryId);
		model.addAttribute("inventory", inventory);
		model.addAttribute("loggedInUser", getPrincipal());
		return "admin/product-categories/confirm-delete";
	}

	@RequestMapping (value="/admin/suppliers/{userSupplierId}/inventory/delete", method = RequestMethod.POST)
	public String productCategoryDelete(@PathVariable int userSupplierId, @ModelAttribute("inventory") Inventory inventory){
		System.out.println("Product Inventory to be deleted: inventory.id : " + inventory.getId());
		//inventoryService.deleteProductInventoryBySupplier(userId, productId);
		return "redirect:/admin/suppliers/" + userSupplierId +"/inventory/list";
	}
}

package in.rudresh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.rudresh.entity.Product;
import in.rudresh.service.ProductService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService service;

	// 1️. Show Register Page
	@GetMapping("/register")
	public String showRegister(Model model) {
		model.addAttribute("product", new Product());
		return "product-register"; // product-register.html
	}

	// 2️. Save Product
	@PostMapping("/save")
	public String saveProduct(@Valid @ModelAttribute Product product,BindingResult result, Model model) {
		if(result.hasErrors()) {
			System.out.println();
			return "product-register";
		}
		Integer id = service.saveProduct(product);
		model.addAttribute("message", "Product saved with ID : " + id);
		model.addAttribute("product", new Product());
		return "product-register";
	}

	// 3️. View All Products
	@GetMapping("/all")
	public String getAllProducts(Model model) {
		List<Product> list = service.getAllProducts();
		model.addAttribute("list", list);
		return "product-list"; // product-list.html
	}

	// 4️. Delete Product
	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Integer id) {
		service.deleteProduct(id);
		return "redirect:/product/all";
	}

	// 5️. Edit Product
	@GetMapping("/edit/{id}")
	public String editProduct(@PathVariable Integer id, Model model) {
		Product product = service.getOneProduct(id);
		model.addAttribute("product", product);
		return "product-edit"; // product-edit.html
	}

	// 6️. Update Product
	@PostMapping("/update")
	public String updateProduct(@ModelAttribute Product product) {
		service.updateProduct(product);
		return "redirect:/product/all";
	}
}

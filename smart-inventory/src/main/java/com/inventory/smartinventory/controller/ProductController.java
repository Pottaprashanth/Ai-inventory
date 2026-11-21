package com.inventory.smartinventory.controller;

import com.inventory.smartinventory.entity.Product;
import com.inventory.smartinventory.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")

public class ProductController {
	private final ProductService service;

	public ProductController(ProductService s) {
		service = s;
	}

	@PostMapping
	public Product add(@Valid @RequestBody Product p) {
		return service.addProduct(p);
	}

	@GetMapping
	public List<Product> all() {
		return service.getAllProducts();
	}

	@GetMapping("/{id}")
	public Product one(@PathVariable Long id) {
		return service.getProductById(id);
	}

	@PutMapping("/{id}")
	public Product update(@PathVariable Long id, @Valid @RequestBody Product p) {
		return service.updateProduct(id, p);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.deleteProduct(id);
	}

	@GetMapping("/low-stock")
	public List<Product> low() {
		return service.getLowStockProducts();
	}
}

package com.inventory.smartinventory.controller;

import com.inventory.smartinventory.entity.StockTransaction;
import com.inventory.smartinventory.service.StockService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/stock")

public class StockController {
	private final StockService service;

	public StockController(StockService s) {
		service = s;
	}

	@PostMapping("/in")
	public StockTransaction in(@RequestBody Map<String, Object> b) {
		return service.stockIn(Long.valueOf(b.get("productId").toString()),
				Integer.parseInt(b.get("quantity").toString()), Objects.toString(b.get("note"), ""));
	}

	@PostMapping("/out")
	public StockTransaction out(@RequestBody Map<String, Object> b) {
		return service.stockOut(Long.valueOf(b.get("productId").toString()),
				Integer.parseInt(b.get("quantity").toString()), Objects.toString(b.get("note"), ""));
	}

	@GetMapping("/transactions")
	public List<StockTransaction> all() {
		return service.getAllTransactions();
	}
}

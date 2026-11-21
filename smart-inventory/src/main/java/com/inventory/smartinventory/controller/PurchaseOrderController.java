package com.inventory.smartinventory.controller;

import com.inventory.smartinventory.entity.PurchaseOrder;
import com.inventory.smartinventory.service.PurchaseOrderService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/purchase-orders")

public class PurchaseOrderController {
	private final PurchaseOrderService service;

	public PurchaseOrderController(PurchaseOrderService s) {
		service = s;
	}

	@PostMapping
	public PurchaseOrder create(@RequestBody PurchaseOrder o) {
		return service.create(o);
	}

	@GetMapping
	public List<PurchaseOrder> all() {
		return service.getAll();
	}

	@PatchMapping("/{id}/status")
	public PurchaseOrder status(@PathVariable Long id, @RequestParam String value) {
		return service.updateStatus(id, value);
	}
}

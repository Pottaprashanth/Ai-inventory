package com.inventory.smartinventory.controller;

import com.inventory.smartinventory.service.DashboardService;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")

public class DashboardController {
	private final DashboardService service;

	public DashboardController(DashboardService s) {
		service = s;
	}

	@GetMapping
	public Map<String, Object> summary() {
		return service.getSummary();
	}
}

package com.inventory.smartinventory.serviceimpl;

import com.inventory.smartinventory.entity.Product;
import com.inventory.smartinventory.repository.ProductRepository;
import com.inventory.smartinventory.service.AIService;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class AIServiceImpl implements AIService {
	private final ProductRepository products;

	public AIServiceImpl(ProductRepository p) {
		products = p;
	}

	public Map<String, Object> getRecommendations() {
		List<Product> low = products.findAll().stream().filter(p -> p.getQuantity() <= p.getMinStock()).toList();
		List<Map<String, Object>> recs = low.stream().map(p -> {
			Map<String, Object> r = new LinkedHashMap<>();
			r.put("productId", p.getId());
			r.put("productName", p.getName());
			r.put("currentQuantity", p.getQuantity());
			r.put("minimumStock", p.getMinStock());
			r.put("suggestedOrderQuantity", Math.max(p.getMinStock() * 2 - p.getQuantity(), 1));
			r.put("reason", "Current stock is at or below the configured minimum.");
			return r;
		}).toList();
		return Map.of("type", "rule-based inventory recommendations", "recommendations", recs, "note",
				"These are rule-based suggestions, not a trained demand forecast.");
	}

	public String ask(String question) {
		if (question == null || question.isBlank())
			return "Please enter a question.";
		List<Product> low = products.findAll().stream().filter(p -> p.getQuantity() <= p.getMinStock()).toList();
		if (question.toLowerCase().contains("low") || question.toLowerCase().contains("stock"))
			return "There are " + low.size()
					+ " products at or below their minimum stock level. Open the low-stock list to review reorder quantities.";
		return "I can currently answer basic inventory questions. Try asking: Which products are low in stock?";
	}
}

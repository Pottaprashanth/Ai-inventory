package com.inventory.smartinventory.controller;

import com.inventory.smartinventory.service.AIService;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/ai")
@CrossOrigin(origins = "http://localhost:5173")
public class AIController {

    private final AIService service;

    public AIController(AIService service) {
        this.service = service;
    }

    @GetMapping("/recommendations")
    public Map<String, Object> recommendations() {
        return service.getRecommendations();
    }

    @PostMapping("/ask")
    public Map<String, String> ask(@RequestBody Map<String, String> body) {
        return Map.of("answer", service.ask(body.get("question")));
    }
}
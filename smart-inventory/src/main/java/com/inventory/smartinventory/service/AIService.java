package com.inventory.smartinventory.service;
import java.util.Map;
public interface AIService { Map<String,Object> getRecommendations(); String ask(String question); }

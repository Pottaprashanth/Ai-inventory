package com.inventory.smartinventory.service;
import com.inventory.smartinventory.entity.StockTransaction; import java.util.List;
public interface StockService { StockTransaction stockIn(Long productId,int quantity,String note); StockTransaction stockOut(Long productId,int quantity,String note); List<StockTransaction> getAllTransactions(); }

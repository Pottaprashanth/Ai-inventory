package com.inventory.smartinventory.service;
import com.inventory.smartinventory.entity.PurchaseOrder; import java.util.List;
public interface PurchaseOrderService { PurchaseOrder create(PurchaseOrder order); List<PurchaseOrder> getAll(); PurchaseOrder updateStatus(Long id,String status); }

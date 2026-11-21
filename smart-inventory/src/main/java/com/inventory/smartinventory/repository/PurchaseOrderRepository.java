package com.inventory.smartinventory.repository;
import com.inventory.smartinventory.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder,Long> {
}

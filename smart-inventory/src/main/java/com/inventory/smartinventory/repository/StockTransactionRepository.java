package com.inventory.smartinventory.repository;
import com.inventory.smartinventory.entity.StockTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface StockTransactionRepository extends JpaRepository<StockTransaction,Long> {
}

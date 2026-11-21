package com.inventory.smartinventory.serviceimpl;
import com.inventory.smartinventory.repository.*; import com.inventory.smartinventory.service.DashboardService; import org.springframework.stereotype.Service; import java.util.*;
@Service public class DashboardServiceImpl implements DashboardService {
 private final ProductRepository products;private final SupplierRepository suppliers;private final PurchaseOrderRepository orders;private final StockTransactionRepository tx;
 public DashboardServiceImpl(ProductRepository p,SupplierRepository s,PurchaseOrderRepository o,StockTransactionRepository t){products=p;suppliers=s;orders=o;tx=t;}
 public Map<String,Object> getSummary(){var all=products.findAll();int units=all.stream().mapToInt(x->x.getQuantity()).sum();long low=all.stream().filter(x->x.getQuantity()<=x.getMinStock()).count();Map<String,Object> m=new LinkedHashMap<>();m.put("totalProducts",all.size());m.put("totalUnits",units);m.put("lowStockProducts",low);m.put("totalSuppliers",suppliers.count());m.put("totalPurchaseOrders",orders.count());m.put("totalStockTransactions",tx.count());return m;}
}

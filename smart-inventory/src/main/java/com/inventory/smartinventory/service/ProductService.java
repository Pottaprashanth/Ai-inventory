package com.inventory.smartinventory.service;
import com.inventory.smartinventory.entity.Product; import java.util.List;
public interface ProductService { Product addProduct(Product p); List<Product> getAllProducts(); Product getProductById(Long id); Product updateProduct(Long id,Product p); void deleteProduct(Long id); List<Product> getLowStockProducts(); }

package com.inventory.smartinventory.serviceimpl;
import com.inventory.smartinventory.entity.*; import com.inventory.smartinventory.repository.*; import com.inventory.smartinventory.service.ProductService;
import org.springframework.stereotype.Service; import org.springframework.http.HttpStatus; import org.springframework.web.server.ResponseStatusException; import java.util.List;
@Service public class ProductServiceImpl implements ProductService {
 private final ProductRepository products; private final SupplierRepository suppliers;
 public ProductServiceImpl(ProductRepository p,SupplierRepository s){products=p;suppliers=s;}
 public Product addProduct(Product p){if(p.getQuantity()<0||p.getMinStock()<0)throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Stock values cannot be negative"); attachSupplier(p); return products.save(p);}
 public List<Product> getAllProducts(){return products.findAll();}
 public Product getProductById(Long id){return products.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Product not found"));}
 public Product updateProduct(Long id,Product p){Product old=getProductById(id); old.setName(p.getName());old.setSku(p.getSku());old.setCategory(p.getCategory());old.setPrice(p.getPrice());old.setMinStock(p.getMinStock());if(p.getMinStock()<0)throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Minimum stock cannot be negative");old.setSupplier(resolveSupplier(p.getSupplier()));return products.save(old);}
 public void deleteProduct(Long id){products.delete(getProductById(id));}
 public List<Product> getLowStockProducts(){return products.findAll().stream().filter(p->p.getQuantity()<=p.getMinStock()).toList();}
 private void attachSupplier(Product p){p.setSupplier(resolveSupplier(p.getSupplier()));}
 private Supplier resolveSupplier(Supplier s){if(s==null||s.getId()==null)return null;return suppliers.findById(s.getId()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Supplier not found"));}
}

package com.inventory.smartinventory.serviceimpl;
import com.inventory.smartinventory.entity.*; import com.inventory.smartinventory.repository.*; import com.inventory.smartinventory.service.StockService;
import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional; import org.springframework.http.HttpStatus; import org.springframework.web.server.ResponseStatusException; import java.util.List;
@Service public class StockServiceImpl implements StockService {
 private final ProductRepository products; private final StockTransactionRepository transactions;
 public StockServiceImpl(ProductRepository p,StockTransactionRepository t){products=p;transactions=t;}
 @Transactional public StockTransaction stockIn(Long id,int qty,String note){if(qty<=0)throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Quantity must be greater than zero");Product p=find(id);p.setQuantity(p.getQuantity()+qty);products.save(p);return save(p,"IN",qty,note);}
 @Transactional public StockTransaction stockOut(Long id,int qty,String note){if(qty<=0)throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Quantity must be greater than zero");Product p=find(id);if(p.getQuantity()<qty)throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Insufficient stock");p.setQuantity(p.getQuantity()-qty);products.save(p);return save(p,"OUT",qty,note);}
 public List<StockTransaction> getAllTransactions(){return transactions.findAll();}
 private Product find(Long id){return products.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Product not found"));}
 private StockTransaction save(Product p,String type,int qty,String note){StockTransaction t=new StockTransaction();t.setProduct(p);t.setType(type);t.setQuantity(qty);t.setNote(note);return transactions.save(t);}
}

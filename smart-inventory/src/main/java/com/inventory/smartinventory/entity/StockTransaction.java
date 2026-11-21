package com.inventory.smartinventory.entity;
import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity @Table(name="stock_transactions")
public class StockTransaction {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) @JoinColumn(name="product_id") private Product product;
 private String type; private int quantity; private LocalDateTime transactionDate; private String note;
 @PrePersist void onCreate(){if(transactionDate==null) transactionDate=LocalDateTime.now();}
 public Long getId(){return id;} public Product getProduct(){return product;} public void setProduct(Product v){product=v;}
 public String getType(){return type;} public void setType(String v){type=v;} public int getQuantity(){return quantity;} public void setQuantity(int v){quantity=v;}
 public LocalDateTime getTransactionDate(){return transactionDate;} public String getNote(){return note;} public void setNote(String v){note=v;}
}

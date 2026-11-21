package com.inventory.smartinventory.entity;
import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity @Table(name="purchase_orders")
public class PurchaseOrder {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) @JoinColumn(name="product_id") private Product product;
 @ManyToOne @JoinColumn(name="supplier_id") private Supplier supplier;
 private int quantity; private String status="PENDING"; private LocalDateTime createdAt;
 @PrePersist void onCreate(){if(createdAt==null) createdAt=LocalDateTime.now();}
 public Long getId(){return id;} public Product getProduct(){return product;} public void setProduct(Product v){product=v;}
 public Supplier getSupplier(){return supplier;} public void setSupplier(Supplier v){supplier=v;} public int getQuantity(){return quantity;} public void setQuantity(int v){quantity=v;}
 public String getStatus(){return status;} public void setStatus(String v){status=v;} public LocalDateTime getCreatedAt(){return createdAt;}
}

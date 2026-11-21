package com.inventory.smartinventory.entity;
import jakarta.persistence.*; import jakarta.validation.constraints.*; import java.math.BigDecimal;
@Entity @Table(name="products")
public class Product {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank private String name; private String sku; private String category;
 @NotNull @DecimalMin("0.0") private BigDecimal price=BigDecimal.ZERO;
 @Min(0) private int quantity; @Min(0) private int minStock;
 @ManyToOne(fetch=FetchType.EAGER) @JoinColumn(name="supplier_id") private Supplier supplier;
 public Long getId(){return id;} public void setId(Long v){id=v;} public String getName(){return name;} public void setName(String v){name=v;}
 public String getSku(){return sku;} public void setSku(String v){sku=v;} public String getCategory(){return category;} public void setCategory(String v){category=v;}
 public BigDecimal getPrice(){return price;} public void setPrice(BigDecimal v){price=v;} public int getQuantity(){return quantity;} public void setQuantity(int v){quantity=v;}
 public int getMinStock(){return minStock;} public void setMinStock(int v){minStock=v;} public Supplier getSupplier(){return supplier;} public void setSupplier(Supplier v){supplier=v;}
}

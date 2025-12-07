package com.example.jsonbdemo.entity;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import java.util.Map;
@Entity
@Table(name = "orders")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private Map<String, Object> metadata;
    public Order() {}
    public Order(String customerName, Map<String, Object> metadata) {
        this.customerName = customerName;
        this.metadata = metadata;
    }
    public Long getId() { return id; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public Map<String, Object> getMetadata() { return metadata; }
    public void setMetadata(Map<String, Object> metadata) { this.metadata = metadata; }
}
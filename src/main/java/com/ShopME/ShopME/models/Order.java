package com.ShopME.ShopME.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

/**
 * $table.getTableComment()
 */

@Data
@Entity
@Table(name = "order_")
public class Order implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "order_id", nullable = false)
    private String orderId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "coupon_id")
    private String couponId;

    @Column(name = "date")
    private Date date;

    @Column(name = "amount")
    private Long amount;



    public Order(String userId, Long quantity,String couponId) {
        this.orderId = generateUniqueCouponId();
        this.userId = userId;
        this.productId = "pd0021";
        this.quantity = quantity;
        this.couponId = couponId;
        this.amount = 100*quantity;
        LocalDate currentDate = LocalDate.now();
        this.date = Date.valueOf(currentDate);
    }
    
    public Order(){}

    public String getOrderId() {
        return orderId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public String getCouponId() {
        return couponId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Generate order id
     * @return order id
     */
    private String generateUniqueCouponId() {
        String uuid = UUID.randomUUID().toString();
        return uuid.substring(0, Math.min(uuid.length(), 20));
    }
}

package com.ShopME.ShopME.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Random;
import java.util.UUID;

/**
 * $table.getTableComment()
 */
@Data
@Entity
@Table(name = "coupon")
public class Coupon implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "coupon_id", nullable = false)
    private String couponId;

    @Column(name = "coupon_quantity")
    private Long couponQuantity;


    public Coupon() {
        this.couponId = generateRandomCouponType();
        this.couponQuantity = generateRandomCouponQuantity();
    }

    /**
     * function generates random quantity of coupons between
     * 2 and 10 inclusively as a long
     * @return number of coupons
     */
    private long generateRandomCouponQuantity() {
        Random random = new Random();
        return random.nextInt(9) + 2; // Generates a random value between 2 and 10 (inclusive)
    }

    /**
     * Randomly generates a coupon of types OFF5 or OFF10
     * @return return a random coupon type
     */
    private String generateRandomCouponType() {
        String[] types = {"OFF5", "OFF10"};
        Random random = new Random();
        int index = random.nextInt(types.length);
        return types[index];
    }

}

package models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

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

    @Column(name = "coupon_type")
    private String couponType;

    @Column(name = "coupon_quantity")
    private Long couponQuantity;

    @Column(name = "coupon_status")
    private String couponStatus;

}

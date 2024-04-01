package com.ShopME.ShopME.Repository;

import com.ShopME.ShopME.models.Coupon;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Hidden
public interface CouponRepository extends CrudRepository<Coupon, String> {
    @Transactional
    @Modifying
    @Query("update Coupon c set c.couponQuantity = ?1 where c.couponId = ?2")
    int updateCouponQuantityByCouponId(Long couponQuantity, String couponId);

}
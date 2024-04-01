package com.ShopME.ShopME.Repository;

import com.ShopME.ShopME.models.Customer;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


@Hidden
public interface CustomerRepository extends CrudRepository<Customer, String> {
    @Transactional
    @Modifying
    @Query("update Customer c set c.coupon_status = ?1, c.couponId = ?2 where c.userId = ?3")
    int updateCoupon_statusAndCouponIdByUserId(String coupon_status, String couponId, String userId);
    @Transactional
    @Modifying
    @Query("update Customer c set c.coupon_status = ?1 where c.userId = ?2")
    int updateCoupon_statusByUserId(String coupon_status, String userId);

}
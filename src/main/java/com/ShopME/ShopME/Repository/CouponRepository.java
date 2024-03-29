package com.ShopME.ShopME.Repository;

import com.ShopME.ShopME.models.Coupon;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.repository.CrudRepository;

@Hidden
public interface CouponRepository extends CrudRepository<Coupon, String> {

}
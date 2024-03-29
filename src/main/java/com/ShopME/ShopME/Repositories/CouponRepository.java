package com.ShopME.ShopME.Repositories;

import com.ShopME.ShopME.models.Coupon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends CrudRepository<Coupon, String> {

}
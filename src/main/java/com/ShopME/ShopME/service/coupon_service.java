package com.ShopME.ShopME.service;

import com.ShopME.ShopME.Repository.CouponRepository;
import com.ShopME.ShopME.models.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class coupon_service {
    public final CouponRepository couponRepository;

    @Autowired
    public coupon_service(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public Coupon save_coupon(Coupon coupon){
        return couponRepository.save(coupon);
    }
    public Iterable<Coupon> getCoupons(){
        return couponRepository.findAll();
    }
}

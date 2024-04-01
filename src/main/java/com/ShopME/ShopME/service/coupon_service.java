package com.ShopME.ShopME.service;

import com.ShopME.ShopME.Repository.CouponRepository;
import com.ShopME.ShopME.models.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public int update_coupon_number(String coupon_id, Long quantity){ return couponRepository.updateCouponQuantityByCouponId(quantity,coupon_id);
    }

    /**
     * Returns a coupon if there exist a coupon
     * of that id
     * @param id identifier of the coupon
     * @return coupon if present else none
     */
    public Optional<Coupon> get_Coupon(String id)
    {
        return couponRepository.findById(id);
    }
}

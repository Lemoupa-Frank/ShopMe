package com.ShopME.ShopME.controller;
import io.swagger.v3.oas.annotations.Operation;
import com.ShopME.ShopME.models.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ShopME.ShopME.service.coupon_service;

@RestController
@RequestMapping("/ShopME")
public class ShopMe_Controller {

    public final coupon_service couponService;


    @Autowired
    public ShopMe_Controller(coupon_service couponService) {
        this.couponService = couponService;
    }

    @Operation(summary = "Home Page")
    @GetMapping("/")
    public String index() {
        return "Greetings from Dev Team!";
    }
    @Operation(summary = "Check the Shop inventory")
    @GetMapping("/inventory")
    public int inventory()
    {
        return 50;
    }

    @Operation(summary = "Check available Coupons")
    @GetMapping("/fetchCoupons")
    public int fetchCoupons()
    {
        return 50;
    }

    @Operation(summary = "Admin Level add coupon")
    @PostMapping("/addCoupons")
    public Coupon addCoupon(@RequestBody Coupon coupon)
    {
        return this.couponService.save_coupon(coupon);
    }
}

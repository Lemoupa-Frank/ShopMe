package com.ShopME.ShopME;
import io.swagger.v3.oas.annotations.Operation;
import models.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.coupon_service;

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
        this.couponService.save_coupon(coupon);
        return coupon;
    }
}

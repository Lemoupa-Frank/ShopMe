package com.ShopME.ShopME;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ShopME")
public class ShopMe_Controller {

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
}

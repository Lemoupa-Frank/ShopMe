package com.ShopME.ShopME.controller;

import com.ShopME.ShopME.models.*;
import com.ShopME.ShopME.service.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/ShopME")
public class ShopMe_Controller {

    public final coupon_service couponService;
    public final product_service productService;
    public final customer_service customerService;
    public final order_service orderService;

    public final transaction_service transactionService;


    @Autowired
    public ShopMe_Controller(coupon_service couponService, product_service productService, customer_service customerService, order_service orderService, transaction_service transactionService) {
        this.couponService = couponService;
        this.productService = productService;
        this.customerService = customerService;
        this.orderService = orderService;
        this.transactionService = transactionService;
    }

    @Operation(summary = "Home Page")
    @GetMapping("/")
    public String index() {
        return "Greetings from Dev Team!";
    }

    @Operation(summary = "Check the Shop inventory")
    @GetMapping("/inventory")
    public Product inventory() {
        Iterable<Product> products = productService.get_product();
        Iterator<Product> iterator = products.iterator();
        if (iterator.hasNext()) {
            return iterator.next();
        } else {
            Product product = new Product();
            product.setProuductId("NAN");
            product.setOrdered(0L);
            product.setAvailable(0L);
            return product;
        }
    }

    @Operation(summary = "Check for available Coupons")
    @GetMapping("/fetchCoupons")
    public Iterable<Coupon> fetchCoupons() {
        return couponService.getCoupons();
    }

    @Operation(summary = "Add coupon")
    @PostMapping("/addCoupons")
    public Coupon addCoupon() {//modify to save just one of each
        Coupon coupon = new Coupon();
        return this.couponService.save_coupon(coupon);
    }

    @Operation(summary = "Create new Customer")
    @PostMapping("/new customer")
    public Customer new_customer(@Parameter(description = "Customer email") @RequestParam("customer ID") String user_id, @Parameter(description = "Display Name") @RequestParam("Customer Name") String user_name, @Parameter(description = "Customer password") @RequestParam("password") String password) {
        Customer customer = new Customer();
        customer.setUserId(user_id);
        customer.setUserName(user_name);
        customer.setPassword(password);
        return customerService.create_account(customer);
    }

    @Operation(summary = "Check My orders")
    @GetMapping("/{userId}/orders")
    public Iterable<Order> check_my_orders(@Parameter(description = "Customer identifier") @RequestParam("customer ID") String user_id) {
        return orderService.check_my_orders(user_id);
    }

    @Operation(summary = "Check My orders")
    @GetMapping("/{userId}/orders/{orderId}")
    public ResponseEntity<Object> check_an_orders(@Parameter(description = "Customer identifier") @RequestParam("customer ID") String user_id, @Parameter(description = "Order identifier") @RequestParam("Order ID") String order_id) {
        Iterable<Transaction> transactions_list = transactionService.getTransaction(user_id, order_id);
        if (!transactions_list.iterator().hasNext()) {
            Order_Message orderMessage = new Order_Message(order_id, "Order not found");
            return ResponseEntity.status(404).body(orderMessage);
        }
        return ResponseEntity.status(200).body(transactionService.getTransaction(user_id, order_id));
    }


    @Operation(summary = "order a product ")
    @PostMapping("/{userId}/order")
    public Order createOrder(@PathVariable("userId") String userId,
                             @RequestParam("quantity") Long quantity,
                             @RequestParam(value = "coupon", required = false) String couponCode) {
        //verify if user exist or make session assumption
        //verify if coupon is valid if not reject
        //once a user uses coupon make coupon go and flag a new attribute maybe
        // subtract quantity from existing products
        Order order = new Order(userId, quantity, couponCode);
        if (order.getCouponId() != null) {
            if (order.getCouponId().equals("OFF5")) {
                order.setAmount((long) (order.getAmount() - order.getAmount() * 0.05));
            } else if (order.getCouponId().equals("OFF10")) {
                order.setAmount((long) (order.getAmount() - order.getAmount() * 0.10));
            }
        }
        return orderService.save_order(order);
    }

    @Operation(summary = "Make a payment")
    @PostMapping(value = "/{userId}/{orderId}/pay", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> processPayment(@PathVariable("userId") String userId, @PathVariable("orderId") String orderId) {
        List<String> transactions = Arrays.asList("tran010100001", "tran010100002", "tran010100003", "tran010100004", "tran010100005", "tran010100006");
        int randomIndex = new Random().nextInt(transactions.size());
        String transaction = transactions.get(randomIndex);
        int statuscode = 400;
        PaymentResponse responsePayload = getResponsePayload(transaction);
        switch (transaction) {
            case "tran010100005" -> statuscode = 504;
            case "tran010100006" -> statuscode = 405;
            case "tran010100001" -> statuscode = 200;
        }
        responsePayload.setOrderId(orderId);
        responsePayload.setUserId(userId);
        Transaction pay_transaction = new Transaction();
        Order order = orderService.get_order(orderId);
        if (statuscode == 200 && order != null) {

            pay_transaction.setOrderId(orderId);
            pay_transaction.setUserId(userId);
            pay_transaction.setTransactionId(transaction);
            pay_transaction.setDate(Date.valueOf(LocalDate.now()));
            pay_transaction.setStatus("successful");
            pay_transaction.setAmount(order.getAmount());
            pay_transaction.setCouponId(order.getCouponId());
            transactionService.addtransaction(pay_transaction);
        }
        if (statuscode != 200 && order != null) {
            pay_transaction.setOrderId(orderId);
            pay_transaction.setUserId(userId);
            pay_transaction.setTransactionId(transaction);
            pay_transaction.setDate(Date.valueOf(LocalDate.now()));
            pay_transaction.setStatus("failed");
            pay_transaction.setAmount(order.getAmount());
            pay_transaction.setCouponId(order.getCouponId());
            transactionService.addtransaction(pay_transaction);
        }


        return ResponseEntity.status(statuscode).body(responsePayload);
        //check if userid and orderid exist
    }

    /**
     * generates a response entity after being a transactionid
     *
     * @param transactionid transaction id of payment
     * @return returns payment object
     */
    private PaymentResponse getResponsePayload(String transactionid) {
        return switch (transactionid) {
            case "tran010100001" -> new PaymentResponse("1", "100", "tran010100001", "successful");
            case "tran010100002" ->
                    new PaymentResponse("1", "100", "tran010100002", "failed", "Payment Failed as amount is invalid");
            case "tran010100003" ->
                    new PaymentResponse("1", "100", "tran010100003", "failed", "Payment Failed from bank");
            case "tran010100004" ->
                    new PaymentResponse("1", "100", "tran010100004", "failed", "Payment Failed due to invalid order id");
            case "tran010100005" ->
                    new PaymentResponse("1", "100", "tran010100005", "failed", "No response from payment server");
            case "tran010100006" ->
                    new PaymentResponse("1", "100", "tran010100006", "failed", "Order is already paid for");
            default -> null;
        };
    }
}

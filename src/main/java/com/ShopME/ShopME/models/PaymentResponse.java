package com.ShopME.ShopME.models;


public class PaymentResponse {

    private static final long serialVersionUID = 1L;
    private  String userId;
    private  String orderId;
    private final String transactionId;
    private final String status;
    private String description;

    public PaymentResponse(String userId, String orderId, String transactionId, String status) {
        this.userId = userId;
        this.orderId = orderId;
        this.transactionId = transactionId;
        this.status = status;
        this.description = "Thanks For fidelity";
    }

    public PaymentResponse(String userId, String orderId, String transactionId, String status, String description) {
        this.userId = userId;
        this.orderId = orderId;
        this.transactionId = transactionId;
        this.status = status;
        this.description = description;
    }

    public String getUserId() {
        return userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }


}

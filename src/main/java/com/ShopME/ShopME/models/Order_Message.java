package com.ShopME.ShopME.models;

public class Order_Message {
    private final String orderId;
    private final String description;

    public Order_Message(String orderId, String description) {
        this.orderId = orderId;
        this.description = description;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getDescription() {
        return description;
    }
}

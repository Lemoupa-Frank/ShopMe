package com.ShopME.ShopME.models;

public class Order_Message {
    private  String orderId;
    private  String description;

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
    
    public Order_Message(){}

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

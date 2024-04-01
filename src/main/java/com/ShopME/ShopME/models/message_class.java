package com.ShopME.ShopME.models;

public class message_class {
    private final String message;
    private final String description;

    public message_class(String message, String description) {
        this.message = message;
        this.description = description;
    }

    public String getOrderId() {
        return message;
    }

    public String getDescription() {
        return description;
    }
}

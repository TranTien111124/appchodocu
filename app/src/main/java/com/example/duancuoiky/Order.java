package com.example.duancuoiky;

public class Order {
    private String orderId;
    private String date;
    private String total;
    private String status;

    public Order(String orderId, String date, String total, String status) {
        this.orderId = orderId;
        this.date = date;
        this.total = total;
        this.status = status;
    }

    // Getters
    public String getOrderId() {
        return orderId;
    }

    public String getDate() {
        return date;
    }

    public String getTotal() {
        return total;
    }

    public String getStatus() {
        return status;
    }
}
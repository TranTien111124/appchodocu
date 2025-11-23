package com.example.duancuoiky;

import java.util.ArrayList;
import java.util.List;

public class OrderHistory {
    private static OrderHistory instance;
    private List<Order> orders;

    private OrderHistory() {
        orders = new ArrayList<>();
    }

    public static synchronized OrderHistory getInstance() {
        if (instance == null) {
            instance = new OrderHistory();
        }
        return instance;
    }

    public void addOrder(Order order) {
        orders.add(0, order); // Thêm vào đầu danh sách
    }

    public List<Order> getOrders() {
        return orders;
    }
}
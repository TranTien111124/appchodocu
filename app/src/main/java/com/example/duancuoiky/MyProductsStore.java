package com.example.duancuoiky;

import java.util.ArrayList;
import java.util.List;

public class MyProductsStore {
    private static MyProductsStore instance;
    private List<MyProduct> products;

    private MyProductsStore() {
        products = new ArrayList<>();
    }

    public static synchronized MyProductsStore getInstance() {
        if (instance == null) {
            instance = new MyProductsStore();
        }
        return instance;
    }

    public void addProduct(MyProduct product) {
        products.add(0, product); // Thêm vào đầu danh sách
    }

    public List<MyProduct> getProducts() {
        return products;
    }
}
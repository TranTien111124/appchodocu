package com.example.duancuoiky;

public class CartItem {
    private String shopName;
    private String productName;
    private String variant;
    private String price;
    private int imageResId;
    private int quantity;

    public CartItem(String shopName, String productName, String variant, String price, int imageResId, int quantity) {
        this.shopName = shopName;
        this.productName = productName;
        this.variant = variant;
        this.price = price;
        this.imageResId = imageResId;
        this.quantity = quantity;
    }

    // Getters
    public String getShopName() { return shopName; }
    public String getProductName() { return productName; }
    public String getVariant() { return variant; }
    public String getPrice() { return price; }
    public int getImageResId() { return imageResId; }
    public int getQuantity() { return quantity; }

    // Setters
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
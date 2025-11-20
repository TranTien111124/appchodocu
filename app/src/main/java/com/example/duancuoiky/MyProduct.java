package com.example.duancuoiky;

import android.net.Uri;

public class MyProduct {
    private String name;
    private String price;
    private Uri imageUri;
    private Status status;

    public enum Status { PENDING, APPROVED }

    public MyProduct(String name, String price, Uri imageUri) {
        this.name = name;
        this.price = price;
        this.imageUri = imageUri;
        this.status = Status.PENDING; // Mặc định là "Chờ duyệt"
    }

    // Getters
    public String getName() { return name; }
    public String getPrice() { return price; }
    public Uri getImageUri() { return imageUri; }
    public Status getStatus() { return status; }

    // Setter để thay đổi trạng thái (ví dụ: từ admin)
    public void setStatus(Status status) {
        this.status = status;
    }
}
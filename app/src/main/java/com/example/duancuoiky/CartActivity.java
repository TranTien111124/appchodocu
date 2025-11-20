package com.example.duancuoiky;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Giỏ hàng (2)");

        RecyclerView recyclerView = findViewById(R.id.rv_cart_items);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Dữ liệu mẫu
        List<CartItem> cartItems = new ArrayList<>();
        // LƯU Ý: Tên tài nguyên ảnh không bao gồm phần mở rộng .jpg
        cartItems.add(new CartItem("VN-Camping", "Ghế camping gấp gọn Tmountain", "Loại hàng đã chọn không còn.", "", R.drawable.mac, 1));
        cartItems.add(new CartItem("Giày Chất19", "Giày Thể Thao A.s.i.c.ss Court M....", "xám 1/1 k hộp, 42", "169.000đ", R.drawable.iphone14, 1));

        CartAdapter adapter = new CartAdapter(cartItems);
        recyclerView.setAdapter(adapter);

        // Thêm sự kiện click cho nút "Mua hàng"
        Button checkoutButton = findViewById(R.id.btn_checkout);
        checkoutButton.setOnClickListener(v -> {
            Intent intent = new Intent(CartActivity.this, CheckoutActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
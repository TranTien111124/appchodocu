package com.example.duancuoiky;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class CheckoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        MaterialToolbar toolbar = findViewById(R.id.toolbar_checkout);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView totalPriceView = findViewById(R.id.tv_total_price_checkout);
        Button placeOrderButton = findViewById(R.id.btn_place_order);

        // Lấy tổng tiền từ giỏ hàng (trong ví dụ này, ta sẽ dùng giá trị cố định)
        String total = "169.000đ";
        totalPriceView.setText(total);

        placeOrderButton.setOnClickListener(v -> {
            // Tạo một đơn hàng mới
            String orderId = String.valueOf(ThreadLocalRandom.current().nextInt(100000, 999999));
            String date = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());
            Order newOrder = new Order(orderId, date, total, "Đang xử lý");

            // Thêm đơn hàng vào lịch sử
            OrderHistory.getInstance().addOrder(newOrder);

            Toast.makeText(this, "Đặt hàng thành công!", Toast.LENGTH_SHORT).show();

            // Chuyển đến trang danh sách đơn hàng
            Intent intent = new Intent(CheckoutActivity.this, OrdersActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish(); // Đóng các activity cũ (Checkout, Cart)
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
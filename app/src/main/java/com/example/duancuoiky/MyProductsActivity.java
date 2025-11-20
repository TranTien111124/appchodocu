package com.example.duancuoiky;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.List;

public class MyProductsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_products);

        // Đọc trạng thái admin từ SharedPreferences
        SharedPreferences settings = getSharedPreferences(LoginActivity.PREFS_NAME, 0);
        boolean isAdmin = settings.getBoolean(LoginActivity.IS_ADMIN_KEY, false);

        MaterialToolbar toolbar = findViewById(R.id.toolbar_my_products);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Nếu là admin, đổi tiêu đề
        if (isAdmin) {
            getSupportActionBar().setTitle("Quản lý Sản phẩm");
        }

        RecyclerView recyclerView = findViewById(R.id.rv_my_products);
        TextView noProductsView = findViewById(R.id.tv_no_products);

        // Admin sẽ thấy tất cả sản phẩm, người dùng thường chỉ thấy sản phẩm của họ (logic này sẽ cần mở rộng trong tương lai)
        List<MyProduct> products = MyProductsStore.getInstance().getProducts();

        if (products.isEmpty()) {
            noProductsView.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } else {
            noProductsView.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            // Truyền trạng thái admin vào Adapter
            MyProductsAdapter adapter = new MyProductsAdapter(this, products, isAdmin);
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
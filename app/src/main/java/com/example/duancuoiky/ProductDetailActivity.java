package com.example.duancuoiky;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        ImageView productImageView = findViewById(R.id.iv_product_detail_image);
        TextView productNameView = findViewById(R.id.tv_product_detail_name);
        TextView productPriceView = findViewById(R.id.tv_product_detail_price);
        Button addToCartButton = findViewById(R.id.btn_add_to_cart);

        Product product = getIntent().getParcelableExtra("PRODUCT_EXTRA");

        if (product != null) {
            productImageView.setImageResource(product.getImageResId());
            productNameView.setText(product.getName());
            productPriceView.setText(product.getPrice());
        }

        addToCartButton.setOnClickListener(v -> {
            // Logic để thêm sản phẩm vào giỏ hàng thực tế sẽ ở đây

            // Chuyển đến trang giỏ hàng
            Intent intent = new Intent(ProductDetailActivity.this, CartActivity.class);
            startActivity(intent);
        });
    }
}
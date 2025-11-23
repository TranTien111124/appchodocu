package com.example.duancuoiky;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyProductsAdapter extends RecyclerView.Adapter<MyProductsAdapter.MyProductViewHolder> {

    private List<MyProduct> products;
    private Context context;
    private boolean isAdmin;

    public MyProductsAdapter(Context context, List<MyProduct> products, boolean isAdmin) {
        this.context = context;
        this.products = products;
        this.isAdmin = isAdmin;
    }

    @NonNull
    @Override
    public MyProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.my_product_item, parent, false);
        return new MyProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyProductViewHolder holder, int position) {
        MyProduct product = products.get(position);

        holder.productName.setText(product.getName());
        holder.productPrice.setText(product.getPrice());
        holder.productImage.setImageURI(product.getImageUri());

        if (product.getStatus() == MyProduct.Status.PENDING) {
            holder.productStatus.setText("Chờ duyệt");
            holder.productStatus.setBackgroundColor(Color.parseColor("#FFA500")); // Orange

            // Nếu là admin, hiển thị nút Duyệt
            if (isAdmin) {
                holder.approveButton.setVisibility(View.VISIBLE);
                holder.approveButton.setOnClickListener(v -> {
                    product.setStatus(MyProduct.Status.APPROVED);
                    notifyItemChanged(position); // Cập nhật lại item này
                });
            } else {
                holder.approveButton.setVisibility(View.GONE);
            }
        } else {
            holder.productStatus.setText("Đã duyệt");
            holder.productStatus.setBackgroundColor(Color.parseColor("#4CAF50")); // Green
            holder.approveButton.setVisibility(View.GONE); // Ẩn nút nếu đã duyệt
        }
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    static class MyProductViewHolder extends RecyclerView.ViewHolder {
        ImageView productImage;
        TextView productName, productPrice, productStatus;
        Button approveButton;

        public MyProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.iv_my_product_image);
            productName = itemView.findViewById(R.id.tv_my_product_name);
            productPrice = itemView.findViewById(R.id.tv_my_product_price);
            productStatus = itemView.findViewById(R.id.tv_my_product_status);
            approveButton = itemView.findViewById(R.id.btn_approve);
        }
    }
}

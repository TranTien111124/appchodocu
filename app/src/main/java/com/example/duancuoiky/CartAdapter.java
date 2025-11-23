package com.example.duancuoiky;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private List<CartItem> cartItems;

    public CartAdapter(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        CartItem item = cartItems.get(position);
        holder.shopName.setText(item.getShopName());
        holder.productName.setText(item.getProductName());
        holder.productVariant.setText(item.getVariant());
        holder.productPrice.setText(item.getPrice());
        holder.productImage.setImageResource(item.getImageResId());
        holder.quantity.setText(String.valueOf(item.getQuantity()));
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    static class CartViewHolder extends RecyclerView.ViewHolder {
        TextView shopName, productName, productVariant, productPrice, quantity;
        ImageView productImage;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            shopName = itemView.findViewById(R.id.tv_shop_name);
            productName = itemView.findViewById(R.id.tv_product_name_cart);
            productVariant = itemView.findViewById(R.id.tv_product_variant);
            productPrice = itemView.findViewById(R.id.tv_product_price_cart);
            quantity = itemView.findViewById(R.id.tv_quantity);
            productImage = itemView.findViewById(R.id.iv_product_image_cart);
        }
    }
}
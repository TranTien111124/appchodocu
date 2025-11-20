package com.example.duancuoiky;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView myOrders = view.findViewById(R.id.tv_my_orders);
        TextView editProfile = view.findViewById(R.id.tv_edit_profile);
        TextView myProducts = view.findViewById(R.id.tv_settings);
        TextView logout = view.findViewById(R.id.tv_logout);

        myOrders.setOnClickListener(v -> {
            Intent intent = new Intent(requireActivity(), OrdersActivity.class);
            startActivity(intent);
        });

        editProfile.setOnClickListener(v -> {
            Toast.makeText(requireContext(), "Chỉnh sửa hồ sơ", Toast.LENGTH_SHORT).show();
        });

        myProducts.setOnClickListener(v -> {
            Intent intent = new Intent(requireActivity(), MyProductsActivity.class);
            startActivity(intent);
        });

        logout.setOnClickListener(v -> {
            // Xóa dữ liệu đăng nhập đã lưu
            SharedPreferences settings = requireActivity().getSharedPreferences(LoginActivity.PREFS_NAME, 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.clear();
            editor.apply();

            // Quay lại trang đăng nhập và xóa các màn hình cũ
            Intent intent = new Intent(requireActivity(), LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            requireActivity().finish();
        });
    }
}

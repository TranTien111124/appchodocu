package com.example.duancuoiky;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SellFragment extends Fragment {

    private ImageView productImageView;
    private EditText productNameEditText, productDescriptionEditText, productPriceEditText;
    private Uri selectedImageUri;

    private final ActivityResultLauncher<Intent> imagePickerLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {
                    selectedImageUri = result.getData().getData();
                    productImageView.setImageURI(selectedImageUri);
                }
            });

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sell, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        productImageView = view.findViewById(R.id.iv_product_image_preview);
        productNameEditText = view.findViewById(R.id.et_product_name);
        productDescriptionEditText = view.findViewById(R.id.et_product_description);
        productPriceEditText = view.findViewById(R.id.et_product_price);
        Button selectImageButton = view.findViewById(R.id.btn_select_image);
        Button postListingButton = view.findViewById(R.id.btn_post_listing);

        selectImageButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            imagePickerLauncher.launch(intent);
        });

        postListingButton.setOnClickListener(v -> {
            String name = productNameEditText.getText().toString().trim();
            String description = productDescriptionEditText.getText().toString().trim();
            String price = productPriceEditText.getText().toString().trim();

            if (name.isEmpty() || description.isEmpty() || price.isEmpty() || selectedImageUri == null) {
                Toast.makeText(requireContext(), "Vui lòng điền đầy đủ thông tin và chọn ảnh", Toast.LENGTH_SHORT).show();
            } else {
                // Tạo sản phẩm mới
                MyProduct newProduct = new MyProduct(name, price, selectedImageUri);

                // Thêm sản phẩm vào kho lưu trữ
                MyProductsStore.getInstance().addProduct(newProduct);

                Toast.makeText(requireContext(), "Đăng bán sản phẩm thành công!", Toast.LENGTH_LONG).show();
                
                // Xóa các trường sau khi đăng
                productNameEditText.setText("");
                productDescriptionEditText.setText("");
                productPriceEditText.setText("");
                productImageView.setImageResource(android.R.drawable.ic_menu_gallery);
                selectedImageUri = null;
            }
        });
    }
}

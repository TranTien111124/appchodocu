package com.example.duancuoiky;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    public static final String PREFS_NAME = "MyPrefsFile";
    public static final String IS_ADMIN_KEY = "isAdmin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.et_email);
        passwordEditText = findViewById(R.id.et_password);
        Button loginButton = findViewById(R.id.btn_login);

        loginButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            // SharedPreferences để lưu trạng thái đăng nhập
            SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
            SharedPreferences.Editor editor = settings.edit();

            boolean loggedIn = false;

            if (email.equals("admin@gmail.com") && password.equals("123")) {
                // Đăng nhập với vai trò Admin
                editor.putBoolean(IS_ADMIN_KEY, true);
                loggedIn = true;
            } else if (email.equals("user@gmail.com") && password.equals("123")) {
                // Đăng nhập với vai trò người dùng thường
                editor.putBoolean(IS_ADMIN_KEY, false);
                loggedIn = true;
            }

            if (loggedIn) {
                editor.apply();
                // Chuyển đến MainActivity
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Đóng LoginActivity để không quay lại được
            } else {
                // Sai thông tin đăng nhập
                Toast.makeText(this, "Email hoặc mật khẩu không đúng", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
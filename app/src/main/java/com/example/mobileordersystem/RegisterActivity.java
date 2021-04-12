package com.example.mobileordersystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText userNameEditText;
    private EditText passwordEditText;
    private EditText repeatedPasswordEditText;
    private EditText phoneNumEditText;
    private EditText addressEditText;
    private Button registerButton;
    private Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        userNameEditText = findViewById(R.id.editText_register_userName);
        passwordEditText = findViewById(R.id.editText_register_password);
        repeatedPasswordEditText = findViewById(R.id.editText_register_passwordRepeated);
        phoneNumEditText = findViewById(R.id.editText_register_phoneNum);
        addressEditText = findViewById(R.id.editText_register_address);
        registerButton = findViewById(R.id.btn_register_register);
        cancelButton = findViewById(R.id.btn_register_cancel);
        RegisterOnClickListener onClickListener = new RegisterOnClickListener();
        registerButton.setOnClickListener(onClickListener);
        cancelButton.setOnClickListener(onClickListener);
    }

    class RegisterOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            int id = v.getId();
            if(id == R.id.btn_register_register){
                Toast.makeText(RegisterActivity.this, "单击注册按钮", Toast.LENGTH_SHORT).show();
            }else if(id == R.id.btn_register_cancel){
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }
}
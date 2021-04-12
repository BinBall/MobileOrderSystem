package com.example.mobileordersystem;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class LoginDialog extends Dialog implements View.OnClickListener {

    private String userName = null;

    private String password = null;

    public ButtonID btnClicked = ButtonID.BUTTON_NONE;

    public boolean isHoldUserName = false;//记住用户名

    public enum ButtonID{BUTTON_NONE, BUTTON_OK, BUTTON_REGISTER, BUTTON_CANCEL}

    private EditText userNameEt;

    private EditText passwordEt;

    private CheckBox holdUserNameCb;

    private TextView loginFailureTv;

    public LoginDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);

        setContentView(R.layout.login);
        setTitle("用户登录");
        setCancelable(true);

        userNameEt = findViewById(R.id.loginpage_et_username);
        passwordEt = findViewById(R.id.loginpage_et_password);
        Button loginBtn = findViewById(R.id.loginpage_btn_login);
        Button registerBtn = findViewById(R.id.loginpage_btn_register);
        Button cancelBtn = findViewById(R.id.loginpage_btn_cancel);
        holdUserNameCb = findViewById(R.id.loginpage_cb_remember_username);

        loginBtn.setOnClickListener(this);
        registerBtn.setOnClickListener(this);
        cancelBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.loginpage_btn_login){
            userName = userNameEt.getText().toString().trim();
            password = passwordEt.getText().toString().trim();
            if(!userName.isEmpty()&&!password.isEmpty()){
                loginFailureTv = findViewById(R.id.loginpage_tv_login_failure);
                loginFailureTv.setText("用户名和密码不能为空");
                loginFailureTv.setVisibility(View.VISIBLE);
            }else{
                if(isCorrectPassword(userName, password)){
                    if(holdUserNameCb.isChecked()){//保存用户名

                    }
                    btnClicked = ButtonID.BUTTON_OK;
                    dismiss();
                }else{
                    loginFailureTv = findViewById(R.id.loginpage_tv_login_failure);
                    loginFailureTv.setText("用户名或密码错误");
                    loginFailureTv.setVisibility(View.VISIBLE);
                }
            }
        }else if(id == R.id.loginpage_btn_register){
            btnClicked = ButtonID.BUTTON_REGISTER;
            dismiss();
        }else if(id == R.id.loginpage_btn_cancel){
            btnClicked = ButtonID.BUTTON_CANCEL;
            dismiss();
        }
    }

    private boolean isCorrectPassword(String userName, String password) {
        return userName.equals("admin") && password.equals("123");
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

}

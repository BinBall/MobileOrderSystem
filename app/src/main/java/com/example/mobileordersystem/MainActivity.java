package com.example.mobileordersystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static MyApplication myApplication = null;//Application类用于缓存信息

    private ImageButton foodOrderBtn = null;//点餐按钮

    private ImageButton foodTakeOutBtn = null;//外卖按钮

    private ImageButton userInfoBtn = null;//个人中心按钮

    private ImageButton loginBtn = null;//登录按钮

    private ImageButton logoutBtn = null;//注册按钮

    private ImageButton settingsBtn = null;//系统设置按钮

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myApplication = (MyApplication) getApplication();//实例化成员对象
        myApplication.setContext(getApplicationContext());//设置上下文环境
        myApplication.setUser(new User());//设置用户
        myApplication.setOrders(new ArrayList<Order>());//设置订单
        myApplication.setDishes(new Dishes());//设置菜单
        myApplication.getDishes().setDishes(fillDishesList());//向菜品列表实例化子对象

        foodOrderBtn = findViewById(R.id.imgBtn_foodOrder);
        foodTakeOutBtn = findViewById(R.id.imgBtn_foodTakeOut);
        userInfoBtn = findViewById(R.id.imgBtn_userInfo);
        loginBtn = findViewById(R.id.imgBtn_login);
        logoutBtn = findViewById(R.id.imgBtn_logout);
        settingsBtn = findViewById(R.id.imgBtn_settings);

        MainActivityOnClickListener onClickListener = new MainActivityOnClickListener();//创建监听器对象
        foodOrderBtn.setOnClickListener(onClickListener);
        foodTakeOutBtn.setOnClickListener(onClickListener);
        userInfoBtn.setOnClickListener(onClickListener);
        loginBtn.setOnClickListener(onClickListener);
        logoutBtn.setOnClickListener(onClickListener);
        settingsBtn.setOnClickListener(onClickListener);
    }

    //填充菜品列表
    private ArrayList<Dish> fillDishesList() {
        ArrayList<Dish> dishesList = new ArrayList<Dish>();
        dishesList.add(new Dish("宫保鸡丁", 1001, R.raw.food01gongbaojiding,  20.0));
        dishesList.add(new Dish("椒盐玉米", 1002, R.raw.food02jiaoyanyumi,  24.0));
        dishesList.add(new Dish("清蒸武昌鱼", 1003, R.raw.food03qingzhengwuchangyu,  48.0));
        dishesList.add(new Dish("鱼香肉丝", 1004, R.raw.food04yuxiangrousi,  28.0));
        return dishesList;
    }

    private class MainActivityOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            if (id == R.id.imgBtn_foodOrder){//点餐功能
                Toast.makeText(MainActivity.this, "点击了点餐按钮", Toast.LENGTH_SHORT).show();
                Intent foodOrderIntent = new Intent(MainActivity.this, DishActivity.class);
                startActivity(foodOrderIntent);
            }else if(id == R.id.imgBtn_foodTakeOut){//外卖功能
                Toast.makeText(MainActivity.this, "点击了外卖按钮", Toast.LENGTH_SHORT).show();

            }else if(id == R.id.imgBtn_login){//登录功能
                LoginDialog loginDialog = new LoginDialog(MainActivity.this, R.style.LoginDialog);

                loginDialog.show();
                loginDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        switch (loginDialog.btnClicked){
                            case BUTTON_OK://登录成功
                                MyApplication myApplication = (MyApplication) getApplication();
                                // TODO: 2021/4/8 在数据库中找User对象
                                String userName = loginDialog.getUserName();
                                myApplication.setUser(new User(userName, loginDialog.getPassword()));
                                myApplication.setShoppingCart(new ShoppingCart(userName));
                                myApplication.setLogined(true);
                                loginBtn.setVisibility(View.GONE);
                                logoutBtn.setVisibility(View.VISIBLE);
                                break;
                            case BUTTON_CANCEL:
                                break;
                            case BUTTON_REGISTER:
                                Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
                                startActivity(registerIntent);
                                break;
                            default:
                                break;
                        }
                    }
                });


            }else if(id == R.id.imgBtn_logout){//注销功能
                Toast.makeText(MainActivity.this, "点击了注销按钮", Toast.LENGTH_SHORT).show();
                logoutBtn.setVisibility(View.GONE);
                loginBtn.setVisibility(View.VISIBLE);

            }else if(id == R.id.imgBtn_userInfo){//个人信息功能
                Toast.makeText(MainActivity.this, "点击了个人信息按钮", Toast.LENGTH_SHORT).show();

            }else if(id == R.id.imgBtn_settings){//系统设置功能
                Toast.makeText(MainActivity.this, "点击了系统设置按钮", Toast.LENGTH_SHORT).show();

            }
        }
    }
}
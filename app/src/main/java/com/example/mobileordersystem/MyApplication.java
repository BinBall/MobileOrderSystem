package com.example.mobileordersystem;

import android.app.Application;
import android.content.Context;

import java.util.ArrayList;

/**
 * 能使用用户、购物车等对象,起到共享数据、数据缓存、数据传递的作用
 */
public class MyApplication extends Application {
    private User user;//用户
    private ShoppingCart shoppingCart;//与登录用户相关购物车
    private Dishes dishes;//菜单
    private ArrayList<Order> orders;//与登陆用户关联的订单
    private String ip;//TCP通信的服务器地址
    private String httpIp;//HTTP通信的服务器地址
    private Integer communiMode = 1;//通信模式，1表示TCP通信，2表示HTTP通信
    private int port = 35885;//端口号
    private Context context;//上下文环境
    private boolean isLogined;//是否登录成功

    public boolean isLogined() {
        return isLogined;
    }

    public void setLogined(boolean logined) {
        isLogined = logined;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getHttpIp() {
        return httpIp;
    }

    public void setHttpIp(String httpIp) {
        this.httpIp = httpIp;
    }

    public Integer getCommuniMode() {
        return communiMode;
    }

    public void setCommuniMode(Integer communiMode) {
        this.communiMode = communiMode;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Dishes getDishes() {
        return dishes;
    }

    public void setDishes(Dishes dishes) {
        this.dishes = dishes;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
}

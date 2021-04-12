package com.example.mobileordersystem;

import java.util.ArrayList;

//订单类
public class Order {
    private Integer orderId;//订单ID
    private String orderTime;//订单时间
    private ShoppingCart orderItems;//存放已点菜品列表

    public Order(Integer orderId, String orderTime, ShoppingCart orderItems) {
        this.orderId = orderId;
        this.orderTime = orderTime;
        this.orderItems = orderItems;
    }

    public Order(String userName) {
        orderItems = new ShoppingCart(userName);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderTime='" + orderTime + '\'' +
                ", orderItems=" + orderItems +
                '}';
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public ShoppingCart getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(ShoppingCart orderItems) {
        this.orderItems = orderItems;
    }
}

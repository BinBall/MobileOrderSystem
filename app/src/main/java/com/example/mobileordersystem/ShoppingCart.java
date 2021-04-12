package com.example.mobileordersystem;

import java.util.ArrayList;
import java.util.Iterator;

import static android.media.CamcorderProfile.get;

//购物车类
public class ShoppingCart {
    private String userName;//购物车所属用户名
    private ArrayList<OrderItem> orderItems;//存放已点菜品明细

    public ShoppingCart(String userName) {
        this.userName = userName;
        orderItems = new ArrayList<OrderItem>();
    }

    //根据菜名在已点菜品列表中修改该菜数量，返回修改菜品在购物车中位置，若不存在返回-1
    public int modifyOrderItem(String dishName, int num){
        int index = getOrderItemIndex(dishName);
        if(index!=-1){
            OrderItem item = orderItems.get(index);
            item.setDishNum(item.getDishNum()+num);
        }
        return index;
    }

    //获取订单明细数量
    public int getOrderItemNum(){
        return orderItems.size();
    }

    //通过索引值获取某个订单明细
    public OrderItem getOrderItem(int index){
        return orderItems.get(index);
    }

    //通过索引值删除某订单明细
    public boolean delOrderItem(int index){
        if(!orderItems.isEmpty()){
            if(index>=0 && index<orderItems.size()){
                orderItems.remove(index);
                return true;
            }
        }
        return false;
    }

    //根据菜名删除某菜品
    public boolean delOrderItem(String dishName){
        int index = getOrderItemIndex(dishName);
        if(index!=-1){
            return delOrderItem(index);
        }
        return false;
    }

    //计算购物车中总价
    public Double getTotalPrice(){
        Double totalPrice = 0d;
        if(!orderItems.isEmpty()){
            for (OrderItem orderItem: orderItems) {
                totalPrice += orderItem.getCost();
            }
        }
        return totalPrice;
    }

    //根据菜品名，在已点菜品列表中查询该菜是否已点，若已点则返回该菜品在列表中位置，否则返回-1
    private int getOrderItemIndex(String dishName){
        if(!orderItems.isEmpty()){
            for (OrderItem orderItem:orderItems){
                if(orderItem.getDish().getDishName().equals(dishName)){
                    return orderItems.indexOf(orderItem);
                }
            }
        }
        return -1;
    }

    //根据菜品信息，将菜品插入到已点菜品列表，并返回插入菜品在列表中的索引值
    public Integer addOrderItem(OrderItem orderItem){
        int index = getOrderItemIndex(orderItem.getDish().getDishName());
        if(index!=-1){
            OrderItem tempOrderItem = orderItems.get(index);
            tempOrderItem.setDishNum(tempOrderItem.getDishNum()+orderItem.getDishNum());
            return index;
        }else {
            orderItems.add(orderItem);
            return orderItems.size() - 1;
        }
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "userName='" + userName + '\'' +
                ", orderItems=" + orderItems +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ArrayList<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(ArrayList<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public ShoppingCart(String userName, ArrayList<OrderItem> orderItems) {
        this.userName = userName;
        this.orderItems = orderItems;
    }
}

package com.example.mobileordersystem;

import java.util.Objects;

//订单明细类
public class OrderItem {
    private Dish dish;//预订菜品
    private Integer dishNum;//菜品数量

    public OrderItem(Dish dish, Integer dishNum) {
        this.dish = dish;
        this.dishNum = dishNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return getDish().equals(orderItem.getDish()) &&
                getDishNum().equals(orderItem.getDishNum());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDish(), getDishNum());
    }

    //计算订单价格
    public Double getCost(){
        return dish.getDishPrice()*dishNum;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "dish=" + dish +
                ", dishNum=" + dishNum +
                '}';
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Integer getDishNum() {
        return dishNum;
    }

    public void setDishNum(Integer dishNum) {
        this.dishNum = dishNum;
    }
}

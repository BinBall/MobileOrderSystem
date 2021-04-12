package com.example.mobileordersystem;

import java.util.Objects;

//菜品类
public class Dish {
    private String dishName;//菜品ID
    private Integer dishId = -1;//菜品名称
    private Integer dishImg;//菜品图片对应的资源ID
    private Double dishPrice;//菜品价格

    public Dish(String dishName, Integer dishId, Integer dishImg, Double dishPrice) {
        this.dishName = dishName;
        this.dishId = dishId;
        this.dishImg = dishImg;
        this.dishPrice = dishPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return getDishName().equals(dish.getDishName()) &&
                getDishId().equals(dish.getDishId()) &&
                getDishImg().equals(dish.getDishImg()) &&
                getDishPrice().equals(dish.getDishPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDishName(), getDishId(), getDishImg(), getDishPrice());
    }

    @Override
    public String toString() {
        return "Dish{" +
                "dishName='" + dishName + '\'' +
                ", dishId=" + dishId +
                ", dishImg=" + dishImg +
                ", dishPrice=" + dishPrice +
                '}';
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    public Integer getDishImg() {
        return dishImg;
    }

    public void setDishImg(Integer dishImg) {
        this.dishImg = dishImg;
    }

    public Double getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(Double dishPrice) {
        this.dishPrice = dishPrice;
    }
}

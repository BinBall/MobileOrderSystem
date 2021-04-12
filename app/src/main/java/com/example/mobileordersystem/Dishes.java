package com.example.mobileordersystem;

import java.util.ArrayList;
//菜单类
public class Dishes {
    private ArrayList<Dish> dishes;//用于存放菜品对象

    //获取菜品列表长度
    public Integer getDishNum(){
        return dishes.size();
    }

    //按菜品索引值 获取指定菜品
    public Dish getDishByIndex(Integer index){
        return dishes.get(index);
    }

    //按菜品名称 获取指定菜品
    public Dish getDishByDishName(String dishName){
        for (Dish dish: dishes) {
            if (dish.getDishName().equals(dishName)){
                return dish;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Dishes{" +
                "dishes=" + dishes +
                '}';
    }

    public ArrayList<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(ArrayList<Dish> dishes) {
        this.dishes = dishes;
    }

}

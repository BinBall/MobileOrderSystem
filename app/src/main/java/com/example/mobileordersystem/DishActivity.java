package com.example.mobileordersystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DishActivity extends AppCompatActivity {

    private static List<Map<String, Object>> dishInfo = null;//菜品列表的数据源
    private ListView dishListView = null;//菜品信息列表
    private static SimpleAdapter dishAdapter = null;//列表适配器，将数据源填充到列表视图

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dish_list);
        dishListView = findViewById(R.id.dish_list);
        dishInfo = getDishInfo();//获取菜品列表数据源
        //构造适配器 上下文，数据源，子项布局，
        dishAdapter
                = new SimpleAdapter(this, dishInfo, R.layout.dish_item,
                new String[]{"dishId", "dishImg", "dishName", "dishPrice"},
                new int[]{R.id.tv_dish_id, R.id.iv_dish_img, R.id.tv_dish_name, R.id.tv_dish_price});
        dishAdapter.notifyDataSetChanged();//通知适配器数据改变
        dishListView.setAdapter(dishAdapter);//设置适配器
        //为ListView的每个选项设置点击事件监听器
        dishListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            //parent是item所示列表，view是被选中的item，position是item在ListView中位置，id是item行号
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                View item = parent.getChildAt(position);//获取被点击的item
                String dishName = ((TextView) item.findViewById(R.id.tv_dish_name)).getText().toString();
                Toast.makeText(DishActivity.this, "DishName is " + dishName, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private ArrayList<Map<String, Object>> getDishInfo(){
        ArrayList<Map<String, Object>> dishInfo = new ArrayList<Map<String, Object>>();
        //将菜品信息填充到dishInfo中
        Dishes dishes = ((MyApplication)getApplication()).getDishes();
        ArrayList<Dish> dishArrayList = dishes.getDishes();
        for(Dish dish: dishArrayList){
            Map<String, Object> map = new HashMap<String, Object>();//存放每道菜品详细信息
            map.put("dishId", dish.getDishId());
            map.put("dishImg", dish.getDishImg());
            map.put("dishName", dish.getDishName());
            map.put("dishPrice", dish.getDishPrice());
            dishInfo.add(map);
        }
        return dishInfo;
    }

}
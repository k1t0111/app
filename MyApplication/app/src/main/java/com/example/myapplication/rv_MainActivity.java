package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class rv_MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    //List<String> list;
    Context context;
    adapter adapter;
    List<Map<String, Object>> list1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.rv_activity_main);

        context=this;
        recyclerView=findViewById(R.id.recyclerView);

        int[] phone_image={R.drawable.rv1,R.drawable.rv2,R.drawable.rv3};
        String[] price={"1000","2000","3000"};
        String[] configurations={"a","b","c"};

        list1=new ArrayList<Map<String, Object>>();
        for(int i=0;i< phone_image.length;i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("name", phone_image[i]);
            map.put("price", price[i]);
            map.put("config", configurations[i]);
            list1.add(map);
        }

        /*
        list=new ArrayList<String>();
        for(int i=0;i<9;i++){
            list.add("这是第" + i + "个例子");
        }
        */
        adapter = new adapter(context,list1);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(manager);
    }

}
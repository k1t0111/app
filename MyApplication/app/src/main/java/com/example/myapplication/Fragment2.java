package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment2 extends Fragment {
    RecyclerView recyclerView;
    Context context;
    adapter adapter;
    List<Map<String, Object>> list1;

    MyService.Mybinder mybinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.rv_activity_main, container, false);

        context=getContext();
        recyclerView=view.findViewById(R.id.recyclerView);

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

        adapter = new adapter(context,list1);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(manager);

        Intent intent=new Intent(context, MyService.class);
        //context.startActivity(intent);
        ServiceConnection connection=new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                mybinder=(MyService.Mybinder) iBinder;
                mybinder.todo();
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }
        };

        context.bindService(intent,connection,Context.BIND_AUTO_CREATE);

        //context.unbindService(connection);

        return view;
    }
}
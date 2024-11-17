package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("xr","Activity2:onRestart...");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("xr","Activity2:onPause...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("xr","Activity2:onDestroy...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("xr","Activity2:onStop...");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("xr","Activity2:onStart...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("xr", "Activity2:onResume...");
    }

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.LinearLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Log.d("xr","Activity2:onCreate...");

        textView=findViewById(R.id.textView2);

        Intent intent=getIntent();

        //String str=intent.getStringExtra("name");
        //int x=intent.getIntExtra("age",666);
        //textView.setText(str+"/"+x);

        Bundle bundle=intent.getExtras();
        String str2=bundle.getString("name")+"/"+bundle.getInt("age");
        textView.setText(str2);
    }
}
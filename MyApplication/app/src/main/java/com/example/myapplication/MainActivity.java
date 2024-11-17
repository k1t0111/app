package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.LinearLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Log.d("xr","Activity:onCreate...");

        button=findViewById(R.id.button1);
        Intent intent=new Intent(this, MainActivity2.class);
        //intent.putExtra("name","xr");
        //intent.putExtra("age",44);

        Bundle bundle=new Bundle();
        bundle.putString("name","xr");
        bundle.putInt("age",44);
        intent.putExtras(bundle);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("xr","Activity:onRestart...");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("xr","Activity:onPause...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("xr","Activity:onDestroy...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("xr","Activity:onStop...");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("xr","Activity:onStart...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("xr","Activity:onResume...");
    }
}
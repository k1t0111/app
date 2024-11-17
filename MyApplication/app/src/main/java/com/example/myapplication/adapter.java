package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Map;

public class adapter extends RecyclerView.Adapter<adapter.MyViewHolder> {

    List<Map<String, Object>> list;
    Context context;
    View inflater;
    ActivityResultLauncher<Intent> launcher;

    public adapter(Context context,List<Map<String, Object>> list) {
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        inflater= LayoutInflater.from(context).inflate(R.layout.layout_item,viewGroup,false);

        MyViewHolder holder=new MyViewHolder(inflater);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {

        Map<String,Object> currentItem=list.get(position);
        myViewHolder.imageView.setImageResource((Integer) currentItem.get("name"));

        //myViewHolder.textView1.setText(list.get(position).toString());

        //myViewHolder.textView1.setText(list.get(position).get("name").toString());
        String str1=list.get(position).get("price").toString();
        String str2=list.get(position).get("config").toString();
        myViewHolder.textView2.setText(str1);
        myViewHolder.textView3.setText(str2);

        /*
        launcher=registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode()==666){
                            Intent data=result.getData();
                            String resultData=data.getStringExtra("result");
                            textView.setText(resultData);
                        }
                    }
                }
        );*/

        myViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, Activity_Contact_Detail.class);
                intent.putExtra("price",str1);
                intent.putExtra("config",str2);
                context.startActivity(intent);
                //launcher.launch(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView1,textView2,textView3;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.rv_imageView);
            //textView1=itemView.findViewById(R.id.rv_textView1);
            textView2=itemView.findViewById(R.id.rv_textView2);
            textView3=itemView.findViewById(R.id.rv_textView3);
        }
    }
}

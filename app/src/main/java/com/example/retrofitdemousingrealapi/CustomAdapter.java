package com.example.retrofitdemousingrealapi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{

    Context context;
    List<ObjectDataClass> dataList;


    public CustomAdapter(Context context, List<ObjectDataClass> dataList) {
        this.context = context;
        this.dataList = dataList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.row_design,viewGroup,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.slNo.setText(String.valueOf (dataList.get(position).getId ()));
        holder.name.setText(dataList.get(position).getName());
        holder.resource.setText(dataList.get(position).getResource ());
        holder.updated_at.setText(dataList.get(position).getUpdated_at ());
        holder.itemView.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent (context,Main2Activity.class);
                context.startActivity (intent);
                Toast.makeText (context, String.valueOf (dataList.get (position).getName ()), Toast.LENGTH_SHORT).show ();
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name,resource,updated_at,slNo;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            slNo  = itemView.findViewById(R.id.slNO);
            name  = itemView.findViewById(R.id.Name);
            resource      = itemView.findViewById(R.id.resource);
            updated_at      = itemView.findViewById(R.id.updated_at);

        }
    }
}

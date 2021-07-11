package com.example.krishisahayak;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList<Buyer> list;

    public MyAdapter(Context context, ArrayList<Buyer> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.items,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        Buyer buyer=list.get(position);
        holder.name.setText(buyer.getName());
        holder.pno.setText(buyer.getPhoneNo());
        holder.pname1.setText(buyer.getProduct());
        holder.price.setText(buyer.getPrice());
        holder.desc2.setText(buyer.getDesc());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name,pno,pname1,price,desc2;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.sname);
            pno=itemView.findViewById(R.id.phone);
            pname1=itemView.findViewById(R.id.product);
            price=itemView.findViewById(R.id.pricee);
            desc2=itemView.findViewById(R.id.desc1);
        }
    }
}

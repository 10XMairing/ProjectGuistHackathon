package com.hashtech.tenx.fooddistribution;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {


    private List<CustomDataType> list;
    private Context context;

    public OrderAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
    }


    public OrderAdapter(List<CustomDataType> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_row,parent,false);


        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final CustomDataType data = list.get(position);
        holder.nameTextView.setText(data.getNameOfSupplier());
        holder.addressTextView.setText(data.getAddress());
        holder.phoneTextView.setText(data.getPhone());
        holder.dayTextView.setText(data.getDay());
        holder.timeTextView.setText(data.getTime());
        holder.surplusTextView.setText(data.getSurplus());
        holder.tvEmail.setText(data.getBuyerEmail());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView nameTextView,phoneTextView,addressTextView,dayTextView,timeTextView,surplusTextView, tvEmail;
        public Button requestButton;



        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            phoneTextView = itemView.findViewById(R.id.phoneTextView);
            addressTextView = itemView.findViewById(R.id.addressTextView);
            timeTextView = itemView.findViewById(R.id.timeTextView);
            dayTextView = itemView.findViewById(R.id.dayTextView);
            surplusTextView = itemView.findViewById(R.id.surplusTextView);
            tvEmail = itemView.findViewById(R.id.tv_o_email);

        }
    }

}

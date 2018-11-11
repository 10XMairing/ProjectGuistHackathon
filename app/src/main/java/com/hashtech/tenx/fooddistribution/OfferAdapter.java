package com.hashtech.tenx.fooddistribution;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.ViewHolder>{
    private List<CustomDataType> list;
    private Context context;

    public OfferAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
    }


    public OfferAdapter(List<CustomDataType> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public OfferAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.offer_row,parent,false);


        return new OfferAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull OfferAdapter.ViewHolder holder, int position) {
        final CustomDataType data = list.get(position);
        holder.nameTextView.setText(data.getNameOfSupplier());
        holder.addressTextView.setText("Address : "+data.getAddress());
        holder.phoneTextView.setText("Contact : "+data.getPhone());
        holder.dayTextView.setText("Day : "+data.getDay());
        holder.timeTextView.setText("Time : "+data.getTime());
        holder.surplusTextView.setText("Discount : "+data.getSurplus());


        holder.requestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:"+data.getPhone()));
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView nameTextView,phoneTextView,addressTextView,dayTextView,timeTextView,surplusTextView;
        public Button requestButton;



        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            phoneTextView = itemView.findViewById(R.id.phoneTextView);
            addressTextView = itemView.findViewById(R.id.addressTextView);
            timeTextView = itemView.findViewById(R.id.timeTextView);
            dayTextView = itemView.findViewById(R.id.dayTextView);
            surplusTextView = itemView.findViewById(R.id.surplusTextView);
            requestButton = itemView.findViewById(R.id.requestButton);

        }
    }
    public void insertAndRefresh(CustomDataType data){
        if(list == null){
            list = new ArrayList<>();
            list.add(data);
            notifyDataSetChanged();
        }else {
            list.add(data);
            notifyDataSetChanged();
        }
    }

}

package com.hashtech.tenx.fooddistribution;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

public class OrderActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    OrderAdapter adapter;
    CollectionReference ref;
    FirebaseFirestore mDb;
    TextView tvheader;
    List<CustomDataType> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        list = new ArrayList<>();
        mDb = FirebaseFirestore.getInstance();
        tvheader = findViewById(R.id.tv_order_header);
        recyclerView = findViewById(R.id.recycler_orders);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String flag = getIntent().getStringExtra("flag");
        if(flag.equals("myorders")){
            tvheader.setText("My Orders");
        }else {
            tvheader.setText("Order Requests");
        }

        ref = mDb.collection("users").document(MainActivity.email).collection(flag);

        ref.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                List<DocumentSnapshot> docs = queryDocumentSnapshots.getDocuments();

                for(DocumentSnapshot d : docs){
                    String email = d.getString("email");
                    String addr = d.getString("address");
                    String contact =d.getString("contact");
                    String surplus = d.getString("surplus");
                    String buyerid = d.getString("buyerid");

                    CustomDataType data = new CustomDataType(email, contact, addr, surplus, email, buyerid);
                    list.add(data);

                }
                adapter = new OrderAdapter(list, OrderActivity.this);
                recyclerView.setAdapter(adapter);

            }
        });

    }
}

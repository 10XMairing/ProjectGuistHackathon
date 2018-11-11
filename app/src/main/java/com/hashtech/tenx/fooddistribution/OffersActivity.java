package com.hashtech.tenx.fooddistribution;

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

public class OffersActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    OfferAdapter adapter;
    CollectionReference ref;
    FirebaseFirestore mDb;
    List<CustomDataType> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);

        list = new ArrayList<>();
        mDb = FirebaseFirestore.getInstance();
        recyclerView = findViewById(R.id.recycler_offers);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        ref = mDb.collection("offers");

        ref.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                List<DocumentSnapshot> docs = queryDocumentSnapshots.getDocuments();

                for(DocumentSnapshot d : docs){
                    String email = d.getString("email");
                    String addr = d.getString("address");
                    String contact =d.getString("contact");
                    String surplus = d.getString("surplus");
                    String name = d.getString("name");
                    String time = d.getString("time");
                    String day = d.getString("day");
                    CustomDataType data = new CustomDataType(name, email, contact, addr, day, time, surplus);
                    list.add(data);
                }
                adapter = new OfferAdapter(list, OffersActivity.this);
                recyclerView.setAdapter(adapter);

            }
        });


    }
}

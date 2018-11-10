package com.hashtech.tenx.fooddistribution;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class PlaceOrderActivity extends AppCompatActivity {

    TextView tvName, tvAddr, tvContact, tvDay, tvTime,tvEmail,tvSurplus;
    Button btnPost;
    FirebaseFirestore db;

    DocumentReference suplierRef, recieverRef;


    public void getViews(){
        tvName = findViewById(R.id.tv_o_name);
        tvAddr = findViewById(R.id.tv_0_address);
        tvContact = findViewById(R.id.tv_0_phone);
        tvDay = findViewById(R.id.tv_o_day);
        tvTime = findViewById(R.id.tv_o_time);
        tvSurplus  = findViewById(R.id.tv_o_surplus);
        tvEmail  = findViewById(R.id.tv_o_email);
        btnPost  = findViewById(R.id.btn_o_order);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);
        getViews();
        Intent i = getIntent();
        String name = i.getStringExtra("tvEmail");
        final String addr =i.getStringExtra("address");
        final String contact =i.getStringExtra("tvContact");
        String day = i.getStringExtra("tvDay");
        String time = i.getStringExtra("tvTime");
        final String email = i.getStringExtra("email");
        final String surplus = i.getStringExtra("surplus");
        final String id = i.getStringExtra("id");
        tvName.setText(name);
        tvSurplus.setText(surplus);
        tvAddr.setText(addr);
        tvContact.setText(contact);
        tvDay.setText(day);
        tvTime.setText(time);
        tvEmail.setText(email);
        Log.d("TEST", ""+MainActivity.email);
        db = FirebaseFirestore.getInstance();

        suplierRef = db.collection("users").document(email);
        recieverRef = db.collection("users").document(MainActivity.email);

        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, String> data = new HashMap<>();

                data.put("email", email);
                data.put("address", addr);
                data.put("contact", contact);
                data.put("surplus", surplus);
                data.put("buyerid", MainActivity.email);

                suplierRef.collection("requests").document(id).set(data).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                    }
                });

                recieverRef.collection("myorders").document(id).set(data).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(PlaceOrderActivity.this, "Order Placed", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(PlaceOrderActivity.this, MainActivity.class);
                        startActivity(i);
                    }
                });

            }
        });


    }
}

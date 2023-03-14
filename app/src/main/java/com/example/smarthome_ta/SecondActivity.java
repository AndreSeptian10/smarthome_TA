package com.example.smarthome_ta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    String statusGas;
    String statusHumi;
    String statusTemp;
    Button btn1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView gas;
        TextView humi;
        TextView temp;

        gas = (TextView) findViewById(R.id.textgas);
        humi = (TextView) findViewById(R.id.texthumi);
        temp = (TextView) findViewById(R.id.texttemp);
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference refGas = database.getReference("gas");
        DatabaseReference refHumi = database.getReference("humidity");
        DatabaseReference refTemp = database.getReference("temperature");

        refGas = FirebaseDatabase.getInstance().getReference();
        refHumi = FirebaseDatabase.getInstance().getReference();
        refTemp = FirebaseDatabase.getInstance().getReference();

        btn1 = findViewById(R.id.btnmove);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(SecondActivity.this,ThirdActivity.class));


            }
        });

        refGas.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                statusGas = dataSnapshot.child("gas").getValue().toString();
                gas.setText(statusGas + " ppm");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        refHumi.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                statusHumi = dataSnapshot.child("humidity").getValue().toString();
                humi.setText(statusHumi + " RH");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        refTemp.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                statusTemp = dataSnapshot.child("temperature").getValue().toString();
                temp.setText(statusTemp + " °C");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
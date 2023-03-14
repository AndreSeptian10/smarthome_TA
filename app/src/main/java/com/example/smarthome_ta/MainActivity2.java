package com.example.smarthome_ta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity2 extends AppCompatActivity {


    String statusGas;
    String statusHumi;
    String statusTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


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
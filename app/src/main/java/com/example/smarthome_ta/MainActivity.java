package com.example.smarthome_ta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button onKipas = (Button) findViewById(R.id.onKipas);
        final Button offKipas = (Button) findViewById(R.id.offKipas);

        final Button ondoorLock = (Button) findViewById(R.id.ondoorLock);
        final Button offdoorLock = (Button) findViewById(R.id.offdoorLock);

        final Button onlampu = (Button) findViewById(R.id.onlampu);
        final Button offlampu = (Button) findViewById(R.id.offlampu);

        btn = findViewById(R.id.btnmove);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this,SecondActivity.class));


            }
        });





        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference refKipas = database.getReference("STATUS_KIPAS");
        DatabaseReference refdoorLock = database.getReference("STATUS_DOOR");
        DatabaseReference refLampu = database.getReference("STATUS_LAMPU");






        refKipas.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    final Long message = snapshot.getValue(Long.class);

                    if(message==1){
                        offKipas.setVisibility(View.GONE);
                        onKipas.setVisibility(View.VISIBLE);
                    }
                    else if(message==0){
                        onKipas.setVisibility(View.GONE);
                        offKipas.setVisibility(View.VISIBLE);
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        refdoorLock.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    final Long message = snapshot.getValue(Long.class);

                    if(message==1){
                        offdoorLock.setVisibility(View.GONE);
                        ondoorLock.setVisibility(View.VISIBLE);
                    }
                    else if(message==0){
                        ondoorLock.setVisibility(View.GONE);
                        offdoorLock.setVisibility(View.VISIBLE);
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        refLampu.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    final Long message = snapshot.getValue(Long.class);

                    if(message==1){
                        offlampu.setVisibility(View.GONE);
                        onlampu.setVisibility(View.VISIBLE);
                    }
                    else if(message==0){
                        onlampu.setVisibility(View.GONE);
                        offlampu.setVisibility(View.VISIBLE);
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        onKipas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myref = database.getReference("STATUS_KIPAS");

                myref.setValue(0);
            }
        });

        offKipas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myref = database.getReference("STATUS_KIPAS");

                myref.setValue(1);
            }
        });

        ondoorLock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myref = database.getReference("STATUS_DOOR");

                myref.setValue(0);
            }
        });

        offdoorLock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myref = database.getReference("STATUS_DOOR");

                myref.setValue(1);
            }
        });

        onlampu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myref = database.getReference("STATUS_LAMPU");

                myref.setValue(0);
            }
        });

        offlampu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myref = database.getReference("STATUS_LAMPU");

                myref.setValue(1);
            }
        });
    }
}
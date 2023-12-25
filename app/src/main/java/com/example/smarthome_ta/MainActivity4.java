package com.example.smarthome_ta;

import android.os.Bundle;

import com.example.smarthome_ta.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Looper;
import android.os.Handler;
import android.view.View;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.smarthome_ta.databinding.ActivityMain4Binding;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity4 extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMain4Binding binding;
    private static final int DELAY_MILLIS = 3000; // Delay setelah pengguna selesai mengetik

    private final Handler handler = new Handler(Looper.getMainLooper());
    private Runnable inputFinishedRunnable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =  ActivityMain4Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        binding.buttonvoice.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String userText = binding.editTextTextPersonName.getText().toString();
//                binding.txvResult.setText(userText);
//                sendVoiceDataToServer(userText);
//
//            }
//        });

        binding.editTextTextPersonName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                // After text changed
                String userText = editable.toString();
                binding.txvResult.setText(userText);

                // Hapus callback sebelumnya jika ada
                if (inputFinishedRunnable != null) {
                    handler.removeCallbacks(inputFinishedRunnable);
                }

                // Buat callback baru untuk menunggu sebelum mengirim data
                inputFinishedRunnable = new Runnable() {
                    @Override
                    public void run() {
                        if (!userText.isEmpty()) {
                            // You may want to add some validation before sending data
                            sendVoiceDataToServer(userText);

                            // Setel teks di EditText menjadi string kosong setelah delay
                            binding.editTextTextPersonName.setText("");
                        }
                    }
                };

                // Tunggu beberapa detik sebelum mengirim data
                handler.postDelayed(inputFinishedRunnable, DELAY_MILLIS);
                binding.txvResult.setText("masukkan perntah suara");
            }
        });

    }
    private void sendVoiceDataToServer(final String voiceData) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(" http://192.168.154.156:3030/offline"); // Ganti dengan URL server Anda
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("POST");
                    connection.setDoOutput(true);

                    // Kirim data suara ke server
                    DataOutputStream dos = new DataOutputStream(connection.getOutputStream());
                    dos.writeBytes("voice_data=" + voiceData);
                    dos.flush();
                    dos.close();

                    // Dapatkan respons dari server
                    int responseCode = connection.getResponseCode();
                    // Handle responseCode sesuai kebutuhan
                    // Debugging: Cetak informasi respons code ke konsol
                    System.out.println("Response Code: " + responseCode);

                    // Handle responseCode sesuai kebutuhan
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        // Berhasil terhubung ke server
                        // Tambahkan log atau pesan ke konsol untuk memberi tahu bahwa POST berhasil
                        System.out.println("POST berhasil!");
                    } else {
                        // Gagal terhubung ke server
                        // Tambahkan log atau pesan ke konsol untuk memberi tahu bahwa POST gagal
                        System.out.println("POST gagal. Response Code: " + responseCode);
                    }


                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


}
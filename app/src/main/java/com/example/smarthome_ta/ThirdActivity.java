package com.example.smarthome_ta;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;

import java.util.ArrayList;
import java.util.Locale;
import android.os.Bundle;

public class ThirdActivity extends AppCompatActivity {

    private TextView txvResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        txvResult = (TextView) findViewById(R.id.txvResult);
    }

    public void getSpeechInput(View view) {

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
//        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "id-ID"); // Tetapkan kode bahasa untuk bahasa Indonesia
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Ucapkan sesuatu"); // Optional, memberikan petunjuk suara kepada pengguna


        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 10);
        } else {
            Toast.makeText(this, "Your Device Don't Support Speech Input", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 10:
                if (resultCode == RESULT_OK && data != null) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String recognizedText = result.get(0);
                    txvResult.setText(recognizedText);

                    // Kirim data suara ke server
                    sendVoiceDataToServer(recognizedText);
                }
                break;
        }
    }

    private void sendVoiceDataToServer(final String voiceData) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(" https://0fbf-182-1-70-117.ngrok-free.app/voice"); // Ganti dengan URL server Anda
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

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

//@Override
//protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//    super.onActivityResult(requestCode, resultCode, data);
//
//    switch (requestCode) {
//        case 10:
//            if (resultCode == RESULT_OK && data != null) {
//                ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
//                String voiceResult = result.get(0);
//                txvResult.setText(voiceResult);
//
//                // Kirim hasil suara ke server Node.js
//                sendVoiceResultToNodeJS(voiceResult);
//            }
//            break;
//    }
//}
//
//    private void sendVoiceResultToNodeJS(String voiceResult) {
//        new Thread(() -> {
//            try {
//                URL url = new URL("http://localhost:3000"); // Ganti dengan alamat server Anda
//                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                connection.setRequestMethod("POST");
//                connection.setRequestProperty("Content-Type", "application/json");
//                connection.setDoOutput(true);
//
//                // Mengirim data JSON ke server
//                OutputStream os = connection.getOutputStream();
//                OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
//                osw.write("{\"voiceResult\": \"" + voiceResult + "\"}");
//                osw.flush();
//                osw.close();
//                os.close();
//
//                // Membaca respon dari server (jika diperlukan)
//                // InputStream is = connection.getInputStream();
//                // ...
//
//                connection.disconnect();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }).start();
//    }
//}


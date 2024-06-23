package com.example.lab3;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;




public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//
        String originalText = "cristhina weko";

        try {
            String encryptedText = FuncionEncriptar.encrypt(originalText);
            String decryptedText = FuncionEncriptar.decrypt(encryptedText);

            Log.d("Encryption", "Original: " + originalText);
            Log.d("Encryption", "Encriptado: " + encryptedText);
            Log.d("Encryption", "Desencriptado: " + decryptedText);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
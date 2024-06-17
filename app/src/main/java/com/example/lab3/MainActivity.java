package com.example.lab3;

import android.os.Bundle;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Hex;



public class MainActivity extends AppCompatActivity {
    private static final String TAG = "PruebaContras";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//yaya
        String password = "hola";
        String hashedPassword = MainActivity.hashPassword(password);
        Log.d(TAG, "Clave hash generada: " + hashedPassword);
    }
    public static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] hash = digest.digest(password.getBytes("UTF-8"));
            return Hex.encodeHexString(hash);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
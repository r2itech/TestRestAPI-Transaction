package com.fkomuniku.testcoding_qtasnim.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fkomuniku.testcoding_qtasnim.R;

public class MainActivity extends AppCompatActivity {

    Button btn_transaksi, btn_barang, btn_jenis_barang;
    Animation animAlpha;
    EditText et_token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animAlpha = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
        findViewById();
        setListener();
    }

    private void findViewById()
    {
        btn_transaksi = findViewById(R.id.btn_transaksi);
        btn_barang = findViewById(R.id.btn_barang);
        btn_jenis_barang = findViewById(R.id.btn_jenis_barang);
        et_token = findViewById(R.id.et_token);
    }

    private void setListener()
    {
        btn_transaksi.setOnClickListener(v -> {
            String token = et_token.getText().toString().trim();
            if(token.isEmpty()){
                et_token.setError("Masukan Token API!");
                return;
            }
            v.startAnimation(animAlpha);
            Intent intent = new Intent(MainActivity.this, BasicActivity.class);
            intent.putExtra("menu", "transaksi");
            intent.putExtra("token", token);
            startActivity(intent);
        });

        btn_barang.setOnClickListener(v -> {
            String token = et_token.getText().toString().trim();
            if(token.isEmpty()){
                et_token.setError("Masukan Token API!");
                return;
            }

            v.startAnimation(animAlpha);
            Intent intent = new Intent(MainActivity.this, BasicActivity.class);
            intent.putExtra("menu", "barang");
            intent.putExtra("token", token);
            startActivity(intent);
        });

        btn_jenis_barang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String token = et_token.getText().toString().trim();
                if(token.isEmpty()){
                    et_token.setError("Masukan Token API!");
                    return;
                }

                v.startAnimation(animAlpha);
                Intent intent = new Intent(MainActivity.this, BasicActivity.class);
                intent.putExtra("menu", "jenis_barang");
                intent.putExtra("token", token);
                startActivity(intent);
            }
        });
    }

    boolean doubleBackToExitPressedOnce = false;
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            finishAffinity();
            System.exit(0);
            android.os.Process.killProcess(android.os.Process.myPid());
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Tekan sekali lagi untuk keluar", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 3000);
        return;
    }
}

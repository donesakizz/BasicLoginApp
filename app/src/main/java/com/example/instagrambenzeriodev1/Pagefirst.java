package com.example.instagrambenzeriodev1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Pagefirst extends AppCompatActivity {
    BottomNavigationView bottomnavim;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagefirst);

        bottomnavim = findViewById(R.id.bottomnavim);
        //default olarak yani ilk tıklanıldıgında home ekranı gelmesi için
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler, new AnasayfaFragment()).commit();

        //fragmentler arasında geçiş yapılır.
        bottomnavim.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.Anasayfa:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler, new AnasayfaFragment()).commit();
                        break;
                        case R.id.Arama:
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler, new AramaFragment()).commit();
                            break;
                    case R.id.Hesap:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler, new HesapFragment()).commit();
                        break;
                }
                return true;
            }
        });


        /*
        //bu kısımda hata olabilir.btnaviye tıklama vermede.
        bottomnavim.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.Anasayfa:

                    case R.id.Arama:

                    case R.id.Hesap:;

                    default:
                }

                return false;
            }
        });

        */




    }




}
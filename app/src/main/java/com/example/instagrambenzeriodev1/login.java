package com.example.instagrambenzeriodev1;

//import static com.example.instagrambenzeriodev1.R.id.panelim_giris;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class login extends AppCompatActivity {

    RelativeLayout r2_giris;

    EditText username,password;
    Button login;
    DBHelper DB;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Panelin Animasyonu yapılır
        r2_giris=findViewById(R.id.panelim_giris);
        Animation anim_panel= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim_panel);
        r2_giris.startAnimation(anim_panel);


        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        DB = new DBHelper(this);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass))  {
                    Toast.makeText(login.this ,"Bütün Alanlar Doldurulmalıdır",Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean checkuserpass = DB.checkusernamepassword(user,pass);
                    if(checkuserpass==true) {
                        Toast.makeText(login.this ,"Giriş Başarılı",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),Pagefirst.class);
                        //Pagefirst classa veri göndermek için
                        //intent.putExtra("intentKAdi" ,user);
                    }
                    else {
                        Toast.makeText(login.this ,"Giriş Başarısız",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });





    }
}
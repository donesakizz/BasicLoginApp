package com.example.instagrambenzeriodev1;

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

public class signup extends AppCompatActivity {

    RelativeLayout r1_kayit ;

    EditText username,password,cPassword;
    Button signup;
    DBHelper DB;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        //Panelin Animasyonu yapılır
        r1_kayit=findViewById(R.id.panelim);
        Animation anim_panel= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim_panel);
        r1_kayit.startAnimation(anim_panel);

        username =findViewById(R.id.username);
        password =findViewById(R.id.password);
        cPassword =findViewById(R.id.cPassword);
        signup = findViewById(R.id.signup);
        DB = new DBHelper(this);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String cPass = cPassword.getText().toString();

                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(cPass))  {
                    Toast.makeText(signup.this ,"Bütün Alanlar Doldurulmalıdır",Toast.LENGTH_SHORT).show();
                }
                else {
                    if(pass.equals(cPass)){
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser==false) {
                            Boolean insert = DB.insertdata(user,pass);
                            if(insert==true) {
                                Toast.makeText(signup.this ,"Başarıyla kaydolundu",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext() , login.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(signup.this ,"Tekrar deneyin",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(signup.this ,"Kullanıcı adı  bulunamadı",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(signup.this ,"Şifreler eşleşmedi",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });




    }
}
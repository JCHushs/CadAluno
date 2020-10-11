package com.example.cadalunos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.orhanobut.hawk.Hawk;

public class LoginActivity extends AppCompatActivity {

    private Button buttonlogin;
    private TextView textViewNewRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Hawk.init(this).build();

        buttonlogin = findViewById(R.id.ButtonSingIn);
        textViewNewRegister = findViewById(R.id.TextViewRegisterLink);

        if(Hawk.contains("have_register")){
            if(Hawk.get("have_register")){
                Unblock();
            }else{
                Block();
            }
        }else{
            Block();
        }
    }
    private void Block(){
        buttonlogin.setEnabled(false);
        buttonlogin.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        textViewNewRegister.setVisibility(View.VISIBLE);
    }
    private void Unblock(){
        buttonlogin.setEnabled(true);
        buttonlogin.setBackgroundColor(getResources().getColor(R.color.white));
        textViewNewRegister.setVisibility(View.GONE);
    }

    public void NewUser(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void Main(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
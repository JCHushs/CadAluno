package com.example.cadalunos.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.example.cadalunos.R;
import com.orhanobut.hawk.Hawk;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Hawk.init(this).build();
    }

    public void Save(View view) {
        Hawk.put("have_register", true);
    }
}
package com.example.cadalunos.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cadalunos.R;
import com.example.cadalunos.model.User;
import com.example.cadalunos.model.UserViewModel;
import com.orhanobut.hawk.Hawk;

public class RegisterActivity extends AppCompatActivity {

    private UserViewModel userViewModel;
    private User currentUser;
    private EditText editTextName;
    private EditText editTextUsername;
    private EditText editTextEmail;
    private EditText editTextPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Hawk.init(this).build();

        editTextName = findViewById(R.id.EditTextName);
        editTextUsername = findViewById(R.id.EditTextUser);
        editTextEmail = findViewById(R.id.EditTextEmail);
        editTextPassword = findViewById(R.id.EditTextPassword);

        currentUser = new User();
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        userViewModel.getUser().observe((this), new Observer<User>() {
            @Override
            public void onChanged(@Nullable final User user) {
                updateView(user);
            }
        });
    }



    private void updateView(User user){
        if(user != null && user.getId() > 0){
            currentUser = user;
            editTextName.setText(user.getName());
            editTextUsername.setText(user.getUsername());
            editTextEmail.setText(user.getEmail());
            editTextPassword.setText(user.getPassword());
        }
    }

    public void Save(View view) {
        if (currentUser == null){
            currentUser = new User();
        }
        currentUser.setName(editTextName.getText().toString());
        currentUser.setUsername(editTextUsername.getText().toString());
        currentUser.setEmail(editTextEmail.getText().toString());
        currentUser.setPassword(editTextPassword.getText().toString());
        userViewModel.insert(currentUser);
        Toast.makeText(this, "Usuario Salvo com sucesso", Toast.LENGTH_SHORT).show();
        Hawk.put("have_register", true);

    }
}
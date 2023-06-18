package com.example.driver_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button register;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        email = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword);
        register = findViewById(R.id.registerButton);
        auth = FirebaseAuth.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtemail = email.getText().toString();
                String txtpwd = password.getText().toString();

                if (TextUtils.isEmpty(txtemail) || TextUtils.isEmpty(txtpwd))
                    Toast.makeText(RegisterActivity.this, "Empty credientials ", Toast.LENGTH_SHORT).show();
                else if (txtpwd.length() < 6)
                    Toast.makeText(RegisterActivity.this, "wrong password", Toast.LENGTH_SHORT).show();
                else {
                    registeruser(txtemail, txtpwd);
                }
            }
        });

    }

    private void registeruser(String mail, String pwd) {
        auth.createUserWithEmailAndPassword(mail, pwd).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(RegisterActivity.this, "Registration and login successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RegisterActivity.this,RegperActivity.class));
            }
        });



    }
}
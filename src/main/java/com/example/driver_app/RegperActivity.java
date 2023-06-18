package com.example.driver_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.FirebaseDatabase;

public class RegperActivity extends AppCompatActivity {

    private EditText name;
    private EditText num;
    private EditText add;
    private Button sub;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regper);
        sub = findViewById(R.id.SubmitButton);
        name = findViewById(R.id.PersonName);
        num = findViewById(R.id.Phone2);
        add = findViewById(R.id.PostalAddress2);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nam = name.getText().toString();
                String numb = num.getText().toString();
                String addr = add.getText().toString();
                FirebaseDatabase.getInstance().getReference().child(nam).child(numb).child(addr);
                startActivity(new Intent(RegperActivity.this,DashActivity.class));
            }
        });

    }
}
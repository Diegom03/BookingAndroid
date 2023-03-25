package com.diego.bookingproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class Principal extends AppCompatActivity {


    Button btn_logout;
    FirebaseFirestore mFirebase;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        mFirebase = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();

        btn_logout = findViewById(R.id.logout_button);

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                finish();
                startActivity(new Intent(Principal.this, Login.class));
            }
        });
    }
}
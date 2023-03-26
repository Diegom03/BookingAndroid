package com.diego.bookingproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;

public class Menu extends AppCompatActivity {

    ImageButton btn_posicion, btn_precio, btn_habitaciones, btn_reserva, btn_historial, btn_cerrar;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mAuth = FirebaseAuth.getInstance();

        btn_posicion = findViewById(R.id.posicion);
        btn_precio = findViewById(R.id.precio);
        btn_habitaciones = findViewById(R.id.habitaciones);
        btn_reserva = findViewById(R.id.reservas);
        btn_historial = findViewById(R.id.historial);
        btn_cerrar = findViewById(R.id.salir);

        btn_posicion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, Populares.class));
            }
        });

        btn_precio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, Precio.class));
            }
        });

        btn_habitaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, Populares.class));
            }
        });

        btn_reserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, Principal.class));
            }
        });

        btn_historial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, Populares.class));
            }
        });

        btn_cerrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mAuth.signOut();
                finish();
                startActivity(new Intent(Menu.this, Login.class));
            }
        });
    }
}
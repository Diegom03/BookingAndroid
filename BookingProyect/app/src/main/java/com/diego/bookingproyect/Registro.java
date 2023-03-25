package com.diego.bookingproyect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Registro extends AppCompatActivity {

    Button btn_register;
    EditText email, password;
    FirebaseFirestore mFirebase;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        mFirebase = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btn_register = findViewById(R.id.register_button);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailUser = email.getText().toString().trim();
                String passwordUser = password.getText().toString().trim();

                if (emailUser.isEmpty() && passwordUser.isEmpty()) {
                    Toast.makeText(Registro.this, "Rellena los datos para realizar esta accion", Toast.LENGTH_LONG).show();
                } else {
                    registerUser(emailUser, passwordUser);
                }
            }
        });
    }

    private void registerUser(String emailUser, String passwordUser) {
        mAuth.createUserWithEmailAndPassword(emailUser, passwordUser).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //Pilla el id del usuario
                String id = "";
                FirebaseUser currentUser = mAuth.getCurrentUser();
                if (currentUser != null) {
                    id = currentUser.getUid();
                } else {
                    Toast.makeText(Registro.this, "No se pudo obtener el usuario actual", Toast.LENGTH_SHORT).show();
                    return;
                }

                //Hace el map
                Map<String, Object> map = new HashMap<>();
                map.put("id", id);
                map.put("email", emailUser);
                map.put("password", passwordUser);

                // Si hay exito te manda a otra actividad
                mFirebase.collection("user").document(id).set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        finish();
                        Toast.makeText(Registro.this, "Usuario registrado con exito", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Registro.this, Principal.class));
                        }
                    // Si falla notifica del error
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Registro.this, "Error al guardar", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Registro.this, "Error al registrar", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
package com.diego.bookingproyect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.diego.bookingproyect.adapter.HotelAdapter;
import com.diego.bookingproyect.model.Hotel;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class Populares extends AppCompatActivity {

    FirebaseFirestore mFirebase;
    FirebaseAuth mAuth;

    ImageButton btn_logout;
    RecyclerView recyclerView;
    HotelAdapter hotelAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_populares);

        mFirebase = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();

        recyclerView = findViewById(R.id.hotels_populares);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Query query = mFirebase.collection("hotel");

        FirestoreRecyclerOptions<Hotel> firestoreRecyclerOptions = new FirestoreRecyclerOptions.Builder<Hotel>().setQuery(query, Hotel.class).build();
        hotelAdapter = new HotelAdapter(firestoreRecyclerOptions);
        hotelAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(hotelAdapter);

        btn_logout = findViewById(R.id.logout_button);

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                finish();
                startActivity(new Intent(Populares.this, Login.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        hotelAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        hotelAdapter.stopListening();
    }
}
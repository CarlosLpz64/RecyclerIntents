package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntentExplicito extends AppCompatActivity implements View.OnClickListener {

    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_explicito);

        b = findViewById(R.id.volver_btn);
        b.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        startActivity(new Intent(IntentExplicito.this, MainActivity.class));
    }
}
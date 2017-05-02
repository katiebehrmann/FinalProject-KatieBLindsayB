package com.example.android.climatehero;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Learn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
    }

    public void fossilFuels(View view) {
        Intent intent = new Intent(this, FossilFuels.class);
        startActivity(intent);
    }

    public void deforestation(View view) {
        Intent intent = new Intent(this, Deforestation.class);
        startActivity(intent);
    }

    public void recycling(View view) {
        Intent intent = new Intent(this, Recycling.class);
        startActivity(intent);
    }

    public void foodConsumption(View view) {
        Intent intent = new Intent(this, FossilFuels.class);
        startActivity(intent);
    }

    public void resourceUsage(View view) {
        Intent intent = new Intent(this, Deforestation.class);
        startActivity(intent);
    }
}

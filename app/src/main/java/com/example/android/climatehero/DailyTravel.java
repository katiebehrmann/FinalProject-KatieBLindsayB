package com.example.android.climatehero;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class DailyTravel extends AppCompatActivity {

    private int travelScore;
    private FirebaseAuth auth = FirebaseAuth.getInstance();
    private DatabaseReference scoreReference = FirebaseDatabase.getInstance().getReference(auth.getCurrentUser().getUid() + " /scores");
    private ScoreAdapter scoreAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_travel);

        scoreAdapter = new ScoreAdapter(scoreReference);
    }

    public void publicTrans(View view) {
        travelScore = 1;
    }

    public void walkBike(View view) {
        travelScore = 2;
    }

    public void car(View view) {
        travelScore = -1;
    }

    public void plane(View view) {
        travelScore = -2;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_save_or_delete, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_save:
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                return true;
            case R.id.menu_delete:
                Toast.makeText(this, "Travel deleted", Toast.LENGTH_SHORT).show();
                travelScore = 0;
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void backHome(View view) {

        Toast.makeText(this, "Travel saved", Toast.LENGTH_SHORT).show();
        Score s = new Score(travelScore, "Travel Efficiency", R.drawable.bike);
        String id = UUID.randomUUID().toString();
        scoreReference.child(id).setValue(s);

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}

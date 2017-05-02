package com.example.android.climatehero;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

public class TrackLightbulbs extends AppCompatActivity {

    private int lightbulbScore;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_lightbulbs);
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
                Toast.makeText(this, "Back to home screen", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;

            case R.id.menu_delete:
                Toast.makeText(this, "Light bulb efficiency deleted", Toast.LENGTH_SHORT).show();
                lightbulbScore = 0;

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void all(View view) {
        lightbulbScore = 2;
    }

    public void some(View view) {
        lightbulbScore = 1;
    }

    public void one(View view) {
        lightbulbScore = 0;
    }

    public void none(View view) {
        lightbulbScore = -1;
    }


    public void trackNext(View view) {
        Score s = new Score(lightbulbScore, "Light bulb Efficiency", R.drawable.lightbulb);
        Intent data = new Intent();
        data.putExtra(Keys.SCORE, s);
        setResult(RESULT_OK, data);
        finish();

        Intent i = new Intent(this, TrackDiet.class);
        startActivity(i);
    }

}

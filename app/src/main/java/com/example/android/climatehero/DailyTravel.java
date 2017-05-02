package com.example.android.climatehero;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class DailyTravel extends AppCompatActivity {

    private int travelScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_travel);
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
        Intent data = new Intent();
        data.putExtra(Keys.SCORE, s);
        setResult(RESULT_OK, data);
        finish();

    }
}

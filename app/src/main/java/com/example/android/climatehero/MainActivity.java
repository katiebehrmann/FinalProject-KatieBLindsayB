package com.example.android.climatehero;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth auth = FirebaseAuth.getInstance();
    private DatabaseReference scoreReference = FirebaseDatabase.getInstance().getReference(auth.getCurrentUser().getUid() + " /scores");
    private RecyclerView recyclerview;
    private ScoreAdapter scoreAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview = (RecyclerView) findViewById(R.id.recycle_view);
        recyclerview.setHasFixedSize(true);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        scoreAdapter = new ScoreAdapter(scoreReference);
        recyclerview.setAdapter(scoreAdapter);
    }

    public void track(View view) {
        Intent intent = new Intent(this, TrackLightbulbs.class);
        startActivity(intent);
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == 1 && resultCode == RESULT_OK) {
//            String id = UUID.randomUUID().toString();
//            Score s = (Score) data.getSerializableExtra(Keys.SCORE);
//            scoreReference.child(id).setValue(s);
//        }
//    }

    public void act(View view) {
        Intent intent = new Intent(this, CallRep.class);
        startActivity(intent);
    }

    public void learn(View view) {
        Intent intent = new Intent(this, Learn.class);
        startActivity(intent);
    }

    public void uploadImage(View view) {
        Intent i = new Intent(this, UploadImage.class);
        startActivity(i);
    }

    public void logOut(View view) {
        auth.signOut();
    }

}
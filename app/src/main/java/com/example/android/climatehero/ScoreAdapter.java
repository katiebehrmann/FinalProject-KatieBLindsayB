package com.example.android.climatehero;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.Query;

/**
 * Created by katie on 4/25/17.
 */

public class ScoreAdapter extends FirebaseRecyclerAdapter<Score, ScoreViewHolder> {

    public ScoreAdapter(Query ref) {
        super(Score.class, R.layout.card_view, ScoreViewHolder.class, ref);
    }

    @Override
    protected void populateViewHolder(ScoreViewHolder viewHolder, Score score, int position) {
        viewHolder.bind(score);
    }
}

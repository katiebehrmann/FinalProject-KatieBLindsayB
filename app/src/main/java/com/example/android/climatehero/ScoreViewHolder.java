package com.example.android.climatehero;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by katie on 4/25/17.
 */

public class ScoreViewHolder extends RecyclerView.ViewHolder {

    private CardView cardView;
    private TextView scoreScore;
    private TextView scoreName;
    private ImageView scoreImage;
    private Context context;

    public ScoreViewHolder(View itemView) {
        super(itemView);
        cardView = (CardView) itemView.findViewById(R.id.card_view);
        scoreScore = (TextView) itemView.findViewById(R.id.card_view_score);
        scoreName = (TextView) itemView.findViewById(R.id.card_view_action);
        scoreImage = (ImageView) itemView.findViewById(R.id.card_view_image);
        this.context = itemView.getContext();
    }

    public void bind(final Score score) {
        scoreName.setText(score.getAction());
        scoreScore.setText("Climate Hero points: " + score.getScore());
        if (score.getAction().equals("Food Efficiency")) {
            scoreImage.setImageResource(R.drawable.spinach);
        }
        if (score.getAction().equals("Light bulb Efficiency")) {
            scoreImage.setImageResource(R.drawable.lightbulb);
        }
        if (score.getAction().equals("Travel Efficiency")) {
            scoreImage.setImageResource(R.drawable.bike);
        }
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(scoreScore.getText().toString()) > 0) {
                    Toast.makeText(context, "Congrats, Climate Hero!", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(context, "C'mon pal!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

package com.example.android.climatehero;

import android.content.Context;
import android.icu.util.Calendar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by katie on 4/25/17.
 */

public class ScoreViewHolder extends RecyclerView.ViewHolder {

    private CardView cardView;
    private TextView scoreScore;
    private TextView scoreName;
    private ImageView scoreImage;
    private Context context;
    private Calendar rightNow;

    public ScoreViewHolder(View itemView) {
        super(itemView);
        cardView = (CardView) itemView.findViewById(R.id.card_view);
        scoreScore = (TextView) itemView.findViewById(R.id.card_view_score);
        scoreName = (TextView) itemView.findViewById(R.id.card_view_action);
        scoreImage = (ImageView) itemView.findViewById(R.id.card_view_image);
        this.context = itemView.getContext();
    }

    public void bind(final Score score) {
        Date cDate = new Date();
        String fDate = new SimpleDateFormat("yyyy-MM-dd").format(cDate);
        scoreName.setText(score.getAction() + " " + fDate);
        if (score.getScore() > 0) {
            scoreScore.setText("Climate Hero points: " + score.getScore() + "\n" +
                    "Congrats, Climate Hero!");
        } else {
            scoreScore.setText("Climate Hero points: " + score.getScore() + "\n" +
                    "YOU CAN DO BETTER!");
        }

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
                if (score.getScore() > 0) {
                    Toast.makeText(context, "Congrats, Climate Hero!", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(context, "C'mon pal!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

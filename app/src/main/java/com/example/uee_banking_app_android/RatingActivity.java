package com.example.uee_banking_app_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class RatingActivity extends AppCompatActivity {

    TextView titlerate,resultrate;
    Button btnfeedback;
    ImageView charPlace,icSprite;
    RatingBar rateStars;
    String answerValue;

    Animation charanim,anisprite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        titlerate = findViewById(R.id.titlerate);
        resultrate = findViewById(R.id.resultrate);

        btnfeedback = (Button) findViewById(R.id.btnfeedback);

        charPlace = findViewById(R.id.charPlace);
        icSprite = findViewById(R.id.icSprite);

        rateStars = findViewById(R.id.rateStars);

        charanim = AnimationUtils.loadAnimation(this,R.anim.charanim);
        anisprite = AnimationUtils.loadAnimation(this,R.anim.anisprite);

        charPlace.startAnimation(charanim);
        icSprite.startAnimation(anisprite);

        // give condition
        rateStars.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                answerValue = String.valueOf((int) (rateStars.getRating()));

                if(answerValue.equals("1")){
                    charPlace.setImageResource(R.drawable.iconestar);

                    charPlace.startAnimation(charanim);
                    icSprite.animate().alpha(0).setDuration(300).start();

                    resultrate.setText("Poor");
                }
                else if(answerValue.equals("2")){
                    charPlace.setImageResource(R.drawable.iconestar);

                    charPlace.startAnimation(charanim);
                    icSprite.animate().alpha(0).setDuration(300).start();

                    resultrate.setText("Better");
                }
                else if(answerValue.equals("3")){
                    charPlace.setImageResource(R.drawable.icthreestar);

                    charPlace.startAnimation(charanim);
                    icSprite.animate().alpha(0).setDuration(300).start();

                    resultrate.setText("Good");
                }
                else if(answerValue.equals("4")){
                    charPlace.setImageResource(R.drawable.icthreestar);

                    charPlace.startAnimation(charanim);
                    icSprite.animate().alpha(1).setDuration(300).start();
                    icSprite.startAnimation(anisprite);

                    resultrate.setText("Superb");
                }
                else if(answerValue.equals("5")){
                    charPlace.setImageResource(R.drawable.icfivestar);

                    charPlace.startAnimation(charanim);
                    icSprite.animate().alpha(1).setDuration(300).start();
                    icSprite.startAnimation(anisprite);

                    resultrate.setText("Excellent");
                }
                else {
                    Toast.makeText(RatingActivity.this, "No point", Toast.LENGTH_SHORT).show();
                }




            }
        });

        btnfeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              // Toast.makeText(RatingActivity.this, "Thank you for rated us!", Toast.LENGTH_LONG).show();
            }
        });

    }
}

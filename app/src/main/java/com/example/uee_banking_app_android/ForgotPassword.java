package com.example.uee_banking_app_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

public class ForgotPassword extends AppCompatActivity implements View.OnClickListener{
    private Button buttonSubmit;

    private AwesomeValidation awesomeValidation;
    private Animation rotationAnimation;
    private ImageView frgtLockImg;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        //createNotificationChannel();

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        buttonSubmit = (Button) findViewById(R.id.frgtPwdBtn);
        frgtLockImg = (ImageView) findViewById(R.id.frgtPwdLock);

        rotationAnimation = AnimationUtils.loadAnimation(this,R.anim.rotation);
        frgtLockImg.startAnimation(rotationAnimation);


        //adding validation to edittexts
        awesomeValidation.addValidation(this, R.id.forgotPwdEmail, Patterns.EMAIL_ADDRESS, R.string.emailerror);

        buttonSubmit.setOnClickListener(this);

    }

    public void Submit()
    {
        //addNotification();
        if (awesomeValidation.validate()) {
            Intent intent = new Intent(this, ResetInstructions.class);
            startActivity(intent);
            this.overridePendingTransition(R.anim.fade_in, R.anim.fade_out); //fade animations

            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "notificationChannel")
                    .setSmallIcon(R.drawable.email)
                    .setContentTitle("Title")
                    .setContentText("content")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
            // notificationId is a unique int for each notification that you must define
            notificationManager.notify(100, builder.build());
        }
    }

    @Override
    public void onClick(View view) {
        if (view == buttonSubmit) {
            Submit();
        }
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "forgot pwd channel";
            String description = "channel for frgt pwdd";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("notificationChannel", name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    /**
     * Disabling back button
     */
//    @Override
//    public void onBackPressed() {
//        Toast.makeText(getApplicationContext(), "Back button is disabled in this Screen", Toast.LENGTH_LONG).show();
//    }

}

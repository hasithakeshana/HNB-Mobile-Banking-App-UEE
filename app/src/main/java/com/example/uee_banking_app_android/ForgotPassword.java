package com.example.uee_banking_app_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

public class ForgotPassword extends AppCompatActivity implements View.OnClickListener{
    private Button buttonSubmit;
    NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);

    private AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        buttonSubmit = (Button) findViewById(R.id.frgtPwdBtn);

        //adding validation to edittexts
        awesomeValidation.addValidation(this, R.id.forgotPwdEmail, Patterns.EMAIL_ADDRESS, R.string.emailerror);

        buttonSubmit.setOnClickListener(this);

    }

    public void Submit()
    {
        addNotification();
        Intent intent = new Intent(this,ResetInstructions.class);
        startActivity(intent);
        this.overridePendingTransition(R.anim.fade_in, R.anim.fade_out); //fade animations
    }

    private void addNotification() {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.email)
                        .setContentTitle("Reset Password")
                        .setContentText("A reset password link has been sent to your email");
        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }

    @Override
    public void onClick(View view) {
        if (view == buttonSubmit) {
            Submit();
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

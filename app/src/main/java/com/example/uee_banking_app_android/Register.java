package com.example.uee_banking_app_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;



public class Register extends AppCompatActivity  implements View.OnClickListener{
    private EditText  editTextPwd;
    private RadioButton termsBtn;
    private Button buttonSubmit;

    NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);

    private AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        //initializing view objects
        termsBtn = (RadioButton) findViewById(R.id.radioButton);
        editTextPwd = (EditText) findViewById(R.id.regPassword);


        buttonSubmit = (Button) findViewById(R.id.button);

        //adding validation to edittexts
        awesomeValidation.addValidation(this, R.id.editTextTextPersonName, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.fnameerror);
        awesomeValidation.addValidation(this, R.id.editTextTextPersonName3, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        awesomeValidation.addValidation(this, R.id.editTextTextPersonName2, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.lnameerror);
        awesomeValidation.addValidation(this, R.id.regPassword, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.pwderror);

        buttonSubmit.setOnClickListener(this);
    }

    public void submit()
    {
        if (awesomeValidation.validate()) {
            if(termsBtn.isChecked() == true){
                Toast.makeText(this, "Validation Successfull", Toast.LENGTH_LONG).show();
                regNotification();
                Intent intent = new Intent(this, LoginDetailsMessage.class);
                startActivity(intent);
                this.overridePendingTransition(R.anim.fade_in, R.anim.fade_out); //fade animations
            }
            else {
                Toast.makeText(this, "You have to agree to the Terms & Conditions", Toast.LENGTH_LONG).show();
            }
        }

    }
    public void viewPassword(View v)
    {
        editTextPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
    }

    private void regNotification() {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.email)
                        .setContentTitle("Verification Email")
                        .setContentText("A verification link has been sent to your email");
        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }

    @Override
    public void onClick(View view) {
        if (view == buttonSubmit) {
            submit();
        }
    }

}


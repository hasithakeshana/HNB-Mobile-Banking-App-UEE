package com.example.uee_banking_app_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;


public class Register extends AppCompatActivity {
    private EditText  editTextPwd;
    private EditText  editTextFName;
    private EditText  editTextLName;
    private EditText  editTextEmail;
    private RadioButton termsBtn;
    private Button buttonSubmit;

    private Animation zoomAnimation;
    private TextView newAcc;

    //NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);

     AwesomeValidation awesomeValidation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        newAcc = (TextView) findViewById(R.id.tvNewAcc);

        zoomAnimation = AnimationUtils.loadAnimation(this,R.anim.zoomin);
        newAcc.startAnimation(zoomAnimation);

        //initializing view objects
        termsBtn = (RadioButton) findViewById(R.id.termsRadioBtn);
        editTextPwd = (EditText) findViewById(R.id.regPassword);
        editTextFName = (EditText) findViewById(R.id.editTextTextPersonName);
        editTextLName = (EditText) findViewById(R.id.editTextTextPersonName2);
        editTextEmail = (EditText) findViewById(R.id.editTextTextPersonName3);


        buttonSubmit = (Button) findViewById(R.id.button);

    }



    public void regSubmit(View view){
        final String pwd=editTextPwd.getText().toString();
        final String fname=editTextFName.getText().toString();
        final String lname=editTextLName.getText().toString();
        final String email=editTextEmail.getText().toString();
            if(fname.length()==0)
            {
                editTextFName.requestFocus();
                editTextFName.setError("Field cannot be empty");
            }
            else if(!fname.matches("[a-zA-Z ]+"))
            {
                editTextFName.requestFocus();
                editTextFName.setError("Enter valid name");
            }
            else if(lname.length()==0)
            {
                editTextLName.requestFocus();
                editTextLName.setError("Field cannot be empty");
            }
            else if(!lname.matches("[a-zA-Z ]+")) {
                editTextLName.requestFocus();
                editTextLName.setError("Enter valid name");
            }
            else if(email.length()==0)
            {
                editTextEmail.requestFocus();
                editTextEmail.setError("Field cannot be empty");
            }
            else if(!email.matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$"))
            {
                editTextEmail.requestFocus();
                editTextEmail.setError("Enter valid email");
            }
            else if(pwd.length()==0)
            {
                editTextPwd.requestFocus();
                editTextPwd.setError("Field cannot be empty");
            }
            else if(!termsBtn.isChecked())
            {
                Toast.makeText(Register.this,"You need to accept the terms & conditions",Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(Register.this,"Account created successfully",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, LoginDetailsMessage.class);
                startActivity(intent);
                this.overridePendingTransition(R.anim.fade_in, R.anim.fade_out); //fade animations

            }
    }

    public void viewPassword(View v)
    {
        editTextPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
    }

    /*private void regNotification() {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.email)
                        .setContentTitle("Verification Email")
                        .setContentText("A verification link has been sent to your email");
        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }*/



}


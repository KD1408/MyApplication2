package com.kurta.example.admin.kruta;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.admin.kurta.R;


public class signup extends AppCompatActivity {

    TextView tv1;
    EditText etFirst, etLast, etPhone, etEmail, etPass, etConPass;
    Button btnNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        tv1 = (TextView) findViewById(R.id.tv1);
        etFirst = (EditText) findViewById(R.id.etFname);
        etFirst.setSelected(true);
        etLast = (EditText) findViewById(R.id.etLname);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etPass = (EditText) findViewById(R.id.etSPass);
        btnNext = (Button) findViewById(R.id.btnNext);
        etConPass = (EditText) findViewById(R.id.etCPass);

        Typeface headerFont = Typeface.createFromAsset(getAssets(), "Fonts/montserrat-Bold.otf");
        Typeface bodyFont = Typeface.createFromAsset(getAssets(), "Fonts/montserrat-Regular.otf");
        Typeface btnFont = Typeface.createFromAsset(getAssets(), "Fonts/montserrat-Medium.otf");

        tv1.setTypeface(headerFont);
        tv1.setTextColor(Color.WHITE);
        btnNext.setTextColor(Color.WHITE);
        btnNext.setTypeface(btnFont);
        etFirst.setTextColor(Color.WHITE);
        etFirst.setTypeface(bodyFont);
        etFirst.setHintTextColor(Color.WHITE);
        etLast.setTextColor(Color.WHITE);
        etLast.setTypeface(bodyFont);
        etLast.setHintTextColor(Color.WHITE);
        etEmail.setTextColor(Color.WHITE);
        etEmail.setTypeface(bodyFont);
        etEmail.setHintTextColor(Color.WHITE);
        etPhone.setTextColor(Color.WHITE);
        etPhone.setTypeface(bodyFont);
        etPhone.setHintTextColor(Color.WHITE);
        etPass.setTextColor(Color.WHITE);
        etPass.setTypeface(bodyFont);
        etPass.setHintTextColor(Color.WHITE);
        etConPass.setTextColor(Color.WHITE);
        etConPass.setTypeface(bodyFont);
        etConPass.setHintTextColor(Color.WHITE);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(etFirst.getText().toString())) {
                     //Toast.makeText(signup.this, etFirst.getText().toString(), Toast.LENGTH_LONG).show();
                    etFirst.setError("Enter First Name");
                        return;
                    }
                if (TextUtils.isEmpty(etLast.getText().toString())) {
                        etLast.setError("Enter Last Name");
                        return;
                    }
                if (TextUtils.isEmpty(etEmail.getText().toString())) {
                        etEmail.setError("Enter Email");
                        return;
                    }
                if (TextUtils.isEmpty(etPhone.getText().toString())) {
                        etPhone.setError("Enter Phone");
                        return;
                    }
                if (TextUtils.isEmpty(etPass.getText().toString())) {
                        etPass.setError("Enter Password");
                        return;
                    }
                if (TextUtils.isEmpty(etConPass.getText().toString())) {
                        etConPass.setError("Confirm Password");
                        return;
                    }
                if(!(etConPass.getText().toString()).equals(etPass.getText().toString())){
                        etConPass.setError("Password should match");
                    }
                if (!etFirst.getText().toString().isEmpty() && !etLast.getText().toString().isEmpty() &&
                        !etEmail.getText().toString().isEmpty() && !etPhone.getText().toString().isEmpty() &&
                        !etPass.getText().toString().isEmpty() && !etConPass.getText().toString().isEmpty() &&
                        etConPass.getText().toString().equals(etPass.getText().toString()) ) {
                        Intent i = new Intent(signup.this, signup_next.class);
                        i.putExtra("FirstName", ""+etFirst.getText().toString());
                        i.putExtra("LastName",""+etLast.getText().toString());
                        i.putExtra("Email",""+etEmail.getText().toString());
                        i.putExtra("Phone",""+etPhone.getText().toString());
                        i.putExtra("Password",""+etConPass.getText().toString());
                        startActivity(i);
                    }
                }
        });
    }
}

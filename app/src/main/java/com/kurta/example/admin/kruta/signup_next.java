package com.kurta.example.admin.kruta;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.example.admin.kurta.R;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;


public class signup_next extends AppCompatActivity {

    Button btnSignup;
    EditText etState, etCity, etStreet, etZipcode, etDOB;
    AutoCompleteTextView actvCountry;
    Spinner spnRelation;
    String targetURL = "http://parivar.me/api/v1/users/create";
    TextView tvFname, tvLname, tvEmail, tvPhone, tvPass, tvCid;
    String getFname, getLname, getEmail, getPhone, getPass;
    RadioGroup rg;
    RadioButton rb, rbFemale;


    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_next);

        Intent i = getIntent();
        Bundle bd = i.getExtras();

        ctx = getApplicationContext();
        tvFname = (TextView) findViewById(R.id.tvFname);
        tvLname = (TextView) findViewById(R.id.tvLname);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvPhone = (TextView) findViewById(R.id.tvPhone);
        tvPass = (TextView) findViewById(R.id.tvPassword);
        rg = (RadioGroup) findViewById(R.id.rgGender);
        rbFemale = (RadioButton) findViewById(R.id.rbFemale);
        tvCid = (TextView) findViewById(R.id.tvCID);
        btnSignup = (Button) findViewById(R.id.btnSignup);
        spnRelation = (Spinner) findViewById(R.id.spnRelation);
        etDOB = (EditText) findViewById(R.id.etBdate);
        actvCountry = (AutoCompleteTextView) findViewById(R.id.actvCntry);
        etState = (EditText) findViewById(R.id.etState);
        etStreet = (EditText) findViewById(R.id.etStreet);
        etZipcode = (EditText) findViewById(R.id.etZip);
        etCity = (EditText) findViewById(R.id.etCity);

        if(bd != null){
            getFname = (String) bd.get("FirstName");
            tvFname.setText(getFname);
            getLname = (String) bd.get("LastName");
            tvLname.setText(getLname);
            getEmail = (String) bd.get("Email");
            tvEmail.setText(getEmail);
            getPhone = (String) bd.get("Phone");
            tvPhone.setText(getPhone);
            getPass = (String) bd.get("Password");
            tvPass.setText(getPass);
        }

        Typeface bodyFont = Typeface.createFromAsset(getAssets(), "Fonts/montserrat-Regular.otf");
        Typeface btnFont = Typeface.createFromAsset(getAssets(), "Fonts/montserrat-Medium.otf");

        btnSignup.setTextColor(Color.WHITE);
        btnSignup.setTypeface(btnFont);
        etDOB.setTextColor(Color.WHITE);
        etDOB.setTypeface(bodyFont);
        etDOB.setHintTextColor(Color.WHITE);
        actvCountry.setTextColor(Color.WHITE);
        actvCountry.setTypeface(bodyFont);
        actvCountry.setHintTextColor(Color.WHITE);
        etState.setTextColor(Color.WHITE);
        etState.setTypeface(bodyFont);
        etState.setHintTextColor(Color.WHITE);
        etStreet.setTextColor(Color.WHITE);
        etStreet.setTypeface(bodyFont);
        etStreet.setHintTextColor(Color.WHITE);
        etZipcode.setTextColor(Color.WHITE);
        etZipcode.setTypeface(bodyFont);
        etZipcode.setHintTextColor(Color.WHITE);
        etCity.setTextColor(Color.WHITE);
        etCity.setTypeface(bodyFont);
        etCity.setHintTextColor(Color.WHITE);


        String[] items = new String[]{"Single", "Married", "Divorcee", "Widow"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spnRelation.setAdapter(adapter);

        etDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });
        ArrayList<String> countries = new ArrayList<String>();
        Locale[] locales = Locale.getAvailableLocales();
        for (Locale locale : locales) {
            String country = locale.getDisplayCountry();
            if (country.trim().length() > 0 && !countries.contains(country)) {
                countries.add(country);
            }
        }

        ArrayAdapter<String> adapCoun = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
        actvCountry.setAdapter(adapCoun);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectGen = rg.getCheckedRadioButtonId();
                rb = (RadioButton) findViewById(selectGen);

                if (rg.getCheckedRadioButtonId() == -1) {
                    rbFemale.setError("Select Gender");
                }
                if (TextUtils.isEmpty(actvCountry.getText().toString())){
                    actvCountry.setError("Enter Country Name");
                }
                if (TextUtils.isEmpty(etStreet.getText().toString())){
                    etStreet.setError("Enter Address");
                }
                if(TextUtils.isEmpty(etCity.getText().toString())){
                    etCity.setError("Enter City Name");
                }
                if(TextUtils.isEmpty(etState.getText().toString())){
                    etState.setError("Enter State Name");
                }
                if (TextUtils.isEmpty(etZipcode.getText().toString())){
                    etZipcode.setError("Enter Zip Code");
                }
                else {
                    try {
                        postData d = new postData();
                        d.execute(tvFname.getText().toString(), tvLname.getText().toString(), tvEmail.getText().toString(),
                                tvPass.getText().toString(), "https://www.google.com/search?q=entersafe=off", etDOB.getText().toString(), rb.getText().toString().toLowerCase(),
                                spnRelation.getSelectedItem().toString().toLowerCase(), tvCid.getText().toString(), "04/09/2016").get();

                        if (d.result.get(0) == "204") {
                            //Intent intent = new Intent(main.this, ListViewImage.class); startActivity(intent); finish();
                            Intent i = new Intent(signup_next.this, MainActivity.class);
                            startActivity(i);
                            Toast.makeText(signup_next.this, "Sign Up successful. Please check your Email for Verification.", Toast.LENGTH_LONG).show();
                            finish();

                        } else {
                            Toast.makeText(signup_next.this, "Incorrect Signup Data", Toast.LENGTH_LONG).show();
                        }

                    } catch (Throwable t) {
                        Log.e("JSON error", "" + t);
                    }
                }
            }
        });

    }

    private void showDatePicker(){
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public class postData extends AsyncTask<String, String, String> {

        String res = "";
        URL url;
        //JSONObject obj = new JSONObject();
        HttpURLConnection connection = null;
        InputStream is;
        int response;
        //int byteRead = -1;
        //byte[] buffer = new byte[1024];
        //String sData;
        //Context ctx;
        ArrayList result;

        @Override
        protected String doInBackground(String...param) {

            try {
                result = new ArrayList();
                url = new URL(targetURL);
                connection = (HttpURLConnection)url.openConnection();
                connection.setDoOutput(true);
                connection.setRequestMethod("POST"); // hear you are telling that it is a POST request, which can be changed into "PUT", "GET", "DELETE" etc.
                connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;"); // here you are setting the `Content-Type` for the data you are sending which is `application/json`
                connection.setRequestProperty("Content-Type", "application/json");
                connection.connect();

                //Send request
                DataOutputStream wr = new DataOutputStream(
                        connection.getOutputStream ());
                JSONObject js = new JSONObject();
                js.put("fname",param[0]);
                js.put("lname",param[1]);
                js.put("email",param[2]);
                js.put("password",param[3]);
                js.put("pictureUrl",param[4]);
                js.put("dob",param[5]);
                js.put("gender",param[6]);
                js.put("relationShip",param[7]);
                js.put("communityId",param[8]);
                js.put("createdAt",param[9]);
                wr.writeBytes(js.toString());
                wr.flush();
                wr.close ();

                //ctx = param[2];

                response = connection.getResponseCode();
                if (response >= 200 && response <=399){
                    Log.v("R type",""+response);
                    is = connection.getInputStream();
                    result.add(0,"204");
                } else {
                    Log.v("R type",""+response);
                    is = connection.getErrorStream();
                    result.add(0,"400");
                }

                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String line;
                    StringBuilder sb = new StringBuilder();
                    while((line = br.readLine()) != null){
                        sb.append(line + "\n");
                    }
                    br.close();
                    res = sb.toString();
                    result.add(1,res);
                    Log.v("Response is", res+"something something");
                }
                catch (IOException e){
                    Log.e("Error","Read Error");
                }
                //onPostExecute("wow");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

                if(connection != null) {
                    connection.disconnect();
                }
            }
            return res;
        }

    }
}
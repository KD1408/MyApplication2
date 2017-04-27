package com.kurta.example.admin.kruta;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.admin.kurta.R;
import com.kurta.example.admin.kruta.Utils.ConnectionDetector;
import com.kurta.example.admin.kruta.volly.OnVolleyHandler;
import com.kurta.example.admin.kruta.volly.VolleyIntialization;
import com.kurta.example.admin.kruta.volly.WebService;


import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    TextView tvEnter,tvAcc;
    EditText etUser, etPass;
    Button btnLgn;
    Context ctx;
    ConnectionDetector cd;
    String TAG = "MainActivity :: ";
    String str_full_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvEnter = (TextView) findViewById(R.id.tv1);
        tvAcc =(TextView) findViewById(R.id.tv2);
        btnLgn = (Button) findViewById(R.id.btnLogin);
        etUser = (EditText) findViewById(R.id.etUsername);
        etUser.setSelected(true);
        etPass = (EditText) findViewById(R.id.etPassword);

        ctx = getApplicationContext();
        cd = new ConnectionDetector(ctx);

        Typeface headerFont = Typeface.createFromAsset(getAssets(), "Fonts/montserrat-Bold.otf");
        Typeface bodyFont = Typeface.createFromAsset(getAssets(), "Fonts/montserrat-Regular.otf");
        Typeface btnFont = Typeface.createFromAsset(getAssets(), "Fonts/montserrat-Medium.otf");
        tvEnter.setTypeface(headerFont);
        tvEnter.setTextColor(Color.WHITE);
        tvAcc.setTextColor(Color.WHITE);
        btnLgn.setTextColor(Color.WHITE);
        btnLgn.setTypeface(btnFont);
        etUser.setTextColor(Color.WHITE);
        etUser.setTypeface(bodyFont);
        etUser.setHintTextColor(Color.WHITE);
        etPass.setTextColor(Color.WHITE);
        etPass.setTypeface(bodyFont);
        etPass.setHintTextColor(Color.WHITE);
        tvAcc.setTypeface(bodyFont);
        tvAcc.setPaintFlags(tvAcc.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        btnLgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(etUser.getText().toString())) {
                    etUser.setError("Enter Username");
                    return;
                } else if (TextUtils.isEmpty(etPass.getText().toString())) {
                    etPass.setError("Enter Password");
                    return;
                }

                if (!etUser.getText().toString().isEmpty() && !etPass.getText().toString().isEmpty()) {

                    try {
                          //@kaians.p
                        if (cd.isConnectingToInternet()) {

                            //api calls
                            webcallLogin();

                        } else {

                        }

                    } catch (Throwable t) {
                        Log.e("JSON error", "Error" +t);
                    }

                }

            }
        });

        tvAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent singupAct = new Intent(MainActivity.this, signup.class);
                startActivity(singupAct);

            }
        });
    }

    private void webcallLogin() {

        try {
            VolleyIntialization v = new VolleyIntialization(MainActivity.this, true, true);
            final String email = etUser.getText().toString();
            final String password = etPass.getText().toString();


            Log.e(TAG, "email :: " + email);
            Log.e(TAG,"password :: "+password);


            WebService.Login(v, email, password, new OnVolleyHandler() {
                @Override
                public void onVollySuccess(String response) {
                    if (MainActivity.this.isFinishing()) {
                        return;
                    }
                    Log.e("webcallLogin :: ", response);
                    getResponseForLogin(response);
                    //{"status":true,"message":"Logged in successfully.","data":{"id":"58f7fe4f0825946626c0d9b7",
                    // "userId":6,"fname":"krutarth","lname":"doshi","email":"krutarthdoshi14@gmail.com",
                    // "gender":"male","relationShip":"single","isOnline":false,"isActive":false,"isVerified":false,
                    // "communities":[],"dob":"1993-08-14T00:00:00.000Z","addresses":[null],"qualifications":[],
                    // "occupations":[],"phones":[{"privacy":"public","type":"Mobile","number":"9197491159"}],
                    // "communityId":"57dd00df45b169efde7dbe98","token":"rJxuLCuSCe","phone":"9197491159"}}

                    try{
                    JSONObject responseText = new JSONObject(response);

                    JSONObject json_data = responseText.getJSONObject("data");

                    String str_fname = json_data.getString("fname");
                    String str_lname = json_data.getString("lname");
                    str_full_name = String.valueOf(str_fname)+" "+ String.valueOf(str_lname);

                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        intent.putExtra("UserEmail", etUser.getText().toString());//email
                        intent.putExtra("UserName", str_full_name);

                        intent.putExtra("fname", json_data.getString("fname"));
                        intent.putExtra("lname", json_data.getString("lname"));
                        intent.putExtra("gender", json_data.getString("gender"));
                        intent.putExtra("relationShip", json_data.getString("relationShip"));
                        intent.putExtra("dob", json_data.getString("dob"));
                        intent.putExtra("phone",json_data.getString("phone"));

                        startActivity(intent);
                        finish();

                    }catch(JSONException e){
                        Log.i("JSON Error", e + "");
                    }
                }

                @Override
                public void onVollyError(String error) {
                    Log.e("webcallLogin ::", error);
                    Toast.makeText(MainActivity.this, "" + error, Toast.LENGTH_LONG).show();
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("JSONException ::",":: "+e);
        }

    }


    private void getResponseForLogin(String response) {
    }

}

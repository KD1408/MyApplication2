package com.kurta.example.admin.kruta;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.AsyncTask;
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

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tvEnter,tvAcc;
    EditText etUser, etPass;
    String targetURL = "http://parivar.me/api/v1/users/auth";
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
                   // postData newData = new postData();


                    try {
                      /*  postData d = new postData();
                        d.execute(etUser.getText().toString(), etPass.getText().toString()).get();
                  */      //@kaians.p
                        if (cd.isConnectingToInternet()) {

                            //api calls
                            webcallLogin();

                        } else {

                        }

                     /*   if (d.result.get(0) == "200"){

                            //@kaians.p
                           // Intent intent = new Intent(MainActivity.this, profile.class);
                            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                            intent.putExtra("UserEmail", etUser.getText().toString());
                            startActivity(intent);
                            finish();

                        }
                        else {
                            if (view != null) {
                                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                                Toast.makeText(MainActivity.this,"Incorrect Username or Password",Toast.LENGTH_LONG).show();
                            }
                        }*/

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
            //strEmail,strPassword,strSecurityKey ,inCnNum,strMobile compsolary
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

                    try{
                    JSONObject responseText = new JSONObject(response);

                    JSONObject json_data = responseText.getJSONObject("data");

                    String str_fname = json_data.getString("fname");
                    String str_lname = json_data.getString("lname");
                    str_full_name = String.valueOf(str_fname)+" "+ String.valueOf(str_lname);

                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        intent.putExtra("UserEmail", etUser.getText().toString());
                        intent.putExtra("UserName", str_full_name);
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



    //-------------------------------------------------------------------------------------
    public class postData extends AsyncTask<String, String, String>{

        String res = "";
        URL url;
        //JSONObject obj = new JSONObject();
        HttpURLConnection connection = null;
        InputStream is;
        int response;
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
                js.put("email",param[0]);
                js.put("password",param[1]);
                wr.writeBytes(js.toString());
                wr.flush();
                wr.close ();

                //ctx = param[2];

                response = connection.getResponseCode();
                if (response >= 200 && response <=399){
                    Log.v("R type",""+response);
                    is = connection.getInputStream();
                    result.add(0,"200");
                } else {
                    Log.v("R type",""+response);
                    is = connection.getErrorStream();
                    result.add(0,"404");
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

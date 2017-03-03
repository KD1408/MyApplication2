package com.kurta.example.admin.kruta.volly;



import com.android.volley.Request;
import com.kurta.example.admin.kruta.Utils.URLS;


import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

public class WebService {



    //for user login

    public static void Login(VolleyIntialization vollyInit, String email ,String password,OnVolleyHandler vollyHanlder) throws JSONException {



        String url = URLS.WEB_LOGIN;
        Map<String, String> params = new HashMap<>();

       // params.put(WebServiceTag.TAG_STR_APIKEY, CV.API_KEY);
        params.put(WebServiceTag.TAG_EMAIL, email); //here comes ur key and value of params
        params.put(WebServiceTag.TAG_PASSWORD, password);


        vollyInit.vollyStringRequestCall(url, Request.Method.POST, params, vollyHanlder);
    }




}


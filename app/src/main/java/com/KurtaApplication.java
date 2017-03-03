package com;

import android.app.Application;
import android.content.Context;

import com.kurta.example.admin.kruta.volly.VolleySingleton;


/**
 * Created by admin on 13-Feb-17.
 */


public class KurtaApplication extends Application {


    public Context mContext;
    public VolleySingleton volley;


    @Override
    public void onCreate() {
        super.onCreate();

        mContext = getApplicationContext();
        volley = new VolleySingleton(mContext);

    }
}

package com.kurta.example.admin.kruta.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.TextView;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import org.xmlpull.v1.XmlPullParserException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CM {

    private final static String FRAGMENT_TAG_LOGIN = "frag_login";





    /**
     * Checking Internet is available or not
     *
     * @param context
     * @return
     */
    public static boolean isInternetAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }

    public static void setSp(Context activity, String key, Object value) {
        SharedPreferences prefs = activity.getSharedPreferences(
                activity.getPackageName(), Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        if (value instanceof String) {
            editor.putString(key, (String) value);
        } else if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        } else if (value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        } else if (value instanceof Long) {
            editor.putLong(key, (Long) value);
        } else if (value instanceof Float) {
            editor.putFloat(key, (Float) value);
        }

        editor.commit();
        editor = null;
        prefs = null;

    }




    /**
     * Image Loader Default image remaining
     *
     * @param activity
     * @param isRounded
     * @return
     */
    public static DisplayImageOptions setImageLoaderInitialize(Activity activity, boolean isRounded, Drawable drawable) {
        if (drawable != null) {
            Log.d("tag", "Image Drawable is not null");
        }
        if (isRounded) {
            DisplayImageOptions options = new DisplayImageOptions.Builder()
                    .showImageOnLoading(drawable)
                    .resetViewBeforeLoading(true)
                    .showImageForEmptyUri(drawable).showImageOnFail(drawable)
                    .cacheInMemory(true).cacheOnDisk(true).considerExifParams(true)
                    .bitmapConfig(Bitmap.Config.RGB_565)
                    .displayer(new RoundedBitmapDisplayer(360)).build();
            return options;
        } else {
//Progressbar image reminaing
            DisplayImageOptions options = new DisplayImageOptions.Builder()
                    .showImageOnLoading(drawable)
                    .resetViewBeforeLoading(true)
                    .showImageForEmptyUri(drawable).showImageOnFail(drawable)
                    .cacheInMemory(true).cacheOnDisk(true).considerExifParams(true)
                    .bitmapConfig(Bitmap.Config.RGB_565).build();
            return options;
        }
    }

    public static String converDateFormate(String oldpattern,
                                           String newPattern, String dateString) {
        // SimpleDateFormat sdf = new SimpleDateFormat(oldpattern);
        SimpleDateFormat sdf = new SimpleDateFormat(oldpattern,
                CV.LOCALE_USE_DATEFORMAT);
        Date testDate = null;
        try {
            testDate = sdf.parse(dateString);
            SimpleDateFormat formatter = new SimpleDateFormat(newPattern,
                    CV.LOCALE_USE_DATEFORMAT);
            String newFormat = formatter.format(testDate);
           // System.out.println("" + newFormat);
            return newFormat;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "";
        }
    }





    public static String Validation(String[] edittextName, TextView... edt) {
        String message = null;
        for (int i = 0; i < edt.length; i++) {
            if (edt[i].getText().length() > 0) {
                message = CV.Valid;
            } else {
                message = edittextName[i] + " is required.";
                break;
            }
        }
        return message;
    }

    public static <T> T JsonParse(T t, String response)
            throws JsonSyntaxException, IOException, XmlPullParserException {
        InputStream in = new ByteArrayInputStream(response.getBytes());
        JsonReader reader;
        reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        GsonBuilder b = new GsonBuilder();
        b.registerTypeAdapter(boolean.class, new BooleanSerializer());
        Gson gson = b.create();
        t = (T) gson.fromJson(reader, t.getClass());
        reader.close();
        return t;
    }

    /**
     * Json Response using key value
     *
     * @param Key
     * @param response
     * @return
     */
    public static String getValueFromJson(String Key, String response) {
        // if you use below code then it will throw null pointer exception when
        // key is not found in jsonResponse
        Gson gson = new Gson();
        ByteArrayInputStream io = new ByteArrayInputStream(
                response.getBytes());
        Reader reader = new InputStreamReader(io);
        JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
        return jsonObject.get(Key).getAsString();
    }

    public static boolean isEmailValid(String email) {
        String regExpn = "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(regExpn, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);

        if (matcher.matches())
            return true;
        else
            return false;
    }





}


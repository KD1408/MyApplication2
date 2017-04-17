package com.kurta.example.admin.kruta.volly;

import android.app.Activity;
import android.graphics.Bitmap;
import android.util.Log;


import com.KurtaApplication;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.admin.kurta.R;
import com.kurta.example.admin.kruta.Utils.CM;


import org.json.JSONException;

import java.util.Map;


/**
 * Created by jaimin on 15-12-2015.
 */
public class VolleyIntialization {
    private Activity mActivity;

    private boolean mIsShowPopup;
    private boolean mIsDismissPopup;
    private MtplProgressDialog mtplDialog;

    public VolleyIntialization(Activity activity, boolean showpopup, boolean dismisspopup) {

        mActivity = activity;
        mIsShowPopup = showpopup;
        mIsDismissPopup = dismisspopup;

    }

    public Activity getActivity() {
        return mActivity;
    }

    public boolean getShowPopup() {
        return mIsShowPopup;
    }

    public boolean getDismissPopup() {
        return mIsDismissPopup;
    }

//Volly Webservice Related Methods //


    public void vollyStringRequestCall(String url, final int requestMethod, final Map<String, String> params, final OnVolleyHandler vollyHandler) throws JSONException {
        //AS we have to pass Security key in ever webservice we have
//        if (json != null) {
//            json.put("strSecurityKey", CV.SECURITY_KEY);
//        }

        if (mIsShowPopup) {

            showMtplDialog(mActivity);
        }
        Log.e("WebCalls", url);
        StringRequest stringRequest = new StringRequest(requestMethod,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String strResponseStatus = CM.getValueFromJson(WebServiceTag.WEB_STATUS, response);
                        if (strResponseStatus.equalsIgnoreCase(WebServiceTag.WEB_STATUSFAIL)) {
                            dismissMtplDialog(mActivity);
                        } else {
                            if (mIsDismissPopup) {
                                dismissMtplDialog(mActivity);
                            }
                        }
                        vollyHandler.onVollySuccess(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Webcalls", "error=" + error.getMessage());
                dismissMtplDialog(mActivity);
                String errorSet = getActivity().getResources().getString(R.string.msg_networkerror);
                vollyHandler.onVollyError(errorSet);

            }
        }) {
            /*@Override
            public String getBodyContentType() {
                // TODO Auto-generated method stub
                return "application/json";
            }*/

           /* @Override
            public byte[] getBody() {

                Log.i("Webcalls", "Json=" + json.toString());
                try {
                    return json.toString().getBytes("utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                return null;
            }*/

            @Override
            protected Map<String, String> getParams()
            {
                Log.e("Webcalls", "params=" + params.toString());
                return params;
            }
        };

        ((KurtaApplication) mActivity.getApplicationContext()).volley.addToRequestQueue(stringRequest);

    }


    //Volly Webservice Related Methods End //
    public void showMtplDialog(Activity mActivity) {
        if (mActivity.isFinishing()) {
            return;
        }
        if (mtplDialog == null)
            mtplDialog = new MtplProgressDialog(mActivity, "", false);
        if (!mtplDialog.isShowing())
            mtplDialog.show();
    }

    private void dismissMtplDialog(Activity activity) {

        if (mtplDialog != null && mtplDialog.isShowing())
            mtplDialog.dismiss();
    }


    public void vollyStringRequestCallwithFile(String url, final Bitmap f ,final int requestMethod, final Map<String, String> params, final OnVolleyHandler vollyHandler) throws JSONException {

        if (!CM.isInternetAvailable(mActivity)) {
            vollyHandler.onVollyError(mActivity.getResources().getString(R.string.msg_internet_unavailable_msg));
            return;
        }
        if (mIsShowPopup) {
            showMtplDialog(mActivity);
        }


        MutipartRequest mr = new MutipartRequest(url, new Response.Listener<String>(){

            @Override
            public void onResponse(String response) {
                Log.e("response", response);
                String strResponseStatus = CM.getValueFromJson(WebServiceTag.WEB_STATUS, response);
                if (strResponseStatus.equalsIgnoreCase(WebServiceTag.WEB_STATUSFAIL)) {
                    dismissMtplDialog(mActivity);
                } else {
                    if (mIsDismissPopup) {
                        dismissMtplDialog(mActivity);
                    }
                }
                vollyHandler.onVollySuccess(response);
            }


        }, new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Webcalls", "error=" + error.getMessage());
                dismissMtplDialog(mActivity);
                String errorSet = error.getMessage();
                vollyHandler.onVollyError(errorSet);
            }

        },f, params);

        ((KurtaApplication) mActivity.getApplicationContext()).volley.addToRequestQueue(mr);

    }
}

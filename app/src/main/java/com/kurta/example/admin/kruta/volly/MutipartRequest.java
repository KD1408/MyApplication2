package com.kurta.example.admin.kruta.volly;

import android.graphics.Bitmap;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;

import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.StringBody;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;


public class MutipartRequest extends Request<String> {

    private org.apache.http.entity.mime.MultipartEntity entity = new org.apache.http.entity.mime.MultipartEntity();

    private static final String FILE_PART_NAME = WebServiceTag.TAG_IMAGE;

   // params.put(, bab.toString());

    private final Response.Listener<String> mListener;
    private final Bitmap file;
    private final Map<String, String> params;


    public MutipartRequest(String url, Response.Listener<String> listener, Response.ErrorListener errorListener, Bitmap file, Map<String, String> params) {
        super(Method.POST, url, errorListener);

        mListener = listener;
        this.file = file;

        this.params = params;
        buildMultipartEntity();
    }

    private void buildMultipartEntity() {
        try {


            if (file == null) {

                entity.addPart(FILE_PART_NAME, new StringBody(""));
            } else {
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                file.compress(Bitmap.CompressFormat.JPEG, 100, bos);
                byte[] data = bos.toByteArray();
                ByteArrayBody bab = new ByteArrayBody(data, "image/jpeg",
                        "image.png");
                entity.addPart(FILE_PART_NAME, bab);
            }

            //


            for (String key : params.keySet()) {
                entity.addPart(key, new StringBody(params.get(key)));
            }
        } catch (UnsupportedEncodingException e) {
            VolleyLog.e("UnsupportedEncodingException");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getBodyContentType() {
        return entity.getContentType().getValue();
    }

    @Override
    public byte[] getBody() throws AuthFailureError {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            entity.writeTo(bos);
        } catch (IOException e) {
            VolleyLog.e("IOException writing to ByteArrayOutputStream");
        }
        return bos.toByteArray();
    }

    /**
     * copied from Android StringRequest class
     */
    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        String parsed;
        try {
            parsed = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
        } catch (UnsupportedEncodingException e) {
            parsed = new String(response.data);
        }
        return Response.success(parsed, HttpHeaderParser.parseCacheHeaders(response));
    }

    @Override
    protected void deliverResponse(String response) {
        mListener.onResponse(response);
    }


}

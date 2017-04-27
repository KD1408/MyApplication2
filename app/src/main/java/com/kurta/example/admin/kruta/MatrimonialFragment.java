package com.kurta.example.admin.kruta;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.admin.kurta.R;
import com.kurta.example.admin.kruta.Model.DirectoryItem;
import com.kurta.example.admin.kruta.Model.MatrimonyItem;
import com.kurta.example.admin.kruta.Utils.ConnectionDetector;
import com.kurta.example.admin.kruta.adapter.DirectoryAdapter;
import com.kurta.example.admin.kruta.adapter.MatrimonyAdapter;
import com.kurta.example.admin.kruta.listener.RecyclerItemClickListener;
import com.kurta.example.admin.kruta.volly.OnVolleyHandler;
import com.kurta.example.admin.kruta.volly.VolleyIntialization;
import com.kurta.example.admin.kruta.volly.WebService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by admin on 11-Feb-17.
 */
public class MatrimonialFragment extends Fragment{
    private HomeActivity appCompatActivity;

    private Toolbar toolbar;
    private RecyclerView recyclerView;

    AlertDialog.Builder alertDialog;

    ConnectionDetector cd;
    MatrimonyAdapter mAdapter;
    ArrayList<MatrimonyItem> mList;
    ArrayList<MatrimonyItem.RecordsBean> mList2 ;
    MatrimonyItem.RecordsBean bean ;
    String TAG = "Matrimony Fragment ::";

    MatrimonyItem item ;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        appCompatActivity = (HomeActivity) activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_matrimonial, container, false);
       /* int i = getArguments().getInt(ARG_PLANET_NUMBER);
        String planet = getResources().getStringArray(R.array.drawer_item_list)[i];

        int imageId = getResources().getIdentifier(planet.toLowerCase(Locale.getDefault()),
                "drawable", getActivity().getPackageName());
        ((ImageView) rootView.findViewById(R.id.image)).setImageResource(imageId);*/
        getActivity().setTitle("Matrimony");

        cd = new ConnectionDetector(getActivity());

        //
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = appCompatActivity.getWindow();

// clear FLAG_TRANSLUCENT_STATUS flag:
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

// finally change the color
            window.setStatusBarColor(appCompatActivity.getResources().getColor(R.color.bg_statusbar));

        }

        toolbar = (Toolbar) rootView.findViewById(R.id.about_toolbar);

        setupToolbar();

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);


        setupRecyclerView();


        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        // do whatever
                        /*FeedItem feedItem = mFeedAdapter.getItem(position);
                        Intent intent = new Intent(getActivity(), NewsWebViewActivity.class);
                        intent.putExtra("url", feedItem.getLink());
                        intent.putExtra("title", feedItem.getTitle());
                        startActivity(intent);*/


                        MatrimonyItem feedItem = mAdapter.getItem(position);

                        String number= feedItem.getRecords().get(position).getGender();
                        Toast.makeText(getActivity(), "pos >> " + feedItem.getRecords().get(position).getGender(), Toast.LENGTH_SHORT).show();

                        showDialog(number);
                    }
                })
        );


        return rootView;
    }

    private void showDialog(final String number) {


       /* alertDialog = new AlertDialog.Builder(getActivity());

        // Setting Dialog Title
        alertDialog.setTitle("Save File...");

        // Setting Dialog Message
        alertDialog.setMessage("Do you want to save this file?");

        // Setting Icon to Dialog
        alertDialog.setIcon(R.drawable.ic_drawer);

        // Setting Positive "Yes" Button
        alertDialog.setPositiveButton("CALL", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));
                startActivity(intent);
            }
        });

        // Setting Negative "NO" Button
        alertDialog.setNegativeButton("SMS", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                Intent smsIntent = new Intent(android.content.Intent.ACTION_VIEW);
                smsIntent.setType("vnd.android-dir/mms-sms");
                smsIntent.putExtra("address",number);
                smsIntent.putExtra("sms_body","Hello folks");
                startActivity(smsIntent);

            }
        });

        // Setting Netural "Cancel" Button
       *//* alertDialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.cancel();

            }
        });*//*

        // Showing Alert Message
        alertDialog.show();*/

        //kns.p

        new android.support.v7.app.AlertDialog.Builder(getActivity())
                .setTitle(R.string.app_name)
                .setMessage("You want to call or message ?")
                .setPositiveButton("CALL", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));
                        startActivity(intent);

                    }
                })
                .setNegativeButton("SMS", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                        Intent smsIntent = new Intent(android.content.Intent.ACTION_VIEW);
                        smsIntent.setType("vnd.android-dir/mms-sms");
                        smsIntent.putExtra("address",number);
                        smsIntent.putExtra("sms_body","Hello folks");
                        startActivity(smsIntent);
                    }
                })
                .setIcon(R.mipmap.ic_launcher)
                .show();


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        appCompatActivity.setupNavigationDrawer(toolbar);
    }


    private void setupToolbar() {
        toolbar.setTitle("Matrimony Fragment");
        appCompatActivity.setSupportActionBar(toolbar);
    }


    private void setupRecyclerView() {
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(layoutManager);


        initializeCardItemList();
    }

    private void initializeCardItemList() {
        if (cd.isConnectingToInternet()) {
            //api calls
            webGetMatrimony();

        } else {

        }
    }


    private void webGetMatrimony() {


        try {
            VolleyIntialization v = new VolleyIntialization(getActivity(), true, true);

            WebService.GetMatrimony(v, "", "", new OnVolleyHandler() {
                @Override
                public void onVollySuccess(String response) {
                    if (getActivity().isFinishing()) {
                         return;
                    }
                    Log.e("webGetDirectory :: ", response);
                    //getResponseForDirectory(response);
                    //TODO get JSON response and store it
                    //store data in to planet mod
                    mList = new ArrayList<MatrimonyItem>();
                    mList2 = new ArrayList<MatrimonyItem.RecordsBean>();
                    try {
                        JSONObject obj = new JSONObject(response);
                        JSONArray jsonArray = obj.getJSONArray("records");
                        for (int i = 0; i <jsonArray.length() ; i++) {
                            item = new MatrimonyItem();
                            bean = new MatrimonyItem.RecordsBean();
                            // List<PlanetItem.RecordsBean> records ;
                            String gender = jsonArray.getJSONObject(i).getString("gender");
                            String maritalStatus = jsonArray.getJSONObject(i).getString("maritalStatus");
                            String l_name = jsonArray.getJSONObject(i).getString("lname").toLowerCase();
                            String f_name = jsonArray.getJSONObject(i).getString("fname").toUpperCase();

                            Log.e("","Gender >> "+gender);
                            bean.setGender(gender);
                            bean.setMaritalStatus(maritalStatus);
                            bean.setFname(f_name);
                            bean.setLname(l_name);
                            mList2.add(bean);
                            item.setRecords(mList2);
                            mList.add(item);
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                    mAdapter = new MatrimonyAdapter(mList); //pass arrylist of model type in to adapter
                    recyclerView.setAdapter(mAdapter);//set adapter in to recycler view

                }

                @Override
                public void onVollyError(String error) {
                    Log.e("webGetDirectory ::", error);
                    Toast.makeText(getActivity(), "" + error, Toast.LENGTH_LONG).show();
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("JSONException ::", ":: " + e);
        }


    }
}

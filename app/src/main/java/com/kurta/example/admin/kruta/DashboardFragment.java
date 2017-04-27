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
import com.kurta.example.admin.kruta.Model.DashboardItem;
import com.kurta.example.admin.kruta.Model.MatrimonyItem;
import com.kurta.example.admin.kruta.Utils.ConnectionDetector;
import com.kurta.example.admin.kruta.adapter.DashboardAdapter;
import com.kurta.example.admin.kruta.adapter.MatrimonyAdapter;
import com.kurta.example.admin.kruta.listener.RecyclerItemClickListener;
import com.kurta.example.admin.kruta.volly.OnVolleyHandler;
import com.kurta.example.admin.kruta.volly.VolleyIntialization;
import com.kurta.example.admin.kruta.volly.WebService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krutarth on 4/15/2017.
 */

public class DashboardFragment extends Fragment {

    private HomeActivity appCompatActivity;

    private Toolbar toolbar;
    private RecyclerView recyclerView;

    //AlertDialog.Builder alertDialog;

    ConnectionDetector cd;
    DashboardAdapter mAdapter;
    ArrayList<DashboardItem> mList;
    ArrayList<DashboardItem.RecordsBean> mList2 ;
    DashboardItem.RecordsBean bean ;
    String TAG = "Dashboard Fragment ::";

    DashboardItem item ;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        appCompatActivity = (HomeActivity) activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);

        getActivity().setTitle("Dashboard");

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

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_list);


        setupRecyclerView();


        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {


                        DashboardItem feedItem = mAdapter.getItem(position);

                        /*String number= feedItem.getRecords().get(position).getGender();
                        Toast.makeText(getActivity(), "pos >> " + feedItem.getRecords().get(position).getGender(), Toast.LENGTH_SHORT).show();

                        //showDialog(number);*/
                    }
                })
        );


        return rootView;
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        appCompatActivity.setupNavigationDrawer(toolbar);
    }


    private void setupToolbar() {
        toolbar.setTitle("Dashboard Fragment");
        appCompatActivity.setSupportActionBar(toolbar);
    }


    private void setupRecyclerView() {
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(layoutManager);


        initializeCardItemList();
    }

    private void initializeCardItemList() {
        if (cd.isConnectingToInternet()) {
            //api calls
            webGetDashboard();

        } else {

        }
    }


    private void webGetDashboard() {


        try {
            VolleyIntialization v = new VolleyIntialization(getActivity(), true, true);

            WebService.GetDashboard(v, "", "", new OnVolleyHandler() {
                @Override
                public void onVollySuccess(String response) {
                    if (getActivity().isFinishing()) {
                        return;
                    }
                    Log.e("webGetDashboard :: ", response);
                    mList2 = new ArrayList<DashboardItem.RecordsBean>();
                    mList = new ArrayList<DashboardItem>();
                    try {
                        JSONObject obj = new JSONObject(response);
                        JSONArray jsonArray = obj.getJSONArray("records");
                        for (int i = 0; i <jsonArray.length() ; i++) {
                            item = new DashboardItem();
                            bean = new DashboardItem.RecordsBean();


                            String _id = jsonArray.getJSONObject(i).getString("_id");
                            String fname = jsonArray.getJSONObject(i).getString("fname");
                            String lname = jsonArray.getJSONObject(i).getString("lname");
                            String email = jsonArray.getJSONObject(i).getString("email");
                            String pictureUrl = jsonArray.getJSONObject(i).getString("pictureUrl");
                            String action = jsonArray.getJSONObject(i).getString("action");
                            String text = jsonArray.getJSONObject(i).getString("text");
                            bean.set_id(_id);
                            bean.setFname(fname);
                            bean.setLname(lname);
                            bean.setEmail(email);
                            bean.setPictureUrl(pictureUrl);
                            bean.setAction(action);
                            bean.setText(text);

                            mList2.add(bean);
                            item.setRecords(mList2);
                            mList.add(item);
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                    mAdapter = new DashboardAdapter(getActivity(),mList); //pass arrylist of model type in to adapter
                    recyclerView.setAdapter(mAdapter);//set adapter in to recycler view

                }

                @Override
                public void onVollyError(String error) {
                    Log.e("webGetDashboard ::", error);
                    Toast.makeText(getActivity(), "" + error, Toast.LENGTH_LONG).show();
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("JSONException ::", ":: " + e);
        }


    }
}

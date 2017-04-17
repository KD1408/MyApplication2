package com.kurta.example.admin.kruta;

import android.app.Activity;
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
import com.kurta.example.admin.kruta.Utils.ConnectionDetector;
import com.kurta.example.admin.kruta.adapter.DirectoryAdapter;
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
public class DirectoryFragment extends Fragment {
    private HomeActivity appCompatActivity;

    private Toolbar toolbar;
    private RecyclerView recyclerView;

    ConnectionDetector cd;
    DirectoryAdapter mAdapter;
    ArrayList<DirectoryItem> mList;
    ArrayList<DirectoryItem.RecordsBean> mList2 ;
    DirectoryItem.RecordsBean bean ;
    String TAG = "Direfactory Fragment ::";

    DirectoryItem item ;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        appCompatActivity = (HomeActivity) activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_directory, container, false);
       /* int i = getArguments().getInt(ARG_PLANET_NUMBER);
        String planet = getResources().getStringArray(R.array.drawer_item_list)[i];

        int imageId = getResources().getIdentifier(planet.toLowerCase(Locale.getDefault()),
                "drawable", getActivity().getPackageName());
        ((ImageView) rootView.findViewById(R.id.image)).setImageResource(imageId);*/
        getActivity().setTitle("Directory");

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

                        //Toast.makeText(getActivity(), "pos >> " + position, Toast.LENGTH_SHORT).show();

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
        toolbar.setTitle("Directory Fragment");
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
            webGetDirectory();

        } else {

        }
    }


    private void webGetDirectory() {


        try {
            VolleyIntialization v = new VolleyIntialization(getActivity(), true, true);

            WebService.GetDirectory(v, "", "", new OnVolleyHandler() {
                @Override
                public void onVollySuccess(String response) {
                    if (getActivity().isFinishing()) {
                        return;
                    }
                    Log.e("webGetDirectory :: ", response);
                    //getResponseForDirectory(response);
                    //TODO get JSON response and store it
                    //store data in to planet mod
                    mList = new ArrayList<DirectoryItem>();
                    mList2 = new ArrayList<DirectoryItem.RecordsBean>();
                    try {
                        JSONObject obj = new JSONObject(response);
                        JSONArray jsonArray = obj.getJSONArray("records");
                        for (int i = 0; i <jsonArray.length() ; i++) {
                            item = new DirectoryItem();
                            bean = new DirectoryItem.RecordsBean();
                            // List<PlanetItem.RecordsBean> records ;
                            String phone = jsonArray.getJSONObject(i).getString("phone");
                            String email = jsonArray.getJSONObject(i).getString("email");
                            String l_name = jsonArray.getJSONObject(i).getString("lname").toLowerCase();
                            String f_name = jsonArray.getJSONObject(i).getString("fname").toUpperCase();

                            Log.e("","phone >> "+phone);
                            bean.setEmail(email);
                            bean.setPhone(phone);
                            bean.setFname(f_name);
                            bean.setLname(l_name);
                            mList2.add(bean);
                            item.setRecords(mList2);
                            mList.add(item);
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                    mAdapter = new DirectoryAdapter(mList); //pass arrylist of model type in to adapter
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
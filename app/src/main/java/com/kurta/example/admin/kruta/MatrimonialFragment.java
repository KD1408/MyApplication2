package com.kurta.example.admin.kruta;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.example.admin.kurta.R;

/**
 * Created by admin on 11-Feb-17.
 */
public class MatrimonialFragment extends Fragment{
    private HomeActivity appCompatActivity;

    private Toolbar toolbar;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        appCompatActivity = (HomeActivity)activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
       /* int i = getArguments().getInt(ARG_PLANET_NUMBER);
        String planet = getResources().getStringArray(R.array.drawer_item_list)[i];

        int imageId = getResources().getIdentifier(planet.toLowerCase(Locale.getDefault()),
                "drawable", getActivity().getPackageName());
        ((ImageView) rootView.findViewById(R.id.image)).setImageResource(imageId);*/
        //getActivity().setTitle("planet");

        //
        if(Build.VERSION.SDK_INT >=21){
            Window window = appCompatActivity.getWindow();

// clear FLAG_TRANSLUCENT_STATUS flag:
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);


// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

// finally change the color
            window.setStatusBarColor(appCompatActivity.getResources().getColor(R.color.bg_statusbar));

        }

        toolbar = (Toolbar)rootView.findViewById(R.id.about_toolbar);

        setupToolbar();

        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        appCompatActivity.setupNavigationDrawer(toolbar);
    }


    private void setupToolbar(){
        toolbar.setTitle("Matrimonial");
        appCompatActivity.setSupportActionBar(toolbar);
    }

}

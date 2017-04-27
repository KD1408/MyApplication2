package com.kurta.example.admin.kruta;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.admin.kurta.R;

import org.w3c.dom.Text;

/**
 * Created by admin on 11-Feb-17.
 */
public class ProfileFragment extends Fragment{
    private HomeActivity appCompatActivity;


    //{"status":true,"message":"Logged in successfully.",
    // "data":{"id":"58f7fe4f0825946626c0d9b7","userId":6,"fname":"krutarth","lname":"doshi",
    // "email":"krutarthdoshi14@gmail.com","gender":"male","relationShip":"single",
    // "isOnline":false,"isActive":false,"isVerified":false,"communities":[],
    // "dob":"1993-08-14T00:00:00.000Z","addresses":[null],
    // "qualifications":[],"occupations":[],"phones":[{"privacy":"public","type":"Mobile","number":"9197491159"}],"communityId":"57dd00df45b169efde7dbe98","token":"rJxuLCuSCe"}}

    private Toolbar toolbar;
    private TextView tvFname, tvLname, tvPhone, tvEmail, tvRelation, tvGender, tvDOB;
    String email,fname,lname,gender,dob,relation,phone;//status;

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

        //getdata from bundle
        email = getArguments().getString("new_user_email");
        fname = getArguments().getString("f_name");
        lname = getArguments().getString("l_name");
        gender = getArguments().getString("gender");
        relation = getArguments().getString("status");
        //dob = getArguments().getString("edttext");
        //status = getArguments().getString("status");
        dob = getArguments().getString("dob");
        phone = getArguments().getString("phones");
        Log.e("","phone >> "+phone);




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

        tvFname = (TextView) rootView.findViewById(R.id.tv_fname);
        tvLname = (TextView) rootView.findViewById(R.id.tv_lname);
        tvPhone = (TextView) rootView.findViewById(R.id.tv_phone);
        tvEmail = (TextView) rootView.findViewById(R.id.tv_email);
        tvRelation = (TextView) rootView.findViewById(R.id.tv_relation);
        tvGender = (TextView) rootView.findViewById(R.id.tv_gender);
        tvDOB = (TextView) rootView.findViewById(R.id.tv_dob);


        tvFname.setText(fname);
        tvLname.setText(lname);
        tvPhone.setText(phone);
        tvEmail.setText(email);
        tvRelation.setText(relation);
        tvGender.setText(gender);
        tvDOB.setText(dob);


        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        appCompatActivity.setupNavigationDrawer(toolbar);
    }


    private void setupToolbar(){
        toolbar.setTitle("Profile");
        appCompatActivity.setSupportActionBar(toolbar);
    }

}

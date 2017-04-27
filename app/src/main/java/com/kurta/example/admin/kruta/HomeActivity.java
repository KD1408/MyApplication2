package com.kurta.example.admin.kruta;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.kurta.R;

/**
 * Created by admin on 11-Feb-17.
 */
public class HomeActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    //For UserName and UserEmail from previous activity
    String new_user_name, new_user_email ,f_name,l_name,gender,dob,status,phones;

    //navigation header textview
    TextView header_user_name, header_user_email;

    //TAGS
    private final static String DASHBOARD_TAG = "dashboard";
    private final static String PROFILE_TAG = "profile";
    private final static String DIRECTORY_TAG = "directory";
    private final static String MATRIMONIAL_TAG = "matrimonial";
    private final static String JOB_TAG = "job";

    //IDS
    private final static int ID_DASHBOARD = 0;
    private final static int ID_PROFILE = 1;
    private final static int ID_DIRECTORY = 2;
    private final static int ID_MATRIMONIAL = 3;
    private final static int ID_JOB = 4;
    private final static int ID_LOGOUT = 5;

    //Navigation
    private static int selectedIndex;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private final static String SELECTED_TAG = "selected_index";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);


        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (savedInstanceState != null) {
            navigationView.getMenu().getItem(savedInstanceState.getInt(SELECTED_TAG)).setChecked(true);
            return;
        }

        header_user_email = (TextView) header.findViewById(R.id.user_email);
        header_user_name = (TextView) header.findViewById(R.id.user_name);

        if(savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if(extras == null){
                new_user_email = null;
                new_user_name = null;

            }else{
                new_user_email = extras.getString("UserEmail");
                new_user_name = extras.getString("UserName");

                header_user_name.setText(new_user_name);
                header_user_email.setText(new_user_email);


                //@kns.p -------------------------------------------------------
                f_name = extras.getString("fname");
                l_name = extras.getString("lname");
                gender = extras.getString("gender");
                status = extras.getString("relationShip");
                dob = extras.getString("dob");
                phones = extras.getString("phone");
                //------------------------------------------------------------
            }
        }

        //default fragment with dashbord fragment
        selectedIndex = ID_DASHBOARD;
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,
                new DashboardFragment(), DASHBOARD_TAG).commit();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SELECTED_TAG, selectedIndex);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        switch(menuItem.getItemId()){

            case R.id.item_dashboard:
                if(!menuItem.isChecked()){
                    selectedIndex = ID_DASHBOARD;
                    menuItem.setChecked(true);
                    getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,
                            new DashboardFragment(), DASHBOARD_TAG).commit();
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;

            case R.id.item_profile:
                if(!menuItem.isChecked()){
                    selectedIndex = ID_PROFILE;
                    menuItem.setChecked(true);

                    //@kns.p------------
                    Bundle bundle = new Bundle();
                    bundle.putString("new_user_email",new_user_email);
                    bundle.putString("f_name",f_name);
                    bundle.putString("l_name", l_name);
                    bundle.putString("gender", gender);
                    //bundle.putString("dob", gender);
                    bundle.putString("status", status);
                    bundle.putString("dob", dob);
                    bundle.putString("phones",phones);


// set Fragmentclass Arguments
                    ProfileFragment fragobj = new ProfileFragment();
                    fragobj.setArguments(bundle);
                    //---------------------------------

                    getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,
                            fragobj, PROFILE_TAG).commit();
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;

            case R.id.item_directory:
                if(!menuItem.isChecked()){
                    selectedIndex = ID_DIRECTORY;
                    menuItem.setChecked(true);
                   //open home fragment
                    getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,
                            new DirectoryFragment(), DIRECTORY_TAG).commit();
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;



            case R.id.item_matrimonial:
                if(!menuItem.isChecked()){
                    selectedIndex = ID_MATRIMONIAL;
                    menuItem.setChecked(true);
                   //open matrimonial fragment
                    getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,
                            new MatrimonialFragment(), MATRIMONIAL_TAG).commit();

                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;

            /* case R.id.item_job:
                if(!menuItem.isChecked()){
                    selectedIndex = ID_JOB;
                    menuItem.setChecked(true);
                    //open job fragment
                    getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,
                            new JobFragment(), JOB_TAG).commit();

                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true; */

            case R.id.item_logout:
                if(!menuItem.isChecked()){
                    selectedIndex = ID_LOGOUT;
                    menuItem.setChecked(true);

                    showLogoutDialog();
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;

        }
        return false;
    }


    //handle navigation drawer click
    public void setupNavigationDrawer(Toolbar toolbar){
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                R.string.open_drawer,R.string.close_drawer){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            showAlert();
        }
    }

    public void showAlert() {
        new AlertDialog.Builder(HomeActivity.this)
                .setTitle(R.string.app_name)
                .setMessage("Are you sure you want to exit ?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        Intent startMain = new Intent(Intent.ACTION_MAIN);
                        startMain.addCategory(Intent.CATEGORY_HOME);
                        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(startMain);
                        finish();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                        try {
                            dialog.dismiss();
                        } catch (Exception e) {
                            Log.e("===>", e.getMessage());
                        }
                        //dialog.dismiss();
                    }
                })
                .setIcon(R.mipmap.ic_launcher)
                .show();
    }

    public void showLogoutDialog() {
        new AlertDialog.Builder(HomeActivity.this)
                .setTitle(R.string.app_name)
                .setMessage("Are you sure you want to Logout ?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        Intent startMain = new Intent(HomeActivity.this, MainActivity.class);
                        startActivity(startMain);
                        finish();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                        try {
                            dialog.dismiss();
                        } catch (Exception e) {
                            Log.e("===>", e.getMessage());
                        }
                        //dialog.dismiss();
                    }
                })
                .setIcon(R.mipmap.ic_launcher)
                .show();


    }


}

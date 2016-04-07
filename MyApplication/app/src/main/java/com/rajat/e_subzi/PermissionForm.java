package com.rajat.e_subzi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.rajat.e_subzi.Objects.ShopObject;
import com.rajat.e_subzi.Volley.VolleyClick;

import java.util.ArrayList;
import java.util.List;


public class PermissionForm extends ActionBarActivity implements AdapterView.OnItemSelectedListener{
                                     // Declaring DrawerLayout
    ListView mRecyclerView;

    DrawerLayout Drawer;                                  // Declaring DrawerLayout

    ActionBarDrawerToggle mDrawerToggle;                  // Declaring Action Bar Drawer Toggle


    public static ArrayList<String> app_shops_id=new ArrayList<String>();
    public static ArrayList<String> n_app_shops_id=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission_form);
        ArrayList<ShopObject> test=new ArrayList<ShopObject>();
        ShopObject d=new ShopObject("1","safal");
        test.add(d);
        test.add(d);
        test.add(d);


        ListView listView=(ListView) findViewById(R.id.shopkeeper_list);
        PermissionsAdapter adapter=new PermissionsAdapter(test,this);
        listView.setAdapter(adapter);
//        mRecyclerView = (RecyclerView) findViewById(R.id.shop_list);
//        mRecyclerView.setHasFixedSize(true);
//        mLayoutManager = new LinearLayoutManager(this);
//        mRecyclerView.setLayoutManager(mLayoutManager);
//        mAdapter = new PermissionsAdapter(test);
//        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView = (ListView) findViewById(R.id.permission_nav); // Assigning the RecyclerView Object to the xml View
        mRecyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SharedPreferences pref = getSharedPreferences("MyPrefs", MODE_PRIVATE);

                Log.d("sheck",pref.getString("type",""));
                Log.d("check",""+position);
                if(position==1){
                    if (pref.getString("type","").equals("Shopkeeper")) {
                        VolleyClick.findProductsClick(pref.getString("userId", ""), PermissionForm.this);
                    } else {
                        VolleyClick.findDiscountsClick(pref.getString("userId",""), PermissionForm.this);
                    }
                }
                else if(position==2){
                    VolleyClick.findOrdersClick(pref.getString("userId",""), pref.getString("type",""), PermissionForm.this);
                }
                else if(position==3){
                    if (pref.getString("type", "").equals("Shopkeeper")) {
                        PermissionForm.this.getSharedPreferences("MyPrefs", 0).edit().clear().commit();
                        Intent intent = new Intent(PermissionForm.this, Login.class);
                        PermissionForm.this.startActivity(intent);
                    } else {
                        VolleyClick.findPreferencesClick(pref.getString("userId",""), PermissionForm.this);
                    }
                }
                else if(position==4){
                    PermissionForm.this.getSharedPreferences("MyPrefs", 0).edit().clear().commit();
                    Intent intent = new Intent(PermissionForm.this, Login.class);
                    PermissionForm.this.startActivity(intent);
                }
            }
        });
        SharedPreferences pref = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        ArrayList<String> list=new ArrayList<String >();
        list.add("Discounts/Products");
        list.add("Order");
        if(pref.getString("type","").equals("Shopkeeper")){
            list.add("Log Out");
        }
        else{
            list.add("Preferences");
            list.add("Log Out");
        }

        NavListAdapter mAdapter = new NavListAdapter(this,list,pref.getString("userId",""),pref.getString("type",""));       // Creating the Adapter of MyAdapter class(which we are going to see in a bit)
        // And passing the titles,icons,header view name, header view email,
        // and header view profile picture
        View a= getLayoutInflater().inflate(R.layout.header,null,false);

        mRecyclerView.addHeaderView(a);
        mRecyclerView.setAdapter(mAdapter);                              // Setting the adapter to RecyclerView

//        mLayoutManager = new LinearLayoutManager(this);                 // Creating a layout Manager
//
//        mRecyclerView.setLayoutManager(mLayoutManager);                 // Setting the layout Manager


        Drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);        // Drawer object Assigned to the view
        mDrawerToggle = new ActionBarDrawerToggle(this,Drawer,R.string.openDrawer,R.string.closeDrawer){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                // code here will execute once the drawer is opened( As I dont want anything happened whe drawer is
                // open I am not going to put anything here)
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
                // Code here will execute once drawer is closed
            }



        }; // Drawer Toggle Object Made
        Drawer.setDrawerListener(mDrawerToggle); // Drawer Listener set to the Drawer toggle
//        Drawer.setOnItemClickListener()
        mDrawerToggle.syncState();               // Finally we set the drawer toggle sync State
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_permission_form, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void send(View view){
        Log.d("size",""+app_shops_id.size());
        Log.d("size", "" + n_app_shops_id.size());
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position,
                               long id) {
        int a=2;
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }
}

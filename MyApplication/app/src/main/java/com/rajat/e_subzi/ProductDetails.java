package com.rajat.e_subzi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.rajat.e_subzi.Objects.ProductObject;
import com.rajat.e_subzi.Volley.VolleyClick;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;


public class ProductDetails extends ActionBarActivity {
    ProductObject product;
    ListView mRecyclerView;
    DrawerLayout Drawer;                                  // Declaring DrawerLayout

    ActionBarDrawerToggle mDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        Intent intent=getIntent();
        product=(ProductObject) new Gson().fromJson((String) intent.getStringExtra("data"), ProductObject.class);
        EditText edittext=(EditText)findViewById(R.id.p_desc);
        edittext.setText(product.getDescription());
        edittext=(EditText)findViewById(R.id.p_discount);
        edittext.setText(Integer.toString(product.getDiscount()));

        edittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                EditText editText = (EditText) findViewById(R.id.p_discount);
                String discount = editText.getText().toString();
                editText = (EditText) findViewById(R.id.p_discount);
                discount = editText.getText().toString();

                try{
                    int we=Integer.parseInt(discount);
                    VolleyClick.changeDiscountClick(product.getProductId(), Integer.parseInt(discount), ProductDetails.this);
                }
                catch (Exception e){
                    Toast.makeText(ProductDetails.this, "Please enter valid price",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
        edittext=(EditText)findViewById(R.id.p_price);
        edittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                EditText editText=(EditText)findViewById(R.id.p_price);
                try{
                    int we=Integer.parseInt(editText.getText().toString());
                    VolleyClick.updatePriceClick(product.getProductId(), Integer.parseInt(editText.getText().toString()),ProductDetails.this);
                }
                catch (Exception e){
                    Toast.makeText(ProductDetails.this, "Please enter valid price",
                            Toast.LENGTH_LONG).show();
                }

            }
        });
        edittext.setText(Integer.toString(product.getPrice()));
        edittext=(EditText)findViewById(R.id.p_quantity);
        edittext.setText(Integer.toString(product.getQuantity()));
        mRecyclerView = (ListView) findViewById(R.id.product_details_nav); // Assigning the RecyclerView Object to the xml View
        mRecyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SharedPreferences pref = getSharedPreferences("MyPrefs", MODE_PRIVATE);

                Log.d("sheck", pref.getString("type", ""));
                Log.d("check",""+position);
                if(position==1){
                    if (pref.getString("type","").equals("Shopkeeper")) {
                        VolleyClick.findProductsClick(pref.getString("userId", ""), ProductDetails.this);
                    } else {
                        VolleyClick.findDiscountsClick(pref.getString("userId",""), ProductDetails.this);
                    }
                }
                else if(position==2){
                    VolleyClick.findOrdersClick(pref.getString("userId",""), pref.getString("type",""), ProductDetails.this);
                }
                else if(position==3){
                    if (pref.getString("type", "").equals("Shopkeeper")) {
                        ProductDetails.this.getSharedPreferences("MyPrefs", 0).edit().clear().commit();
                        Intent intent = new Intent(ProductDetails.this, Login.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        ProductDetails.this.startActivity(intent);
                    } else {
                        VolleyClick.findPreferencesClick(pref.getString("userId",""), ProductDetails.this);
                    }
                }
                else if(position==4){
                    ProductDetails.this.getSharedPreferences("MyPrefs", 0).edit().clear().commit();
                    Intent intent = new Intent(ProductDetails.this, Login.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    ProductDetails.this.startActivity(intent);
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
        getMenuInflater().inflate(R.menu.menu_product_details, menu);
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

        return super.onOptionsItemSelected(item);
    }
    public void done(View view){
        this.finish();
        VolleyClick.findProductsClick(getSharedPreferences("MyPrefs",MODE_PRIVATE).getString("userId",""), this);
    }
}

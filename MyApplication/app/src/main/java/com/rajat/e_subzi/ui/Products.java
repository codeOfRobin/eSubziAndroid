package com.rajat.e_subzi.ui;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.rajat.e_subzi.Objects.ProductObject;
import com.rajat.e_subzi.Volley.VolleyClick;
import com.rajat.e_subzi.R;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class Products extends ActionBarActivity {
    GridView gridView;
    ProductsGridAdapter productsGridAdapter;
    int count;
    ListView mRecyclerView;

    DrawerLayout Drawer;                                  // Declaring DrawerLayout

    ActionBarDrawerToggle mDrawerToggle;                  // Declaring Action Bar Drawer Toggle

    JSONArray products;
    JSONObject product;
    String created_at = "";
    String updated_at = "";
    String userId = "";
    int discount = 0;
    String description = "";
    int quantity = 0;
    int price = 0;
    String productId = "";
    String message = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);


//        Intent intent=getIntent();
//        String result=(String) intent.getStringExtra("data");
        final ArrayList<ProductObject> productObjList = new ArrayList<ProductObject>();
//        try {
//            JSONObject resultJson = new JSONObject(result);
//            if (resultJson.has("products")) {
//                products = resultJson.getJSONArray("products");
//                for (int i = 0; i < products.length(); i++) {
//                    product = products.getJSONObject(i);
//                    discount = product.getInt("discount");
//                    quantity = product.getInt("quantity");
//                    if (product.has("price")) {
//                        price = product.getInt("price");
//                    }
//                    userId = product.getString("userId");
//                    description = product.getString("description");
//                    productId = product.getString("_id");
//                    created_at = product.getString("created_at");
//                    updated_at = product.getString("updated_at");
//                    productObjList.add(new ProductObject(created_at, updated_at, userId, discount, description, quantity, price, productId));
//                }
//            }
//        }
//        catch(JSONException e){
//
//        }
        gridView=(GridView) findViewById(R.id.product_grid);

        productsGridAdapter=new ProductsGridAdapter(this,count,productObjList);
        gridView.setAdapter(productsGridAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //you code for netwirking here
//                Intent intent=new Intent(Products.this,ProductDetails.class);
//                intent.putExtra("desc",productObjList.get(position).getDescription());
//                intent.putExtra("discount",productObjList.get(position).getDiscount());
//                intent.putExtra("price",productObjList.get(position).getPrice());
//                intent.putExtra("quantity",productObjList.get(position).getQuantity());
//                intent.putExtra("product_id",productObjList.get(position).getProductId());
//                startActivity(intent);
            }
        });

        mRecyclerView = (ListView) findViewById(R.id.products_nav); // Assigning the RecyclerView Object to the xml View


        String[] list={"Discounts","Products","Order"};
        NavListAdapter mAdapter = new NavListAdapter(this,list);       // Creating the Adapter of MyAdapter class(which we are going to see in a bit)
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
        getMenuInflater().inflate(R.menu.menu_products, menu);
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
}

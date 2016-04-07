package com.rajat.e_subzi;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rajat.e_subzi.Objects.ProductObject;
import com.rajat.e_subzi.Volley.VolleyClick;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;


public class ProductDetails extends ActionBarActivity {
    ProductObject product;
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

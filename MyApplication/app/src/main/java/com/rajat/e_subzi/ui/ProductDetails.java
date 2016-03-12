package com.rajat.e_subzi.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import com.rajat.e_subzi.Volley.VolleyClick;
import com.rajat.e_subzi.R;


public class ProductDetails extends ActionBarActivity {
    String desc="";
    String price="";
    String discount="";
    String quantity="";
    String p_id="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        Intent intent=getIntent();
        desc=intent.getStringExtra("desc");
        price=intent.getStringExtra("price");
        discount=intent.getStringExtra("discount");
        quantity=intent.getStringExtra("quantiy");
        p_id=intent.getStringExtra("p_id");
        EditText edittext=(EditText)findViewById(R.id.p_desc);
        edittext.setText(desc);
        edittext=(EditText)findViewById(R.id.p_discount);
        edittext.setText(discount);
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
                editText = (EditText) findViewById(R.id.p_id);
                discount = editText.getText().toString();
                VolleyClick.changeDiscountClick(p_id, Integer.parseInt(discount),ProductDetails.this);
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
                price=editText.getText().toString();
                VolleyClick.updatePriceClick(p_id, Integer.parseInt(price),ProductDetails.this);
            }
        });
        edittext.setText(price);
        edittext=(EditText)findViewById(R.id.p_quantity);
        edittext.setText(quantity);


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
}

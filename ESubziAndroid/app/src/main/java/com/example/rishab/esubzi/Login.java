package com.example.rishab.esubzi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.rishab.esubzi.Volley.VolleyClick;


public class Login extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        getSupportActionBar().hide();
        SharedPreferences pref = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String tokens=pref.getString("token","no tokens");
        if(!tokens.equals("no tokens")){
            if(pref.getString("type","").equals("Shopkeeper")){
                VolleyClick.findProductsClick(pref.getString("userId",""),this);
            }
            else{
                VolleyClick.findDiscountsClick(pref.getString("userId",""),this);
            }
        }
//        getActionBar().hide();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
    public void login(View view){
        TextView user=(TextView) findViewById(R.id.username);
        TextView pass=(TextView) findViewById(R.id.password);
        VolleyClick.loginClick(user.getText().toString(), pass.getText().toString(),this);
    }
    public void signup(View view){
        Intent intent=new Intent(this,SignUp.class);
        startActivity(intent);
    }
}

package com.rajat.e_subzi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.rajat.e_subzi.Objects.ProductObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Rishab on 02-04-2016.
 */
public class AddOrderAdapter extends BaseAdapter {
    ArrayList<ProductObject> discounts=new ArrayList<ProductObject>();
    Context context;

    public AddOrderAdapter(ArrayList<ProductObject> discounts,Context context){
        super();
        this.discounts=discounts;

        this.context=context;
    }

    public int getCount() {
        // TODO Auto-generated method stub
        return discounts.size();
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }
    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View row = inflater.inflate(R.layout.place_order_listview, null, true);
        TextView data = (TextView) row.findViewById(R.id.commodity);
        data.setText(discounts.get(position).getDescription());
        data=(TextView)row.findViewById(R.id.price);
        AddOrder.data_quantity.put(discounts.get(position).getProductId(),(float) discounts.get(position).getQuantity());
        data.setText("Price : "+Integer.toString(discounts.get(position).getPrice()));
        data=(TextView)row.findViewById(R.id.discount);
        data.setText("Discount : " + Integer.toString(discounts.get(position).getDiscount()));

        Button button=(Button) row.findViewById(R.id.dec);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView t=(TextView) row.findViewById(R.id.amt);
                if(Float.parseFloat((String) t.getText())>(float)0.0){
                    t.setText(Float.toString(Float.parseFloat((String) t.getText())-(float)0.5));
                    AddOrder.data.put(discounts.get(position).getProductId(),Float.parseFloat((String) t.getText()));


                }

            }
        });
        button=(Button) row.findViewById(R.id.inc);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView t=(TextView) row.findViewById(R.id.amt);
                if (AddOrder.data_quantity.get(discounts.get(position).getProductId()) >= Float.parseFloat((String) t.getText())+(float)0.5){
                    t.setText(Float.toString(Float.parseFloat((String) t.getText())+(float)0.5));
                    AddOrder.data.put(discounts.get(position).getProductId(), Float.parseFloat((String) t.getText()));
                }
                else{
                    Toast.makeText(context,"quantityt limit exceede",Toast.LENGTH_LONG).show();
                }
            }
        });
        return row;
    }
}

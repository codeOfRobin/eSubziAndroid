package com.rajat.e_subzi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.rajat.e_subzi.Objects.ProductObject;

import java.util.ArrayList;

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
        data.setText("Price : "+Integer.toString(discounts.get(position).getPrice()));
        data=(TextView)row.findViewById(R.id.discount);
        data.setText("Discount : "+Integer.toString(discounts.get(position).getDiscount()));

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
                t.setText(Float.toString(Float.parseFloat((String) t.getText())+(float)0.5));
                AddOrder.data.put(discounts.get(position).getProductId(), Float.parseFloat((String) t.getText()));
            }
        });
        return row;
    }
}

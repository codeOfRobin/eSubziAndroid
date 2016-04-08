package com.rajat.e_subzi;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.rajat.e_subzi.Objects.OrderObject;
import com.rajat.e_subzi.Volley.VolleyClick;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Rishab on 03-03-2016.
 */
public class OrderListAdapter extends BaseAdapter{
    String[] headings;
    String[] desc;
    Context context;
    String[] colors={"#A53ABD","#234E33"};
    String[] dropdown={"OrderReceived", "OrderBeingProcessed", "Delivering", "Delivered"};
    HashMap<String ,Integer> mapping=new HashMap<String ,Integer >();
    ArrayList<OrderObject> orderObjects;
    public OrderListAdapter(ArrayList<OrderObject> orderObjects,Context context){
        super();
        this.orderObjects=orderObjects;
        this.context=context;
        mapping.put("OrderBeingProcessed",R.id.four);
        mapping.put("OrderReceived",R.id.three);
        mapping.put("Delivered",R.id.two);
        mapping.put("Delivering",R.id.one);

    }

    public int getCount() {
        // TODO Auto-generated method stub
        return orderObjects.size();
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }
    public View getView(final int position, final View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.order_list_view, null, true);

        row.setBackgroundColor(Color.parseColor(colors[position%2]));
//        TextView data = (TextView) row.findViewById(R.id.head);
//        data.setText(headings[position]);
//        data=(TextView)row.findViewById(R.id.descs);
//        data.setText(desc[position]);
        TextView textView=(TextView) row.findViewById(R.id.head);
        textView.setText(orderObjects.get(position).getCustomerId());
        textView=(TextView) row.findViewById(R.id.order_ste);
        if(context.getSharedPreferences("MyPrefs",context.MODE_PRIVATE).getString("type","").equals("Shopkeeper")){
            textView.setVisibility(View.GONE);
            TextView t=(TextView)row.findViewById(mapping.get(orderObjects.get(position).getCurrentState()));
            t.setTextColor(Color.parseColor("#76ff03"));
            t=(TextView)row.findViewById(R.id.one);
            t.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView p=(TextView) v;
                    p.setTextColor(Color.parseColor("#76ff03"));
                    VolleyClick.changeOrderStateClick(orderObjects.get(position).getOrderId().toString(), p.getText().toString(), context);
                }
            });

            t=(TextView)row.findViewById(R.id.two);
            t.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView p=(TextView) v;
                    p.setTextColor(Color.parseColor("#76ff03"));
                    VolleyClick.changeOrderStateClick(orderObjects.get(position).getOrderId().toString(), p.getText().toString(),context);
                }
            });
            t=(TextView)row.findViewById(R.id.three);
            t.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView p=(TextView) v;
                    p.setTextColor(Color.parseColor("#76ff03"));
                    VolleyClick.changeOrderStateClick(orderObjects.get(position).getOrderId().toString(), p.getText().toString(),context);
                }
            });
            t=(TextView)row.findViewById(R.id.four);
            t.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView p=(TextView) v;
                    p.setTextColor(Color.parseColor("#76ff03"));
                    VolleyClick.changeOrderStateClick(orderObjects.get(position).getOrderId().toString(), p.getText().toString(),context);
                }
            });
        }
        else {
            LinearLayout layout=(LinearLayout) row.findViewById(R.id.change_order_state1);
            layout.setVisibility(View.GONE);
            layout=(LinearLayout) row.findViewById(R.id.change_order_state2);
            layout.setVisibility(View.GONE);
            textView.setText(orderObjects.get(position).getCurrentState());
        }
        return row;
    }
}

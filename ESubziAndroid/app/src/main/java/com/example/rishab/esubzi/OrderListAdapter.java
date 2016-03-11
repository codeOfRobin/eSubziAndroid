package com.example.rishab.esubzi;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Rishab on 03-03-2016.
 */
public class OrderListAdapter extends BaseAdapter{
    String[] headings;
    String[] desc;
    Context context;
    String[] colors={"#A53ABD","#234E33"};
    public OrderListAdapter(String[] headings,String[] desc,Context context){
        super();
        this.desc=desc;
        this.headings=headings;
        this.context=context;
    }

    public int getCount() {
        // TODO Auto-generated method stub
        return headings.length;
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.order_list_view, null, true);

        row.setBackgroundColor(Color.parseColor(colors[position%2]));
        TextView data = (TextView) row.findViewById(R.id.head);
        data.setText(headings[position]);
        data=(TextView)row.findViewById(R.id.descs);
        data.setText(desc[position]);
        return row;
    }
}

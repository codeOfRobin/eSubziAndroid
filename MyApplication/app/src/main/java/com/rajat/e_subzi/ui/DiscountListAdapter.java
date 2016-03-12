package com.rajat.e_subzi.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.rajat.e_subzi.Volley.VolleyClick;
import com.rajat.e_subzi.R;
/**
 * Created by Rishab on 02-03-2016.
 */
public class DiscountListAdapter extends BaseAdapter {
    String[] items;
    String[] discounts;
    Context context;
    public DiscountListAdapter(String[] items,String[] discounts,Context context){
        super();
        this.discounts=discounts;
        this.items=items;
        this.context=context;
    }

    public int getCount() {
        // TODO Auto-generated method stub
        return items.length;
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
        View row = inflater.inflate(R.layout.discount_list_view, null, true);
        TextView data = (TextView) row.findViewById(R.id.commodity);
        data.setText(items[position]);
        data=(TextView)row.findViewById(R.id.discount);
        data.setText(discounts[position]);
        return row;
    }
}

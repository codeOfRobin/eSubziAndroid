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
 * Created by Rishab on 04-03-2016.
 */
public class NavListAdapter extends BaseAdapter{
    Context context;
    String[] list;
    public NavListAdapter(Context context, String[] list){
        this.context=context;
        this.list=list;
    }
    public int getCount() {
        // TODO Auto-generated method stub
        return list.length;
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
        View row = inflater.inflate(R.layout.nav_list, null, true);


        TextView data = (TextView) row.findViewById(R.id.nav_list_item);
        data.setText(list[position]);

        return row;
    }
}

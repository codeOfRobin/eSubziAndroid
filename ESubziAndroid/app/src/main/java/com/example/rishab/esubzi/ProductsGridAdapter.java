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
public class ProductsGridAdapter extends BaseAdapter {
     Context context;

    public ProductsGridAdapter(Context context,int count){
        super();

        this.context=context;
    }

    public int getCount() {
        // TODO Auto-generated method stub
        return 5;
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
        View row = inflater.inflate(R.layout.products_grid_view, null, true);

        return row;
    }
}

package com.rajat.e_subzi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rajat.e_subzi.Objects.ProductObject;
import com.rajat.e_subzi.Volley.CallVolley;

import java.util.ArrayList;

/**
 * Created by Rishab on 02-03-2016.
 */
public class DiscountListAdapter extends BaseAdapter {

    ArrayList<ProductObject> discounts=new ArrayList<ProductObject>();
    ArrayList<String>photoUrls=new ArrayList<String>();
    Context context;
    public DiscountListAdapter(ArrayList<ProductObject> discounts,ArrayList<String> photoUrls,Context context){
        super();
        this.photoUrls=photoUrls;
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
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.discount_list_view, null, true);
        ImageView iv = (ImageView) row.findViewById(R.id.disc_image);
        CallVolley.getBitmapFromUrlBack(photoUrls.get(position),context,iv);
        TextView data = (TextView) row.findViewById(R.id.commodity);
        data.setText(discounts.get(position).getDescription());
        data=(TextView)row.findViewById(R.id.price);
        data.setText("Price : "+Integer.toString(discounts.get(position).getPrice()));
        data=(TextView)row.findViewById(R.id.discount);
        data.setText("Discount : " + Integer.toString(discounts.get(position).getDiscount()));

        return row;
    }
}

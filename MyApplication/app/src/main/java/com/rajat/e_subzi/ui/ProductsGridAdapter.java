package com.rajat.e_subzi.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rajat.e_subzi.Objects.ProductObject;
import com.rajat.e_subzi.Volley.VolleyClick;
import com.rajat.e_subzi.R;

import java.util.ArrayList;

/**
 * Created by Rishab on 03-03-2016.
 */
public class ProductsGridAdapter extends BaseAdapter {
     Context context;
    ArrayList<ProductObject> productObjList = new ArrayList<ProductObject>();
    public ProductsGridAdapter(Context context,int count,ArrayList<ProductObject> productObjList){
        super();

        this.productObjList=productObjList;
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
        ImageView imageView=(ImageView)row.findViewById(R.id.product_image);
//        imageView.setImageResource(product_image.get(position));
        TextView textView=(TextView)row.findViewById(R.id.product_text);
//        textView.setText(productObjList.get(position).getDescription());
        return row;
    }
}

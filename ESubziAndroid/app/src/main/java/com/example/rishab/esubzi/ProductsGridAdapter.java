package com.example.rishab.esubzi;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rishab.esubzi.Objects.ProductObject;
import com.google.gson.Gson;

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
        return productObjList.size();
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
        View row = inflater.inflate(R.layout.products_grid_view, null, true);
        ImageView imageView=(ImageView)row.findViewById(R.id.product_image);
//        imageView.setImageResource(product_image.get(position));
        TextView textView=(TextView)row.findViewById(R.id.product_text);
        textView.setText(productObjList.get(position).getDescription());
        ImageButton button=(ImageButton) row.findViewById(R.id.edit_product);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,ProductDetails.class);
                intent.putExtra("data",new Gson().toJson(productObjList.get(position)));
                context.startActivity(intent);
            }
        });
        return row;
    }
}

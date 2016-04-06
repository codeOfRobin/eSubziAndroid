package com.example.rishab.esubzi;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.rishab.esubzi.Objects.ShopObject;
import com.example.rishab.esubzi.Objects.ShopObject;

import java.util.ArrayList;

/**
 * Created by Rishab on 04-04-2016.
// */
//public class PermissionsAdapter extends RecyclerView
//        .Adapter<PermissionsAdapter
//        .ShopObjectHolder> {
//
//    private ArrayList<ShopObject> shops;
//    private static MyClickListener myClickListener;
//
//    public static class ShopObjectHolder extends RecyclerView.ViewHolder
//            implements View
//            .OnClickListener {
//
//        TextView shop;
//
//        public ShopObjectHolder(final View itemView) {
//            super(itemView);
//
//            shop = (TextView) itemView.findViewById(R.id.shop);
//            itemView.setOnClickListener(this);
//
//
//        }
//
//        @Override
//        public void onClick(View v) {
//            myClickListener.onItemClick(getAdapterPosition(), v);
//        }
//    }
//
//    public void setOnItemClickListener(MyClickListener myClickListener) {
//        this.myClickListener = myClickListener;
//    }
//
//    public PermissionsAdapter(ArrayList<ShopObject> myDataset) {
//        shops = myDataset;
//    }
//
//    @Override
//    public ShopObjectHolder onCreateViewHolder(ViewGroup parent,
//                                               int viewType) {
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.permissions_cardview_view, parent, false);
//
//        ShopObjectHolder dataObjectHolder = new ShopObjectHolder(view);
//        return dataObjectHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(ShopObjectHolder holder, int position) {
//        holder.shop.setText(shops.get(position).getShopName());
//        final CheckBox checkBox = (CheckBox) itemView.findViewById(R.id.check_shop);
//        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (checkBox.isChecked()) {
//                    PermissionForm.app_shops_id.add(itemView.)
//                }
//
//            }
//        });
//    }
//
//    public void addItem(ShopObject dataObj, int index) {
//        shops.add(index, dataObj);
//        notifyItemInserted(index);
//    }
//
//    public void deleteItem(int index) {
//        shops.remove(index);
//        notifyItemRemoved(index);
//    }
//
//    @Override
//    public int getItemCount() {
//        return shops.size();
//    }
//
//    public interface MyClickListener {
//        public void onItemClick(int position, View v);
//    }
//}

public class PermissionsAdapter extends BaseAdapter {

    ArrayList<ShopObject> shops=new ArrayList<ShopObject>();
    Context context;
    public PermissionsAdapter(ArrayList<ShopObject> shops,Context context){
        super();
        this.shops=shops;

        this.context=context;
    }

    public int getCount() {
        // TODO Auto-generated method stub
        return shops.size();
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
        View row = inflater.inflate(R.layout.permissions_cardview_view, null, true);
        TextView data = (TextView) row.findViewById(R.id.shop);

        data.setText(shops.get(position).getShopName());
        CheckBox checkBox=(CheckBox) row.findViewById(R.id.check_shop);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){

                    PermissionForm.app_shops_id.add(shops.get(position).getShopId());
                }
                else {
                    PermissionForm.app_shops_id.remove(PermissionForm.app_shops_id.indexOf(shops.get(position).getShopId()));
                }

            }
        });
        return row;
    }
}

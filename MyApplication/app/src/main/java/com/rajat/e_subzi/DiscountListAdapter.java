package com.rajat.e_subzi;

import android.content.Context;
import android.support.v7.app.AlertDialog;
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
        final ImageView iv = (ImageView) row.findViewById(R.id.disc_image);
        CallVolley.getBitmapFromUrlBack(photoUrls.get(position), context, iv);
        TextView data = (TextView) row.findViewById(R.id.commodity);
        data.setText(discounts.get(position).getDescription());
        final String commodity =data.getText().toString();
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadPhoto(iv,commodity,400,400);
            }
        });
        data=(TextView)row.findViewById(R.id.price);
        data.setText("Price : "+Integer.toString(discounts.get(position).getPrice()));
        data=(TextView)row.findViewById(R.id.discount);
        data.setText("Discount : " + Integer.toString(discounts.get(position).getDiscount()));

        return row;
    }
    private void loadPhoto(ImageView iv,String name, int width, int height) {

        //ImageView tempImageView = imageView;


        AlertDialog.Builder imageDialog = new AlertDialog.Builder(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View layout = inflater.inflate(R.layout.custom_fullimage_dialog,
                (ViewGroup) Discounts.lay);
        ImageView image = (ImageView) layout.findViewById(R.id.fullimage);
        TextView text = (TextView)layout.findViewById(R.id.custom_fullimage_placename);
        text.setText(name);
        image.setImageDrawable(iv.getBackground());
        imageDialog.setView(layout);

		/*imageDialog.setPositiveButton("Back", new DialogInterface.OnClickListener() {

			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}

		});
*/

        imageDialog.create();
        imageDialog.show();
    }
}

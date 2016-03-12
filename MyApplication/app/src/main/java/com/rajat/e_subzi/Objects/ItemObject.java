package com.rajat.e_subzi.Objects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Rajat on 06-03-2016.
 */
public class ItemObject implements Parcelable {
    String productId;
    int quantity;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ItemObject(String productId, int quantity) {

        this.productId = productId;
        this.quantity = quantity;
    }

    protected ItemObject(Parcel in) {
        productId = in.readString();
        quantity = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(productId);
        dest.writeInt(quantity);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<ItemObject> CREATOR = new Parcelable.Creator<ItemObject>() {
        @Override
        public ItemObject createFromParcel(Parcel in) {
            return new ItemObject(in);
        }

        @Override
        public ItemObject[] newArray(int size) {
            return new ItemObject[size];
        }
    };
}
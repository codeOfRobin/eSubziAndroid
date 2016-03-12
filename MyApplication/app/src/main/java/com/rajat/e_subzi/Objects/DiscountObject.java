package com.rajat.e_subzi.Objects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Rajat on 12-03-2016.
 */
public class DiscountObject implements Parcelable {
    String shopKeeperId;
    String discountDescription;
    String created_at;
    String updated_at;
    String discountId;

    public DiscountObject(String shopKeeperId, String discountDescription, String created_at, String updated_at, String discountId) {
        this.shopKeeperId = shopKeeperId;
        this.discountDescription = discountDescription;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.discountId = discountId;
    }

    public String getShopKeeperId() {
        return shopKeeperId;
    }

    public void setShopKeeperId(String shopKeeperId) {
        this.shopKeeperId = shopKeeperId;
    }

    public String getDiscountDescription() {
        return discountDescription;
    }

    public void setDiscountDescription(String discountDescription) {
        this.discountDescription = discountDescription;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getDiscountId() {
        return discountId;
    }

    public void setDiscountId(String discountId) {
        this.discountId = discountId;
    }

    protected DiscountObject(Parcel in) {
        shopKeeperId = in.readString();
        discountDescription = in.readString();
        created_at = in.readString();
        updated_at = in.readString();
        discountId = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(shopKeeperId);
        dest.writeString(discountDescription);
        dest.writeString(created_at);
        dest.writeString(updated_at);
        dest.writeString(discountId);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<DiscountObject> CREATOR = new Parcelable.Creator<DiscountObject>() {
        @Override
        public DiscountObject createFromParcel(Parcel in) {
            return new DiscountObject(in);
        }

        @Override
        public DiscountObject[] newArray(int size) {
            return new DiscountObject[size];
        }
    };
}
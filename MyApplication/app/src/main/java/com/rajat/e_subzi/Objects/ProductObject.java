package com.rajat.e_subzi.Objects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Rajat on 05-03-2016.
 */
public class ProductObject implements Parcelable {
    String created_at= "";
    String updated_at= "";
    String userId= "";
    int discount=0;
    String description= "";
    int quantity= 0;
    int price= 0;
    String productId= "";

    public ProductObject(String created_at, String updated_at, String userId, int discount, String description, int quantity, int price, String productId) {
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.userId = userId;
        this.discount = discount;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.productId = productId;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    protected ProductObject(Parcel in) {
        created_at = in.readString();
        updated_at = in.readString();
        userId = in.readString();
        discount = in.readInt();
        description = in.readString();
        quantity = in.readInt();
        price = in.readInt();
        productId = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(created_at);
        dest.writeString(updated_at);
        dest.writeString(userId);
        dest.writeInt(discount);
        dest.writeString(description);
        dest.writeInt(quantity);
        dest.writeInt(price);
        dest.writeString(productId);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<ProductObject> CREATOR = new Parcelable.Creator<ProductObject>() {
        @Override
        public ProductObject createFromParcel(Parcel in) {
            return new ProductObject(in);
        }

        @Override
        public ProductObject[] newArray(int size) {
            return new ProductObject[size];
        }
    };
}
package com.rajat.e_subzi.Objects;

/**
 * Created by Rajat on 06-03-2016.
 */
public class ItemObject {
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
}

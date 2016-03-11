package com.example.rishab.esubzi.Volley;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.rishab.esubzi.LoginActivity;
import com.example.rishab.esubzi.Objects.ItemObject;
import com.example.rishab.esubzi.Objects.OrderObject;
import com.example.rishab.esubzi.Objects.ProductObject;
import com.example.rishab.esubzi.Products;
import com.example.rishab.esubzi.Tools.Tools;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Rajat on 19-02-2016.
 */
public class JSONParser {
    public static void SignUpApiJsonParser(String JsonStringResult, Context con) {
        try {
            //boolean status;
            String email = "";
            String userId = "";
            String error = "";
            String token = "";
            String type = "";
            //create json object from response string
            JSONObject resultJson = new JSONObject(JsonStringResult);
            if (resultJson.has("token")) {
                token = resultJson.getString("token");
                LoginActivity.editor = LoginActivity.sharedpreferences.edit();
                LoginActivity.editor.putString("token", token);
                LoginActivity.editor.apply();
                if (resultJson.has("email")) {
                    email = resultJson.getString("email");
                }
                if (resultJson.has("userId")) {
                    userId = resultJson.getString("userId");
                }
                if (resultJson.has("type")) {
                    type = resultJson.getString("type");
                }

            } else if (resultJson.has("error")) {
                error = resultJson.getString("error");
            }
            Log.i("rajat", email + " " + userId + " " + token + " " + type + " " + error);
            Tools.showAlertDialog(email + " " + userId + " " + token + " " + type + " " + error, con);
        } catch (Exception e) {
            Log.i("rajat", "Exception: Login: " + e.getLocalizedMessage());
        }
    }

    public static void LoginApiJsonParser(String JsonStringResult, Context con) {
        try {
            //boolean status;
            String email = "";
            String userId = "";
            String error = "";
            String token = "";
            String type = "";
            //create json object from response string
            JSONObject resultJson = new JSONObject(JsonStringResult);
            if (resultJson.has("token")) {
                token = resultJson.getString("token");
                LoginActivity.editor = LoginActivity.sharedpreferences.edit();
                LoginActivity.editor.putString("token", token);
                LoginActivity.editor.apply();

                if (resultJson.has("email")) {
                    email = resultJson.getString("email");
                }
                if (resultJson.has("userId")) {
                    userId = resultJson.getString("userId");
                }
                if (resultJson.has("type")) {
                    type = resultJson.getString("type");
                }

            } else if (resultJson.has("error")) {
                error = resultJson.getString("error");
            }
            Log.i("rajat", email + " " + userId + " " + token + " " + type + " " + error);
            Tools.showAlertDialog(email + " " + userId + " " + token + " " + type + " " + error, con);
        } catch (Exception e) {
            Log.i("rajat", "Exception: Login: " + e.getLocalizedMessage());
        }
    }

    //
    public static void CreateProductApiJsonParser(String JsonStringResult, Context con) {
        try {

            JSONObject product;

            String created_at = "";
            String updated_at = "";
            String userId = "";
            int discount = 0;
            String description = "";
            int quantity = 0;
            int price = 0;
            String productId = "";
            String message = "";
            //create json object from response string
            JSONObject resultJson = new JSONObject(JsonStringResult);
            if (resultJson.has("newProduct")) {
                product = resultJson.getJSONObject("newProduct");
                discount = product.getInt("discount");
                quantity = product.getInt("quantity");
                price = product.getInt("price");
                userId = product.getString("userId");
                description = product.getString("description");
                productId = product.getString("_id");
                created_at = product.getString("created_at");
                updated_at = product.getString("updated_at");
                message = resultJson.getString("message");
            }
            Log.i("rajat", discount + " " + quantity + " " + price + " " + userId + " " + description + " " + productId + " " + message);
            Tools.showAlertDialog(discount + " " + quantity + " " + price + " " + userId + " " + description + " " + productId + " " + message, con);
        } catch (Exception e) {
            Log.i("rajat", "Exception: Login: " + e.getLocalizedMessage());
        }
    }

    public static void FindProductsApiJsonParser(String JsonStringResult, Context con) {
        try {
            Intent intent=new Intent(con, Products.class);
            intent.putExtra("data",JsonStringResult);
            con.startActivity(intent);
            JSONArray products;
            JSONObject product;
            String created_at = "";
            String updated_at = "";
            String userId = "";
            int discount = 0;
            String description = "";
            int quantity = 0;
            int price = 0;
            String productId = "";
            String message = "";
            //create json object from response string
            ArrayList<ProductObject> productObjList = new ArrayList<ProductObject>();
            JSONObject resultJson = new JSONObject(JsonStringResult);
            if (resultJson.has("products")) {
                products = resultJson.getJSONArray("products");
                for (int i = 0; i < products.length(); i++) {
                    product = products.getJSONObject(i);
                    discount = product.getInt("discount");
                    quantity = product.getInt("quantity");
                    if(product.has("price")){
                    price = product.getInt("price");}
                    userId = product.getString("userId");
                    description = product.getString("description");
                    productId = product.getString("_id");
                    created_at = product.getString("created_at");
                    updated_at = product.getString("updated_at");
                    productObjList.add(new ProductObject(created_at, updated_at, userId, discount, description, quantity, price, productId));
                }
                // message=resultJson.getString("message");
            }
            Log.i("rajat", discount + " " + quantity + " " + price + " " + userId + " " + description + " " + productId + " size: " + productObjList.size() + " " + message);
            Tools.showAlertDialog(discount + " " + quantity + " " + price + " " + userId + " " + description + " " + productId + " " + message, con);
        } catch (Exception e) {
            Log.i("rajat", "Exception: Login: " + e.getLocalizedMessage());
        }
    }

    //post_msgApiJsonParser
    public static void UpdateProductPriceApiJsonParser(String JsonStringResult, Context con) {
        try {

            JSONObject product;

            String created_at = "";
            String updated_at = "";
            String userId = "";
            int discount = 0;
            String description = "";
            int quantity = 0;
            int price = 0;
            String productId = "";
            String message = "";
            //create json object from response string
            JSONObject resultJson = new JSONObject(JsonStringResult);
            if (resultJson.has("newProduct")) {
                product = resultJson.getJSONObject("newProduct");
                discount = product.getInt("discount");
                quantity = product.getInt("quantity");
                price = product.getInt("price");
                userId = product.getString("userId");
                description = product.getString("description");
                productId = product.getString("_id");
                created_at = product.getString("created_at");
                updated_at = product.getString("updated_at");
                message = resultJson.getString("message");
            }
            Log.i("rajat", discount + " " + quantity + " " + price + " " + userId + " " + description + " " + productId + " " + message);
            Tools.showAlertDialog(discount + " " + quantity + " " + price + " " + userId + " " + description + " " + productId + " " + message, con);
        } catch (Exception e) {
            Log.i("rajat", "Exception: Login: " + e.getLocalizedMessage());
        }
    }

    public static void ChangeProductDiscountApiJsonParser(String JsonStringResult, Context con) {
        try {

            JSONObject product;

            String created_at = "";
            String updated_at = "";
            String userId = "";
            int discount = 0;
            String description = "";
            int quantity = 0;
            int price = 0;
            String productId = "";
            String message = "";
            //create json object from response string
            JSONObject resultJson = new JSONObject(JsonStringResult);
            if (resultJson.has("newProduct")) {
                product = resultJson.getJSONObject("newProduct");
                discount = product.getInt("discount");
                quantity = product.getInt("quantity");
                price = product.getInt("price");
                userId = product.getString("userId");
                description = product.getString("description");
                productId = product.getString("_id");
                created_at = product.getString("created_at");
                updated_at = product.getString("updated_at");
                message = resultJson.getString("message");
            }
            Log.i("rajat", discount + " " + quantity + " " + price + " " + userId + " " + description + " " + productId + " " + message);
            Tools.showAlertDialog(discount + " " + quantity + " " + price + " " + userId + " " + description + " " + productId + " " + message, con);
        } catch (Exception e) {
            e.printStackTrace();
            Log.i("rajat", "Exception: Login: " + e.getLocalizedMessage());
        }
    }

    public static void PlaceOrderApiJsonParser(String JsonStringResult, Context con) {
        try {

            JSONObject order;
            String orderId="";
            String created_at = "";
            String updated_at = "";
            String shopkeeperId = "";
            String currentState = "";
            String customerId = "";
            JSONArray items = new JSONArray();
            JSONObject item;
            String productId = "";
            int quantity = 0;
            String message = "";
            ItemObject itemObj;
            ArrayList<ItemObject> itemObjList = new ArrayList<ItemObject>();
            //create json object from response string
            JSONObject resultJson = new JSONObject(JsonStringResult);
            if (resultJson.has("newOrder")) {
                order = resultJson.getJSONObject("newOrder");
                orderId=order.getString("_id");
                shopkeeperId = order.getString("shopKeeperId");
                customerId = order.getString("customerId");
                created_at = order.getString("created_at");
                updated_at = order.getString("updated_at");
                //Log.i("rajat",resultJson.get("items").getClass()+" "+resultJson.get(""));
                items = order.getJSONArray("items");
                for (int i = 0; i < items.length(); i++) {
                    item = items.getJSONObject(i);
                    productId = item.getString("productId");
                    quantity = item.getInt("quantity");
                    itemObj = new ItemObject(productId, quantity);
                    itemObjList.add(itemObj);
                }
                message = resultJson.getString("message");
            }
            Log.i("rajat",orderId+" "+ shopkeeperId + " " + customerId + " " + itemObjList.size() + " " + productId + " " + message);
            Tools.showAlertDialog(shopkeeperId + " " + customerId + " " + itemObjList.size() + " " + productId + " " + message, con);
        } catch (Exception e) {
            e.printStackTrace();
            Log.i("rajat", "Exception: Login: " + e.getLocalizedMessage());
        }
    }

    public static void ChangeOrderStateApiJsonParser(String JsonStringResult, Context con) {
        try {

            JSONObject order;
            String orderId="";
            String created_at = "";
            String updated_at = "";
            String shopkeeperId = "";
            String currentState = "";
            String customerId = "";
            JSONArray items = new JSONArray();
            JSONObject item;
            String productId = "";
            int quantity = 0;
            String message = "";
            ItemObject itemObj;
            ArrayList<ItemObject> itemObjList = new ArrayList<ItemObject>();
            //create json object from response string
            JSONObject resultJson = new JSONObject(JsonStringResult);
            if (resultJson.has("modifiedOrder")) {
                order = resultJson.getJSONObject("modifiedOrder");
                orderId=order.getString("_id");
                shopkeeperId = order.getString("shopKeeperId");
                customerId = order.getString("customerId");
                created_at = order.getString("created_at");
                updated_at = order.getString("updated_at");
                //Log.i("rajat",resultJson.get("items").getClass()+" "+resultJson.get(""));
                items = order.getJSONArray("items");
                for (int i = 0; i < items.length(); i++) {
                    item = items.getJSONObject(i);
                    productId = item.getString("productId");
                    quantity = item.getInt("quantity");
                    itemObj = new ItemObject(productId, quantity);
                    itemObjList.add(itemObj);
                }
                message = resultJson.getString("message");
            }
            Log.i("rajat",orderId+" " + shopkeeperId + " " + customerId + " " + itemObjList.size() + " " + productId + " " + message);
            Tools.showAlertDialog(shopkeeperId + " " + customerId + " " + itemObjList.size() + " " + productId + " " + message, con);
        } catch (Exception e) {
            e.printStackTrace();
            Log.i("rajat", "Exception: Login: " + e.getLocalizedMessage());
        }
    }

    public static void FindOrdersApiJsonParser(String JsonStringResult, Context con) {
        try {
            JSONArray orders=new JSONArray();
            OrderObject orderObject;
            ArrayList<OrderObject> orderObjList= new ArrayList<OrderObject>();
            JSONObject order;
            String orderId="";
            String created_at = "";
            String updated_at = "";
            String shopkeeperId = "";
            String currentState = "";
            String customerId = "";
            JSONArray items = new JSONArray();
            JSONObject item;
            String productId = "";
            int quantity = 0;
            String message = "";
            ItemObject itemObj;
            //
            ArrayList<ItemObject> itemObjList = new ArrayList<ItemObject>();
            //create json object from response string
            JSONObject resultJson = new JSONObject(JsonStringResult);
            if (resultJson.has("Orders")) {
                orders =resultJson.getJSONArray("Orders");
                for(int x=0;x<orders.length();x++){
                    order = orders.getJSONObject(x);
                    orderId= order.getString("_id");
                    shopkeeperId = order.getString("shopKeeperId");
                    customerId = order.getString("customerId");
                    created_at = order.getString("created_at");
                    updated_at = order.getString("updated_at");
                    //Log.i("rajat",resultJson.get("items").getClass()+" "+resultJson.get(""));
                    items = order.getJSONArray("items");
                    for (int i = 0; i < items.length(); i++) {
                        item = items.getJSONObject(i);
                        productId = item.getString("productId");
                        quantity = item.getInt("quantity");
                        itemObj = new ItemObject(productId, quantity);
                        itemObjList.add(itemObj);

                    }
                    orderObject=new OrderObject(shopkeeperId,currentState,customerId,orderId,created_at,updated_at,itemObjList);
                    orderObjList.add(orderObject);
                }

                message = resultJson.getString("message");
            }
            Log.i("rajat", shopkeeperId + " " + customerId + " " + orderObjList.size() + " " + productId + " " + message);
            Tools.showAlertDialog(shopkeeperId + " " + customerId + " " + orderObjList.size() + " " + productId + " " + message, con);
        } catch (Exception e) {
            e.printStackTrace();
            Log.i("rajat", "Exception: Login: " + e.getLocalizedMessage());
        }
    }
}
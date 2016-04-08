package com.rajat.e_subzi.Volley;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.rajat.e_subzi.AddProducts;
import com.rajat.e_subzi.Discounts;
import com.rajat.e_subzi.LoginActivity;
import com.rajat.e_subzi.Objects.ItemObject;
import com.rajat.e_subzi.Objects.OrderObject;
import com.rajat.e_subzi.Objects.ProductObject;
import com.rajat.e_subzi.Orders;
import com.rajat.e_subzi.Products;
import com.rajat.e_subzi.Tools.MultipartRequest;
import com.rajat.e_subzi.Tools.Tools;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

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
            if(resultJson.has("message")){
                Toast.makeText(con, "Invalid "+resultJson.getString("message"),
                        Toast.LENGTH_LONG).show();
                return;
            }
            if (resultJson.has("token")) {
                SharedPreferences pref = con.getSharedPreferences("MyPrefs", con.MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                token = resultJson.getString("token");



                if (resultJson.has("email")) {
                    email = resultJson.getString("email");
                    editor.putString("email", email);
                }
                if (resultJson.has("userId")) {
                    userId = resultJson.getString("userId");
                    editor.putString("userId", userId);
                }
                if (resultJson.has("type")) {
                    type = resultJson.getString("type");
                    editor.putString("type", type);
                }
                editor.apply();

            } else if (resultJson.has("error")) {
                error = resultJson.getString("error");
            }
            Log.i("rajat", email + " " + userId + " " + token + " " + type + " " + error);
//            Tools.showAlertDialog(email + " " + userId + " " + token + " " + type + " " + error, con);
            if(type.equals("Shopkeeper")){
                VolleyClick.findProductsClick(userId,con);
            }
            else{
                VolleyClick.findDiscountsClick(userId,con);
            }
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
            if(resultJson.has("message")){
                Toast.makeText(con, "Invalid "+resultJson.getString("message"),
                        Toast.LENGTH_LONG).show();
                return;
            }
            if (resultJson.has("token")) {
                SharedPreferences pref = con.getSharedPreferences("MyPrefs", con.MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                token = resultJson.getString("token");
                editor.putString("token", token);


                if (resultJson.has("email")) {
                    email = resultJson.getString("email");
                    editor.putString("email", email);
                }
                if (resultJson.has("userId")) {
                    userId = resultJson.getString("userId");
                    editor.putString("userId", userId);
                }
                if (resultJson.has("type")) {
                    type = resultJson.getString("type");
                    editor.putString("type", type);
                }
                editor.apply();
            } else if (resultJson.has("error")) {
                error = resultJson.getString("error");
            }

            if(type.equals("Shopkeeper")){
                VolleyClick.findProductsClick(userId,con);
            }
            else{
                VolleyClick.findDiscountsClick(userId,con);
            }


            Log.i("rajat", email + " " + userId + " " + token + " " + type + " " + error);
//            Tools.showAlertDialog(email + " " + userId + " " + token + " " + type + " " + error, con);
//            if(type.equals("1")){
//                VolleyClick.findProductsClick(userId,con);
//            }
//            else{
//                VolleyClick.findDiscountsClick(userId,con);
//            }


        } catch (Exception e) {
            Log.i("rajat", "Exception: Login: " + e.getLocalizedMessage());
        }
    }

    //
    public static void CreateProductApiJsonParser(String JsonStringResult, Context con, File file,Map<String,String> pprams,Response.Listener<String> mlistener, Response.ErrorListener err, MultipartRequest.MultipartProgressListener listener) {
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
//            Tools.showAlertDialog(discount + " " + quantity + " " + price + " " + userId + " " + description + " " + productId + " " + message, con);
//            uploadFile("ImageUpload","http://192.168.43.69:3000/api/get_pic",file, "multipart",pprams,mlistener,err,listener,con);
            VolleyClick.findProductsClick(userId, con);
        } catch (Exception e) {
            Log.i("rajat", "Exception: Login: " + e.getLocalizedMessage());
        }
    }

    public static void FindProductsApiJsonParser(String JsonStringResult, Context con) {
        try {
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
////            Tools.showAlertDialog(discount + " " + quantity + " " + price + " " + userId + " " + description + " " + productId + " " + message, con);
            Intent intent=new Intent(con,Products.class);

            intent.putExtra("data", (String) new Gson().toJson(productObjList));
            con.startActivity(intent);
        } catch (Exception e) {
            Log.i("rajat", "Exception: Login: " + e.getLocalizedMessage());
        }
    }

    public static void FindDiscountsApiJsonParser(String JsonStringResult, Context con) {
        ArrayList<ProductObject> productObjList;
        try {

            JSONArray products=new JSONArray();
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
            productObjList = new ArrayList<ProductObject>();
            //JSONObject resultJson = new JSONObject(JsonStringResult);
            products= new JSONArray(JsonStringResult);

            if (products.length()!=0) {
                //resultJson.toJSONArray(products);
                 for (int i = 0; i < products.length(); i++) {
                    product = products.getJSONObject(i);
                     price =product.getInt("price");
                    if(product.has("discount"))
                    discount = product.getInt("discount");
                    quantity = product.getInt("quantity");
                    if(product.has("userId"))
                    userId = product.getString("userId");
                    description = product.getString("description");
                    productId = product.getString("_id");
                    if(product.has("created_at"))
                    created_at = product.getString("created_at");
                    if(product.has("updated_at"))
                    updated_at = product.getString("updated_at");
                    productObjList.add(new ProductObject(created_at, updated_at, userId, discount, description, quantity, price, productId));
                }
                // message=resultJson.getString("message");
            }
            Log.i("rajat", discount + " " + quantity + " " + price + " " + userId + " " + description + " " + productId + " size: " + productObjList.size() + " " + message);
//            Tools.showAlertDialog(discount + " " + quantity + " " + price + " " + userId + " " + description + " " + productId + " " + message, con);
            Intent intent=new Intent(con,Discounts.class);
            intent.putExtra("data",new Gson().toJson(productObjList));
            con.startActivity(intent);
        } catch (Exception e) {
            Log.i("rajat", "Exception: Login: " + e.getLocalizedMessage());
            productObjList=new ArrayList<ProductObject>();
            Intent intent=new Intent(con,Discounts.class);
            intent.putExtra("data", (String) new Gson().toJson(productObjList));
            con.startActivity(intent);
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
//            Tools.showAlertDialog(discount + " " + quantity + " " + price + " " + userId + " " + description + " " + productId + " " + message, con);
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
//            Tools.showAlertDialog(discount + " " + quantity + " " + price + " " + userId + " " + description + " " + productId + " " + message, con);
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
                if(order.has("shopKeeperId"))
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
//            Tools.showAlertDialog(shopkeeperId + " " + customerId + " " + itemObjList.size() + " " + productId + " " + message, con);
            SharedPreferences pref = con.getSharedPreferences("MyPrefs", con.MODE_PRIVATE);
            VolleyClick.findOrdersClick(pref.getString("userId", " "), pref.getString("type", ""), con);
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
                if(order.has("customerId"))
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
            Log.i("rajat", orderId + " " + shopkeeperId + " " + customerId + " " + itemObjList.size() + " " + productId + " " + message);
//            Tools.showAlertDialog(shopkeeperId + " " + customerId + " " + itemObjList.size() + " " + productId + " " + message, con);
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
                    currentState = order.getString("currentState");
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
//            Tools.showAlertDialog(shopkeeperId + " " + customerId + " " + orderObjList.size() + " " + productId + " " + message, con);
            Intent intent=new Intent(con, Orders.class);
            intent.putExtra("data",new Gson().toJson(orderObjList));
            con.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            Log.i("rajat", "Exception: Login: " + e.getLocalizedMessage());
        }
    }
    public static void RegisterApiJsonParser(String JsonStringResult, Context con){
        try {

            JSONObject device;
            String token="";
            String deviceType="";
            String email="";
            String  deviceId="";

            String message = "";
            //create json object from response string
            JSONObject resultJson = new JSONObject(JsonStringResult);
            if (resultJson.has("Device")) {
                device = resultJson.getJSONObject("Device");
                token = device.getString("token");
                email= device.getString("email");
                deviceId = device.getString("_id");
                deviceType = device.getString("deviceType");

            }
            if(resultJson.has("message")){
                message = resultJson.getString("message");
            }
            Log.i("rajat", token + " " + email + " " + deviceId + " " + deviceType + " " + message );
            Tools.showAlertDialog(token + message, con);
        } catch (Exception e) {
            e.printStackTrace();
            Log.i("rajat", "Exception: Login: " + e.getLocalizedMessage());
        }
    }
    public static  <T> void uploadFile(final String tag, final String url,
                                  final File file, final String partName,
                                  final Map<String, String> headerParams,
                                  final Response.Listener<String> resultDelivery,
                                  final Response.ErrorListener errorListener,
                                  MultipartRequest.MultipartProgressListener progListener,Context context) {


        MultipartRequest mr = new MultipartRequest(url, errorListener,
                resultDelivery, file, file.length(), null, headerParams,
                partName, progListener);

        Log.d("mp","working");
        mr.setTag(tag);
        VolleySingleton.getInstance(context).addToRequestQueue(mr);
//        Volley.newRequestQueue(this).add(mr);

    }
}
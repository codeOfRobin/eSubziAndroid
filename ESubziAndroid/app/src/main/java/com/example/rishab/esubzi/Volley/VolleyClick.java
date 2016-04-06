package com.example.rishab.esubzi.Volley;
import android.content.Context;

import com.android.volley.Response;
import com.example.rishab.esubzi.LoginActivity;
import com.example.rishab.esubzi.SignUp;
import com.example.rishab.esubzi.Tools.CheckNetwork;
import com.example.rishab.esubzi.Tools.MultipartRequest;
import com.example.rishab.esubzi.Tools.Tools;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Rajat on 07-03-2016.
 */
public class VolleyClick {

    public static void signUp(String email,String  password,String type,Context context){
        CheckNetwork chkNet = new CheckNetwork(context);
        String URL = "http://128.199.152.41:3000/api/signup";
//        if (!chkNet.checkNetwork()) {
            VolleySingleton.getInstance(context).getRequestQueue().getCache().clear();
            CallVolley.signUpCall(URL, context, email, password, type, 3);
//        } else {
//            Tools.showAlertDialog("Internet Available", context);
//        }
    }
    public static void loginClick(String email,String  password,Context context){
        CheckNetwork chkNet = new CheckNetwork(context);
        String URL = "http://128.199.152.41:3000/api/login";
//        if (!chkNet.checkNetwork()) {
            VolleySingleton.getInstance(context).getRequestQueue().getCache().clear();
            CallVolley.loginCall(URL, context, email, password, 3);
//        } else {
//            Tools.showAlertDialog("Internet Available", context);
//        }
    }

    public static void createProductClick(int price ,int quantity, String description, String userId ,int discount,Context context, File file,Map<String,String> pprams,Response.Listener<String> mlistener, Response.ErrorListener err, MultipartRequest.MultipartProgressListener listener){
        CheckNetwork chkNet = new CheckNetwork(context);
        String URL = "http://128.199.152.41:3000/api/products/create";
//        if (!chkNet.checkNetwork()) {
            VolleySingleton.getInstance(context).getRequestQueue().getCache().clear();
            CallVolley.createProductCall(URL, context, price, quantity, description, userId, discount, 3,file,pprams,mlistener,err,listener);
//        } else {
//            Tools.showAlertDialog("Internet Available", context);
//        }
    }
    public static void findProductsClick(String userId,Context context){
        CheckNetwork chkNet = new CheckNetwork(context);
        String URL = "http://128.199.152.41:3000/api/products/find";
//        if (!chkNet.checkNetwork()) {
            VolleySingleton.getInstance(context).getRequestQueue().getCache().clear();
            CallVolley.findProductsCall(URL, context, userId, 3);
//        } else {
//            Tools.showAlertDialog("Internet Available", context);
//        }
    }
    public static void findDiscountsClick(String userId,Context context){
//        CheckNetwork chkNet = new CheckNetwork(context);
        String URL = "http://128.199.152.41:3000/api/discounts/get";
//        if (!chkNet.checkNetwork()) {
            VolleySingleton.getInstance(context).getRequestQueue().getCache().clear();
            CallVolley.findDiscountsCall(URL, context, userId, 3);
//        } else {
//            Tools.showAlertDialog("Internet Available", context);
//        }
    }
    public static void updatePriceClick(String productId,int price,Context context){
//        CheckNetwork chkNet = new CheckNetwork(context);
        String URL = "http://128.199.152.41:3000/api/update_price";
//        if (!chkNet.checkNetwork()) {
            VolleySingleton.getInstance(context).getRequestQueue().getCache().clear();
            CallVolley.updateProductPriceCall(URL, context, productId, price, 3);
//        } else {
//            Tools.showAlertDialog("Internet Available", context);
//        }
    }
    public static void changeDiscountClick(String productId,int discount,Context context){
//        CheckNetwork chkNet = new CheckNetwork(context);
        String URL = "http://128.199.152.41:3000/api/change_discount";
//        if (!chkNet.checkNetwork()) {
            VolleySingleton.getInstance(context).getRequestQueue().getCache().clear();
            CallVolley.changeProductDiscountCall(URL, context, productId, discount, 3);
//        } else {
//            Tools.showAlertDialog("Internet Available", context);
//        }
    }

    //placeOrderCall
    public static void placeOrderClick(String customerId,ArrayList<String> productIds,ArrayList<Float> quantities,Context context){
//        CheckNetwork chkNet = new CheckNetwork(context);
        String URL = "http://128.199.152.41:3000/api/placeOrder";
//        if (!chkNet.checkNetwork()) {
            VolleySingleton.getInstance(context).getRequestQueue().getCache().clear();
            CallVolley.placeOrderCall(URL, context, customerId, productIds, quantities, 3);
//        } else {
//            Tools.showAlertDialog("Internet Available", context);
//        }
    }
    public static void changeOrderStateClick(String orderId,String orderState,Context context){
//        CheckNetwork chkNet = new CheckNetwork(context);
        String URL = "http://128.199.152.41:3000/api/change_order_state";
//        if (!chkNet.checkNetwork()) {
            VolleySingleton.getInstance(context).getRequestQueue().getCache().clear();
            CallVolley.changeOrderStateCall(URL, context, orderId, orderState, 3);
//        } else {
//            Tools.showAlertDialog("Internet Available", context);
//        }
    }
    public static void changePreferencesClick(String userId,Context context,ArrayList<String> shops){
//        CheckNetwork chkNet = new CheckNetwork(context);
        String URL = "http://128.199.152.41:3000/api/change_order_state";
//        if (!chkNet.checkNetwork()) {
        VolleySingleton.getInstance(context).getRequestQueue().getCache().clear();
        CallVolley.changePreferencesCall(URL, context, userId, shops, 3);
//        } else {
//            Tools.showAlertDialog("Internet Available", context);
//        }
    }
    public static void findPreferencesClick(String userId,Context context){
//        CheckNetwork chkNet = new CheckNetwork (context);
        String URL = "http://128.199.152.41:3000/api/change_order_state";
//        if (!chkNet.checkNetwork()) {
        VolleySingleton.getInstance(context).getRequestQueue().getCache().clear();
        CallVolley.findPreferencesCall(URL, context, userId, 3);
//        } else {
//            Tools.showAlertDialog("Internet Available", context);
//        }
    }
    public static void findOrdersClick(String userId,String usertype,Context context){
//        CheckNetwork chkNet = new CheckNetwork(context);
        String URL = "http://128.199.152.41:3000/api/findOrdersNotDelivered";
//        if (!chkNet.checkNetwork()) {
            VolleySingleton.getInstance(context).getRequestQueue().getCache().clear();
            CallVolley.findOrdersCall(URL, context, userId, usertype, 3);
//        } else {
//            Tools.showAlertDialog("Internet Available", context);
//        }
    }
}

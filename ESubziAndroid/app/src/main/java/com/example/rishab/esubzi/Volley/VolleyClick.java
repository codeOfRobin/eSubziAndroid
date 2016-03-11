package com.example.rishab.esubzi.Volley;
import android.content.Context;

import com.example.rishab.esubzi.LoginActivity;
import com.example.rishab.esubzi.Tools.CheckNetwork;
import com.example.rishab.esubzi.Tools.Tools;

/**
 * Created by Rajat on 07-03-2016.
 */
public class VolleyClick {

    public static void signUp(String email,String  password,String type){
        CheckNetwork chkNet = new CheckNetwork(LoginActivity.context);
        String URL = "http://192.168.43.200:3000/api/signup";
        if (!chkNet.checkNetwork()) {
            VolleySingleton.getInstance(LoginActivity.context).getRequestQueue().getCache().clear();
            CallVolley.signUpCall(URL, LoginActivity.context, email, password, type, 3);
        } else {
            Tools.showAlertDialog("Internet Available", LoginActivity.context);
        }
    }
    public static void loginClick(String email,String  password){
        CheckNetwork chkNet = new CheckNetwork(LoginActivity.context);
        String URL = "http://192.168.43.200:3000/api/login";
        if (!chkNet.checkNetwork()) {
            VolleySingleton.getInstance(LoginActivity.context).getRequestQueue().getCache().clear();
            CallVolley.loginCall(URL, LoginActivity.context, email, password, 3);
        } else {
            Tools.showAlertDialog("Internet Available", LoginActivity.context);
        }
    }

    public static void createProductClick(int price ,int quantity, String description, String userId ,int discount){
        CheckNetwork chkNet = new CheckNetwork(LoginActivity.context);
        String URL = "http://192.168.43.200:3000/api/products/create";
        if (!chkNet.checkNetwork()) {
            VolleySingleton.getInstance(LoginActivity.context).getRequestQueue().getCache().clear();
            CallVolley.createProductCall(URL, LoginActivity.context, price, quantity, description, userId, discount, 3);
        } else {
            Tools.showAlertDialog("Internet Available", LoginActivity.context);
        }
    }
    public static void findProductsClick(String userId,Context context){
        CheckNetwork chkNet = new CheckNetwork(LoginActivity.context);
        String URL = "http://192.168.43.200:3000/api/products/find";
        if (!chkNet.checkNetwork()) {
            VolleySingleton.getInstance(context).getRequestQueue().getCache().clear();
            CallVolley.findProductsCall(URL, LoginActivity.context, userId, 3);
        } else {
            Tools.showAlertDialog("Internet Available", LoginActivity.context);
        }
    }
    public static void updatePriceClick(String productId,int price){
        CheckNetwork chkNet = new CheckNetwork(LoginActivity.context);
        String URL = "http://192.168.43.200:3000/api/update_price";
        if (!chkNet.checkNetwork()) {
            VolleySingleton.getInstance(LoginActivity.context).getRequestQueue().getCache().clear();
            CallVolley.updateProductPriceCall(URL, LoginActivity.context, productId, price, 3);
        } else {
            Tools.showAlertDialog("Internet Available", LoginActivity.context);
        }
    }
    public static void changeDiscountClick(String productId,int discount){
        CheckNetwork chkNet = new CheckNetwork(LoginActivity.context);
        String URL = "http://192.168.43.200:3000/api/change_discount";
        if (!chkNet.checkNetwork()) {
            VolleySingleton.getInstance(LoginActivity.context).getRequestQueue().getCache().clear();
            CallVolley.changeProductDiscountCall(URL, LoginActivity.context, productId, discount, 3);
        } else {
            Tools.showAlertDialog("Internet Available", LoginActivity.context);
        }
    }

    //placeOrderCall
    public static void placeOrderClick(String customerId,String[] productIds,int[] quantities){
        CheckNetwork chkNet = new CheckNetwork(LoginActivity.context);
        String URL = "http://192.168.43.200:3000/api/placeOrder";
        if (!chkNet.checkNetwork()) {
            VolleySingleton.getInstance(LoginActivity.context).getRequestQueue().getCache().clear();
            CallVolley.placeOrderCall(URL, LoginActivity.context, customerId, productIds, quantities, 3);
        } else {
            Tools.showAlertDialog("Internet Available", LoginActivity.context);
        }
    }
    public static void changeOrderStateClick(String orderId,String orderState){
        CheckNetwork chkNet = new CheckNetwork(LoginActivity.context);
        String URL = "http://192.168.43.200:3000/api/change_order_state";
        if (!chkNet.checkNetwork()) {
            VolleySingleton.getInstance(LoginActivity.context).getRequestQueue().getCache().clear();
            CallVolley.changeOrderStateCall(URL, LoginActivity.context, orderId, orderState, 3);
        } else {
            Tools.showAlertDialog("Internet Available", LoginActivity.context);
        }
    }
    public static void findOrdersClick(String userId,String usertype){
        CheckNetwork chkNet = new CheckNetwork(LoginActivity.context);
        String URL = "http://192.168.43.200:3000/api/find_orders";
        if (!chkNet.checkNetwork()) {
            VolleySingleton.getInstance(LoginActivity.context).getRequestQueue().getCache().clear();
            CallVolley.findOrdersCall(URL, LoginActivity.context, userId, usertype, 3);
        } else {
            Tools.showAlertDialog("Internet Available", LoginActivity.context);
        }
    }
}

package com.rajat.e_subzi.Volley;

import android.content.Context;

import com.rajat.e_subzi.LoginActivity;
import com.rajat.e_subzi.Tools.CheckNetwork;
import com.rajat.e_subzi.Tools.Tools;
import com.rajat.e_subzi.gcm.MainActivity;

/**
 * Created by Rajat on 07-03-2016.
 */
public class VolleyClick {
   // static Context con = MainActivity.context;
    static boolean run=true;
    public static void signUp(String email,String  password,String type,Context con){
        CheckNetwork chkNet = new CheckNetwork(con);
        String URL = "http://192.168.43.200:3000/api/signup";
        if (run) {
            VolleySingleton.getInstance(con).getRequestQueue().getCache().clear();
            CallVolley.signUpCall(URL, con, email, password, type, 3);
        } else {
            Tools.showAlertDialog("Internet UnAvailable", con);
        }
    }
    public static void loginClick(String email,String  password,Context con){
        CheckNetwork chkNet = new CheckNetwork(con);
        String URL = "http://192.168.43.200:3000/api/login";
        if (run) {
            VolleySingleton.getInstance(con).getRequestQueue().getCache().clear();
            CallVolley.loginCall(URL, con, email, password, 3);
        } else {
            Tools.showAlertDialog("Internet UnAvailable", con);
        }
    }

    public static void createProductClick(int price ,int quantity, String description, String userId ,int discount,Context con){
        CheckNetwork chkNet = new CheckNetwork(con);
        String URL = "http://192.168.43.200:3000/api/products/create";
        if (run) {
            VolleySingleton.getInstance(con).getRequestQueue().getCache().clear();
            CallVolley.createProductCall(URL, con, price, quantity, description, userId, discount, 3);
        } else {
            Tools.showAlertDialog("Internet UnAvailable", con);
        }
    }
    public static void findProductsClick(String userId,Context con){
        CheckNetwork chkNet = new CheckNetwork(con);
        String URL = "http://192.168.43.200:3000/api/products/find";
        if (run) {
            VolleySingleton.getInstance(con).getRequestQueue().getCache().clear();
            CallVolley.findProductsCall(URL, con, userId, 3);
        } else {
            Tools.showAlertDialog("Internet UnAvailable", con);
        }
    }
    public static void updatePriceClick(String productId,int price,Context con){
        CheckNetwork chkNet = new CheckNetwork(con);
        String URL = "http://192.168.43.200:3000/api/update_price";
        if (run) {
            VolleySingleton.getInstance(con).getRequestQueue().getCache().clear();
            CallVolley.updateProductPriceCall(URL, con, productId, price, 3);
        } else {
            Tools.showAlertDialog("Internet UnAvailable", con);
        }
    }
    public static void changeDiscountClick(String productId,int discount,Context con){
        CheckNetwork chkNet = new CheckNetwork(con);
        String URL = "http://192.168.43.200:3000/api/change_discount";
        if (run) {
            VolleySingleton.getInstance(con).getRequestQueue().getCache().clear();
            CallVolley.changeProductDiscountCall(URL, con, productId, discount, 3);
        } else {
            Tools.showAlertDialog("Internet UnAvailable", con);
        }
    }

    //placeOrderCall
    public static void placeOrderClick(String customerId,String[] productIds,int[] quantities,Context con){
        CheckNetwork chkNet = new CheckNetwork(con);
        String URL = "http://192.168.43.200:3000/api/placeOrder";
        if (run) {
            VolleySingleton.getInstance(con).getRequestQueue().getCache().clear();
            CallVolley.placeOrderCall(URL, con, customerId, productIds, quantities, 3);
        } else {
            Tools.showAlertDialog("Internet UnAvailable", con);
        }
    }
    public static void changeOrderStateClick(String orderId,String orderState,Context con){
        CheckNetwork chkNet = new CheckNetwork(con);
        String URL = "http://192.168.43.200:3000/api/change_order_state";
        if (run) {
            VolleySingleton.getInstance(con).getRequestQueue().getCache().clear();
            CallVolley.changeOrderStateCall(URL, con, orderId, orderState, 3);
        } else {
            Tools.showAlertDialog("Internet UnAvailable", con);
        }
    }
    public static void findOrdersClick(String userId,String usertype,Context con){
        CheckNetwork chkNet = new CheckNetwork(con);
        String URL = "http://192.168.43.200:3000/api/find_orders";
        if (run) {
            VolleySingleton.getInstance(con).getRequestQueue().getCache().clear();
            CallVolley.findOrdersCall(URL, con, userId, usertype, 3);
        } else {
            Tools.showAlertDialog("Internet UnAvailable", con);
        }
    }

    public static void registerDeviceClick(String regId,String email,String type,Context con){
        CheckNetwork chkNet = new CheckNetwork(con);
        String URL = "http://192.168.43.200:3000/api/register";
        if (run) {
            VolleySingleton.getInstance(con).getRequestQueue().getCache().clear();
            CallVolley.registerDeviceCall(URL, con, regId, email, type, 3);
        } else {
            Tools.showAlertDialog("Internet UnAvailable", con);
        }
    }
    public static void createDiscountClick(String shopId,String discountDesc,Context con){
        CheckNetwork chkNet = new CheckNetwork(con);
        String URL = "http://192.168.43.200:3000/api/discounts/create";
        if (run) {
            VolleySingleton.getInstance(con).getRequestQueue().getCache().clear();
            CallVolley.createDiscountCall(URL, con, shopId, discountDesc, 3);
        } else {
            Tools.showAlertDialog("Internet UnAvailable", con);
        }
    }
//getDiscountsCall
     public static void getDiscountsClick(Context con){
CheckNetwork chkNet = new CheckNetwork(con);
    String URL = "http://192.168.43.200:3000/api/discounts/get";
    if (run) {
        VolleySingleton.getInstance(con).getRequestQueue().getCache().clear();
        CallVolley.getDiscountsCall(URL, con, 3);
    } else {
        Tools.showAlertDialog("Internet UnAvailable", con);
    }
}

    //VolleyClick.getDiscountsClick(MainActivity.context);
    //VolleyClick.createDiscountClick("56daf665a32c7f2c2ebda1a8","Banana at 10/kg",MainActivity.context);
}

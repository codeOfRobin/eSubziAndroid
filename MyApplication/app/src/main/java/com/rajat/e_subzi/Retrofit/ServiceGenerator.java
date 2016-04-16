//package com.rajat.e_subzi.Retrofit;
//
//import okhttp3.OkHttpClient;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//
///**
// * Created by Rajat on 14-04-2016.
// */
//public class ServiceGenerator {
//
//    public static final String API_BASE_URL = "http://192.168.43.200:3000/api/profile";
//
//    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//
//    private static Retrofit.Builder builder =
//            new Retrofit.Builder()
//                    .baseUrl(API_BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create());
//
//    public static <S> S createService(Class<S> serviceClass) {
//        Retrofit retrofit = builder.client(httpClient.build()).build();
//        return retrofit.create(serviceClass);
//    }
//}
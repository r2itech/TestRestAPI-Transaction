package com.fkomuniku.testcoding_qtasnim.net;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class NetworkManager {

//    private static final String BASE_URL = "http://192.168.43.80/testCoding-Qtasnim/public/api/"; //MyPhone Wireless
    private static final String BASE_URL = "http://r2it-testcoding.000webhostapp.com/api/"; //Host

    public static OkHttpClient okHttpClient;
    public static NetworkManager instance;
    private static Retrofit retrofit;
    private static Gson gson;

    public static NetworkManager getInstance(Class<NetworkService> networkServiceClass){
        if(instance == null){
            instance = new NetworkManager();
        }
        return instance;
    }

    public static Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(NetworkManager.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static NetworkService getNetworkService(Context context){
        okHttpClient = new OkHttpClient.Builder()
                .readTimeout(60000, TimeUnit.MILLISECONDS)
                .connectTimeout(60000, TimeUnit.MILLISECONDS)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request().newBuilder()
                                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                                .build();
                        return chain.proceed(request);
                    }
                })
                .build();

        gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        NetworkService networkService = retrofit.create(NetworkService.class);
        return networkService;
    }

    public static NetworkService getNetworkWithToken(Context context, final String token){

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            public Response intercept(Chain chain) throws IOException {

                Request newRequest  = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer " + token)
                        .addHeader("Content-Type", "application/x-www-form-urlencoded")
                        .build();
                return chain.proceed(newRequest);
            }
        }).readTimeout(10000, TimeUnit.MILLISECONDS)
                .connectTimeout(10000, TimeUnit.MILLISECONDS).build();

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        NetworkService networkService = retrofit.create(NetworkService.class);
        return  networkService;
    }
}

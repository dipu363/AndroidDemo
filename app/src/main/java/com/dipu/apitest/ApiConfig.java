package com.dipu.apitest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiConfig {

    private static final String BASE_URL = "http://aborong.com/orderapi/orderapi/";
    private static Retrofit retrofit = null;

    public static Retrofit getRetrofit (){

        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


}

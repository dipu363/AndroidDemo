package com.dipu.apitest;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CustomService {

    @GET("prodl/list")
    Call<BaseResponse> getCatagoris();

}

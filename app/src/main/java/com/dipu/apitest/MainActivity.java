package com.dipu.apitest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    ListView listView;
    List<CatagoryModel> catList;
    CustomAddapter addapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list_view_id);
        catList = new ArrayList<>();

        getCatgory();
    }

    private void getCatgory() {

        CustomService service =  ApiConfig.getRetrofit().create(CustomService.class);
        Call<BaseResponse> callapi = service.getCatagoris();
        callapi.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {

                BaseResponse baseResponse = response.body();
                if(baseResponse.isSuccess() && baseResponse.getData().size()>0){

                    catList  = baseResponse.getData();
                    // for handilling  java.lang.ClassCastException: com.google.gson.internal.LinkedTreeMap cannot be cast to com.dipu.apitest.CatagoryModel
                    String jsons = new Gson().toJson(catList);
                    Type listType = new TypeToken<ArrayList<CatagoryModel>>(){}.getType();
                    ArrayList<CatagoryModel>   catagory = new Gson().fromJson(jsons, listType);
                    addapter = new CustomAddapter(MainActivity.this,catagory);
                    listView.setAdapter(addapter);
                    // if need list item click event then call listView.setOnItemClickListener()
                    // if need list child item event then handel from adapter;

                }else{

                    System.out.println("Data Not Found");
                }
                System.out.println("Message  "+ response.body().getMessage());
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                System.out.println("Message Fail"+t.getMessage());
            }
        });


    }
}
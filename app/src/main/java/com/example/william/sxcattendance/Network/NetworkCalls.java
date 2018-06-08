package com.example.william.sxcattendance.Network;

import android.util.Log;

import com.example.william.sxcattendance.DataBase.Models.DbModel;
import com.example.william.sxcattendance.Network.Apis.ApiInterface;
import com.example.william.sxcattendance.Network.RetrofitService.HttpService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkCalls {

    public NetworkCalls(){

    }


    public  void get(){
        ApiInterface apiInterface = HttpService.createService(ApiInterface.class);
        apiInterface.getDepartmentDatas().enqueue(new Callback<DbModel>() {
            @Override
            public void onResponse(Call<DbModel> call, Response<DbModel> response) {
                if (response.isSuccessful()){
                    Log.d("getReq", "onResponse: "+response.body().getData().get(0).getName_of_department());
                }
            }

            @Override
            public void onFailure(Call<DbModel> call, Throwable t) {

            }
        });

    }


}

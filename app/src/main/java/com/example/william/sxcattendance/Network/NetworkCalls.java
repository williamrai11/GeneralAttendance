package com.example.william.sxcattendance.Network;

import android.content.Context;
import android.util.Log;

import com.example.william.sxcattendance.DataBase.Models.DbModel;
import com.example.william.sxcattendance.DataBase.Repo.Repository;
import com.example.william.sxcattendance.DataBase.SqlEntry;
import com.example.william.sxcattendance.Login.Contract;
import com.example.william.sxcattendance.Network.Apis.ApiInterface;
import com.example.william.sxcattendance.Network.RetrofitService.HttpService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkCalls implements Repository.NetworkCalls {

    private SqlEntry sqlEntry;


    public NetworkCalls(Context context){
        sqlEntry = new SqlEntry(context);
    }


    @Override
    public void getDepartmentDatas(final Contract.Model.CallBack callBack) {
        ApiInterface apiInterface = HttpService.createService(ApiInterface.class);
       apiInterface.getDepartmentDatas().enqueue(new Callback<DbModel>() {
           @Override
           public void onResponse(Call<DbModel> call, Response<DbModel> response) {
               if (response.isSuccessful()){
                sqlEntry.addDatas(response.body());
               }
               Log.d("size", "onResponse: "+response.body().getData().get(0).getSemester().size());
                callBack.onSuccessResponse();
           }

           @Override
           public void onFailure(Call<DbModel> call, Throwable t) {
               Log.d("Failure", "onFailure: "+t.getMessage());
           }
       });
    }
}

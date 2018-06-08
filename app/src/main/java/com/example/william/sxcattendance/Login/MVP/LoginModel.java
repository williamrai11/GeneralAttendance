package com.example.william.sxcattendance.Login.MVP;

import android.util.Log;
import android.widget.Toast;

import com.example.william.sxcattendance.Login.Contract;
import com.example.william.sxcattendance.Network.Apis.ApiInterface;
import com.example.william.sxcattendance.Network.Model.loginModel;
import com.example.william.sxcattendance.Network.RetrofitService.HttpService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginModel implements Contract.Model {



    @Override
    public void getCredentials(String email, String password, final CallBack callBack) {

        ApiInterface service = HttpService.createService(ApiInterface.class);
        service.login(email,password).enqueue(new Callback<loginModel>() {
            @Override
            public void onResponse(Call<loginModel> call, Response<loginModel> response) {
               if (response.isSuccessful()) {
                   Log.d("Success", "onResponse: " + response.body().getData().getUser_name());
                   callBack.onSuccess();
               }else {
                   callBack.onCredentialError("User is not registered in the system");
               }
            }

            @Override
            public void onFailure(Call<loginModel> call, Throwable t) {
                Log.d("Failure", "onFailure: "+t.getMessage());


            }
        });

    }
}

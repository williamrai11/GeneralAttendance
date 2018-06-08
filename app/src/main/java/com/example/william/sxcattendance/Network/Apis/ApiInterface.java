package com.example.william.sxcattendance.Network.Apis;



import com.example.william.sxcattendance.DataBase.Models.DbModel;
import com.example.william.sxcattendance.Network.Model.loginModel;
import com.example.william.sxcattendance.Network.Url.UrlManager;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by william on 3/14/18.
 */

public interface ApiInterface {
    @FormUrlEncoded
    @POST(UrlManager.login)
    Call<loginModel> login(@Field("email") String email, @Field("password") String password);


    @GET(UrlManager.DEPARTMENT)
    Call<DbModel> getDepartmentDatas();

}

package com.example.william.sxcattendance.Network;

import android.util.Log;

import com.example.william.sxcattendance.AttendancePage.Contract;
import com.example.william.sxcattendance.AttendancePage.DataModel.StudentsModel;
import com.example.william.sxcattendance.AttendancePage.Util.Helper;
import com.example.william.sxcattendance.Network.Apis.ApiInterface;
import com.example.william.sxcattendance.Network.Model.AttendanceSendModel;
import com.example.william.sxcattendance.Network.RetrofitService.HttpService;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Sender {

    Contract.View view;

    public Sender(Contract.View view){
        this.view = view;
    }

    public void sendAttendanceDetails(List<StudentsModel> studentsModels){

        view.showProgress();
        List<AttendanceSendModel> sender = new ArrayList<>();


        for (int i=0;i<studentsModels.size();i++){

            AttendanceSendModel attendanceSendModel = new AttendanceSendModel(
                    Helper.getDate(),
                    studentsModels.get(i).getAttendance(),
                    studentsModels.get(i).getId(),
                    "hello"
            );

            Log.d("yes", "sendAttendanceDetails: "+studentsModels.get(i).getAttendance());

            sender.add(attendanceSendModel);

        }

        ApiInterface apiInterface = HttpService.createService(ApiInterface.class);
        apiInterface.sendAttendance(sender).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    view.hideProgress();
                    view.showToast("Saved Succesfully");

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("OnSendAttendanceFailure", "onFailure: "+t.getMessage());
            }
        });




    }
}

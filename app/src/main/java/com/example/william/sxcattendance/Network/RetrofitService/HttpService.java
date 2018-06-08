package com.example.william.sxcattendance.Network.RetrofitService;


import com.example.william.sxcattendance.Network.Url.UrlManager;
import com.example.william.sxcattendance.SocketFactory.TLSSocketFactory;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by william on 3/14/18.
 */

public class HttpService {

   private static HttpLoggingInterceptor logger = new HttpLoggingInterceptor()
           .setLevel(HttpLoggingInterceptor.Level.BODY);

   private static OkHttpClient.Builder httpClient;

   static {
      try {
         httpClient = new OkHttpClient.Builder()
                    .connectTimeout(5,TimeUnit.MINUTES)
                    .connectTimeout(5,TimeUnit.MINUTES)
                    .sslSocketFactory(new TLSSocketFactory())
                    .addInterceptor(logger);
      } catch (KeyManagementException e) {
         e.printStackTrace();
      } catch (NoSuchAlgorithmException e) {
         e.printStackTrace();
      } catch (KeyStoreException e) {
         e.printStackTrace();
      }
   }


   private static Retrofit.Builder builder = new Retrofit.Builder()
           .baseUrl(UrlManager.BASE_URL_HOME)
           .addConverterFactory(GsonConverterFactory.create())
           .client(httpClient.build());

   private static Retrofit retrofit = builder.build();

   public static <S> S createService(Class<S> serviceClass){
       return retrofit.create(serviceClass);
   }

}

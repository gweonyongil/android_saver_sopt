package com.sopt.saver.saver.Network;

import com.sopt.saver.saver.Electronics.EItemResult;
import com.sopt.saver.saver.Electronics.EProductResult;
import com.sopt.saver.saver.Electronics.ESellerResult;
import com.sopt.saver.saver.Mydeal.Mydeal_ProductResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


/**
 * Created by pc on 2017-05-14.
 */

public interface NetworkService {
    @GET("/eleclists")
    Call<EItemResult> getElectronicsResult();

    @GET("/eleclists/{id}")
    Call<ESellerResult> getElectronicsSellerResult(@Path("id") String id);

    @GET("/eleclists/{id}")
    Call<EProductResult> getElectronicsProductResult(@Path("id") String id);

    @GET("/eleclist/{id}")
    Call<Mydeal_ProductResult> getMydealProductResult(@Path("id") String id);

}

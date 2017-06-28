package com.sopt.saver.saver.Network;

import com.sopt.saver.saver.Electronics.EItemResult;
import com.sopt.saver.saver.Electronics.EProductResult;
import com.sopt.saver.saver.Electronics.ESellerResult;
import com.sopt.saver.saver.Electronics.UserCheckResult;
import com.sopt.saver.saver.Login.LoginResult;
import com.sopt.saver.saver.Mydeal.Mydeal_ProductResult;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;


/**
 * Created by pc on 2017-05-14.
 */

public interface NetworkService {

    ////////////로그인///////////////////////
    @POST("/login")
    Call<LoginResult> tryLogin(@Part("id") RequestBody id, @Part("password")RequestBody password);
    //////////특정 사용자 권한확인////////////
    @GET("/eleclists/{id}")
    Call<UserCheckResult> getUserCheck(@Path("id") String id);
    ///////////회원가입//////////////////////

    /////////////////////////////////////////
    /////////전체 게시글 조회////////////////
    @GET("/eleclists")
    Call<EItemResult> getElectronicsResult();

    @GET("/brandlists")
    Call<EItemResult> getEBrandResult();

    @GET("/utilizelists")
    Call<EItemResult> getEUtilResult();

    @GET("/etclists")
    Call<EItemResult> getEEtcResult();

    @GET("/smartlists")
    Call<EItemResult> getESmartResult();
    //////////////////////////////////////
    ////////////////특정 게시글 조회/////
    @GET("/eleclists/{id}")
    Call<ESellerResult> getElectronicsSellerResult(@Path("id") String id);

    @GET("/eleclists/{id}")
    Call<EProductResult> getElectronicsProductResult(@Path("id") String id);

    @GET("/brandlists/{id}")
    Call<ESellerResult> getESellerBrandResult(@Path ("id") String id);

    @GET("/brandlists/{id}")
    Call<EProductResult> getEProductBrandResult(@Path ("id") String id);

    @GET("/utilizelists/{id}")
    Call<ESellerResult> getESellerUtilResult(@Path ("id") String id);

    @GET("/utilizelists/{id}")
    Call<EProductResult> getEProductUtilResult(@Path ("id") String id);

    @GET("/smartlists/{id}")
    Call<ESellerResult> getESellerSmartResult(@Path("id") String id);

    @GET("/smartlists/{id}")
    Call<EProductResult> getEProductSmartResult(@Path("id") String id);

    @GET("/etclists/{id}")
    Call<ESellerResult> getESellerEtcResult(@Path("id") String id);

    @GET("/etclists/{id}")
    Call<EProductResult> getEProductEtcResult(@Path("id") String id);
    /////////////////////////나의거래////////////////////////////////////////////
    @GET("/eleclist/{id}")
    Call<Mydeal_ProductResult> getMydealProductResult(@Path("id") String id);
}

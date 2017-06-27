package com.sopt.saver.saver.Network;

import com.sopt.saver.saver.Electronics.Electronics_ItemResult;
import retrofit2.Call;
import retrofit2.http.GET;


/**
 * Created by pc on 2017-05-14.
 */

public interface NetworkService {
    @GET("/lists")
    Call<Electronics_ItemResult> getElectronicsResult();
}

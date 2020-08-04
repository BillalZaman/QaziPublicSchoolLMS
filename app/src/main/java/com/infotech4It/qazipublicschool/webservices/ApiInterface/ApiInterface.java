package com.infotech4It.qazipublicschool.webservices.ApiInterface;

import com.infotech4It.qazipublicschool.webservices.response.Response;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by Bilal Zaman on 03/08/2020.
 */
public interface ApiInterface {
    @POST(Request.LOGIN)
    Observable<Response> login(@Header("Authorization") String authkey, @Body RequestBody loginRequest);

    @POST(Request.GET_BRANCH_LIST)
    Observable<Response> getBranchList(@Header("Authorization") String authKey);

    interface Request {
        String LOGIN = "site/login";
        String GET_BRANCH_LIST = "branch/get-list";
    }
}

package com.infotech4It.qazipublicschool.webservices.ApiInterface;

import com.infotech4It.qazipublicschool.webservices.response.Response;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by Bilal Zaman on 03/08/2020.
 */
public interface ApiInterface {
    @POST(Request.LOGIN)
    Observable<Response> login(@Header("Authorization") String authkey, @Body RequestBody loginRequest);

    interface Request {
        String LOGIN = "login";
    }
}

package com.infotech4It.qazipublicschool.webservices.ApiInterface;

import com.infotech4It.qazipublicschool.webservices.response.Response;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by Bilal Zaman on 03/08/2020.
 */
public interface ApiInterface {
    @POST(Request.LOGIN)
    Observable<Response> login(@Header("Authorization") String authkey, @Body RequestBody loginRequest);

    @POST(Request.GET_BRANCH_LIST)
    Observable<Response> getBranchList(@Header("Authorization") String authKey);

    @POST(Request.GET_SUBJECT_LIST)
    Observable<Response> getStudentSubjectList(@Header("Authorization") String authkey, @Body RequestBody getSubjectListRequest);

    @Multipart
    @POST(Request.GET_SUBJECT_DETAIL)
    Observable<Response> getStudentSubjectDetail(@Header("Authorization") String authkey,
                                                 @Part("user_id") int userId,
                                                 @Part("subject_id") int subjectId);

    @POST(Request.CHANGE_PASSWORD)
    Observable<Response> changePassword(@Header("Authorization") String authkey, @Body RequestBody changePassword);

    @POST(Request.LOGOUT)
    Observable<Response> logout(@Header("Authorization") String authkey, @Body RequestBody getSubjectDetailRequest);

    @POST(Request.GET_NOTICE_BOARD)
    Observable<Response> getNoticeBoard(@Header("Authorization") String authkey, @Body RequestBody getSubjectDetailRequest);

    @POST(Request.GET_USER_PROFILE)
    Observable<Response> getUserProfile(@Header("Authorization") String authkey, @Body RequestBody getSubjectDetailRequest);

    @POST(Request.GET_LESSON_DATA)
    Observable<Response> getLessonData(@Header("Authorization") String authkey, @Body RequestBody getSubjectDetailRequest);

    interface Request {
        String LOGIN = "site/login";
        String GET_BRANCH_LIST = "branch/get-list";
        String GET_SUBJECT_LIST = "subject/get-student-subjects";
        String GET_SUBJECT_DETAIL = "subject/get-subject-data";
        String CHANGE_PASSWORD = "user/change-password";
        String LOGOUT = "site/logout";
        String GET_NOTICE_BOARD = "notice/list";
        String GET_USER_PROFILE = "user/get-profile";
        String GET_LESSON_DATA = "subject/get-lesson";
    }
}

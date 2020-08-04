package com.infotech4It.qazipublicschool.repository;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.infotech4It.qazipublicschool.ApplicationState;
import com.infotech4It.qazipublicschool.helpers.UIHelper;
import com.infotech4It.qazipublicschool.viewModel.ViewModelStatus;
import com.infotech4It.qazipublicschool.webservices.ApiClient;
import com.infotech4It.qazipublicschool.webservices.ApiInterface.ApiInterface;
import com.infotech4It.qazipublicschool.webservices.response.Response;

import org.json.JSONObject;

import java.util.HashMap;

import javax.inject.Inject;

import constants.Constants;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by Bilal Zaman on 04/08/2020.
 */
public class SubjectRepo {
    @Inject
    UIHelper uiHelper;
    Application application;
    MutableLiveData<ViewModelStatus> status;
    ViewModelStatus viewModelStatus;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    Observable<Response> responseObservable;
    MutableLiveData<Response> userProfileLiveDate;
    Response response;

    public SubjectRepo(Application application) {
        this.application = application;
        status = new MutableLiveData<>();
        viewModelStatus = new ViewModelStatus();
        response = new Response();
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
    }

    public MutableLiveData<ViewModelStatus> getStatus() {
        return status;
    }

    public MutableLiveData<Response> getResponseMutableLiveData() {
        return userProfileLiveDate;
    }

    public Observable<Response> getStudentSubjectList(int userId, int pageNo) {
        viewModelStatus.isLoadingList = true;
        status.setValue(viewModelStatus);
        HashMap<String, Object> jsonParms = new HashMap<>();
        jsonParms.put("user_id", userId);
        jsonParms.put("page", pageNo);
        final RequestBody requestBody =
                RequestBody.create(MediaType.get("application/json; charset=utf-8"),
                        (new JSONObject(jsonParms)).toString());
        userProfileLiveDate = new MutableLiveData<>();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        responseObservable = apiInterface.getStudentSubjectList(uiHelper.getAuthKey(), requestBody);
        compositeDisposable.add(responseObservable.subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Response>() {

            @Override
            public void onNext(Response _response) {
                viewModelStatus.isLoadingList = false;
                status.setValue(viewModelStatus);
                response = _response;
                userProfileLiveDate.setValue(response);

            }

            @Override
            public void onError(Throwable e) {
                viewModelStatus.isLoadingList = false;
                status.setValue(viewModelStatus);
                if (response.getCode() == Constants.FAILURE) {
                    uiHelper.showLongToastInCenter(application, e.getMessage());
                } else {
                    uiHelper.showLongToastInCenter(application, e.getMessage());
                }
            }

            @Override
            public void onComplete() {
                userProfileLiveDate.setValue(response);
            }
        }));
        return Observable.just(response);
    }

    public Observable<Response> getStudentSubjectDetail(int userId, int subjectId) {
        viewModelStatus.isLoadingList = true;
        status.setValue(viewModelStatus);
        HashMap<String, Object> jsonParms = new HashMap<>();
        jsonParms.put("user_id", userId);
        jsonParms.put("subject_id", subjectId);
        final RequestBody requestBody =
                RequestBody.create(MediaType.get("application/json; charset=utf-8"),
                        (new JSONObject(jsonParms)).toString());

        userProfileLiveDate = new MutableLiveData<>();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        responseObservable = apiInterface.getStudentSubjectDetail(uiHelper.getAuthKey(), requestBody);
        compositeDisposable.add(responseObservable.subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Response>() {

            @Override
            public void onNext(Response _response) {
                viewModelStatus.isLoadingList = false;
                status.setValue(viewModelStatus);
                response = _response;
                userProfileLiveDate.setValue(response);

            }

            @Override
            public void onError(Throwable e) {
                viewModelStatus.isLoadingList = false;
                status.setValue(viewModelStatus);
                if (response.getCode() == Constants.FAILURE) {
                    uiHelper.showLongToastInCenter(application, e.getMessage());
                } else {
                    uiHelper.showLongToastInCenter(application, e.getMessage());
                }
            }

            @Override
            public void onComplete() {
                userProfileLiveDate.setValue(response);
            }
        }));
        return Observable.just(response);
    }

    public void clear() {
        compositeDisposable.clear();
    }
}

package com.infotech4It.qazipublicschool.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.infotech4It.qazipublicschool.repository.SubjectRepo;
import com.infotech4It.qazipublicschool.webservices.response.Response;

/**
 * Created by Bilal Zaman on 04/08/2020.
 */
public class SubjectViewModel extends AndroidViewModel {
    MutableLiveData<ViewModelStatus> isLoading;
    private SubjectRepo subjectRepo;

    public SubjectViewModel(@NonNull Application application) {
        super(application);
        subjectRepo = new SubjectRepo(application);
    }

    public MutableLiveData<ViewModelStatus> getIsLoading() {
        return isLoading = subjectRepo.getStatus();
    }

    public void getStudentSubjectList(int userId, int pageNo) {
        subjectRepo.getStudentSubjectList(userId, pageNo);
    }

    public void getStudentSubjectDetail(int userId, int subjectID) {
        subjectRepo.getStudentSubjectDetail(userId, subjectID);
    }

    public LiveData<Response> getStudentLogin() {
        return subjectRepo.getResponseMutableLiveData();
    }

    public void clear() {
        subjectRepo.clear();
    }

}

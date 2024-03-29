package com.infotech4It.qazipublicschool.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.infotech4It.qazipublicschool.repository.SubjectivePartRepo;
import com.infotech4It.qazipublicschool.webservices.response.Response;

/**
 * Created by Bilal Zaman on 17/08/2020.
 */

public class SubjectivePartViewModel extends AndroidViewModel {
    MutableLiveData<ViewModelStatus> isLoading;
    private SubjectivePartRepo subjectivePartRepo;

    public SubjectivePartViewModel(@NonNull Application application) {
        super(application);
        subjectivePartRepo = new SubjectivePartRepo(application);
    }

    public MutableLiveData<ViewModelStatus> getIsLoading() {
        return isLoading = subjectivePartRepo.getStatus();
    }

    public void getFillBlanksData(int userId, int testId) {
        subjectivePartRepo.getFillblanksData(userId, testId);
    }

    public LiveData<Response> getStudentLogin() {
        return subjectivePartRepo.getResponseMutableLiveData();
    }

    public void clear() {
        subjectivePartRepo.clear();
    }
}

package com.infotech4It.qazipublicschool.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.infotech4It.qazipublicschool.repository.StudentRepo;
import com.infotech4It.qazipublicschool.webservices.response.Response;

/**
 * Created by Bilal Zaman on 03/08/2020.
 */
public class StudentViewModel extends AndroidViewModel {
    MutableLiveData<ViewModelStatus> isLoading;
    private StudentRepo studentRepo;

    public StudentViewModel(@NonNull Application application) {
        super(application);
        studentRepo = new StudentRepo(application);
    }

    public MutableLiveData<ViewModelStatus> getIsLoading() {
        return isLoading = studentRepo.getStatus();
    }

    public void getStudentLogin(String studentId, String password, String branchId) {
        studentRepo.getUserLogin(studentId, password, branchId);
    }

    public LiveData<Response> getStudentLogin() {
        return studentRepo.getResponseMutableLiveData();
    }

    public void clear() {
        studentRepo.clear();
    }

}

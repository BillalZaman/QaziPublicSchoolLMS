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

    public void changePassword(int userId, String oldPassword, String newPassword, String confirmPassword) {
        studentRepo.changePassword(userId, oldPassword, newPassword, confirmPassword);
    }

    public void logout(int userId) {
        studentRepo.logout(userId);
    }

    public void getNoticeBoard(int userId) {
        studentRepo.noticeBoard(userId);
    }

    public void getUserProfile(int userId) {
        studentRepo.getUserProfile(userId);
    }

    public void getBranchList() {
        studentRepo.getBranchList();
    }

    public LiveData<Response> getStudentLogin() {
        return studentRepo.getResponseMutableLiveData();
    }

    public void clear() {
        studentRepo.clear();
    }

}

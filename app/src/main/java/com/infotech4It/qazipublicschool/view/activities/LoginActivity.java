package com.infotech4It.qazipublicschool.view.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.infotech4It.qazipublicschool.ApplicationState;
import com.infotech4It.qazipublicschool.R;
import com.infotech4It.qazipublicschool.databinding.ActivityLoginBinding;
import com.infotech4It.qazipublicschool.helpers.UIHelper;
import com.infotech4It.qazipublicschool.view.adapters.SpinnerAdapter;
import com.infotech4It.qazipublicschool.viewModel.StudentViewModel;
import com.infotech4It.qazipublicschool.viewModel.ViewModelStatus;
import com.infotech4It.qazipublicschool.webservices.response.Response;

import java.util.ArrayList;

import javax.inject.Inject;

import constants.Constants;

public class LoginActivity extends AppCompatActivity {
    @Inject
    UIHelper uiHelper;
    ProgressDialog loading;
    private ActivityLoginBinding binding;
    private StudentViewModel studentViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        studentViewModel = ViewModelProviders.of(this).get(StudentViewModel.class);

        init();
    }

    private void init() {
        binding.setOnLoginClick(this);
        getLoadingStatus();
        setSpinnerData();
    }

    private void getLoadingStatus() {
        studentViewModel.getIsLoading().observe(this, new Observer<ViewModelStatus>() {
            @Override
            public void onChanged(@Nullable ViewModelStatus viewModelStatus) {
                if (viewModelStatus.isLoadingList) {
                    showLoading();
                } else {
                    hideLoading();
                }
            }
        });
    }

    public void showLoading() {
        loading = ProgressDialog.show(this, getString(R.string.loading), "", true, false);
    }

    public void hideLoading() {
        loading.cancel();
    }

    private void setSpinnerData() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Please Select Branch");
        arrayList.add("Qazi Apex Grammar School (Venus Campus)");
        arrayList.add("Qazi Pilot High School");
        arrayList.add("Qazi Grammer Boys High School");
        arrayList.add("Qazi Girls High School");
        arrayList.add("Qazi Grammar Girls School");
        arrayList.add("Qazi Public Girls School");
        arrayList.add("Qazi Apex Grammar School (Pak Arab Campus)");
        binding.spinnerBranches.setAdapter(new SpinnerAdapter(this, android.R.layout.simple_spinner_item,
                arrayList));
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin: {
                if (validation()) {
                    if (uiHelper.isNetworkAvailable(this)) {
                        studentViewModel.getStudentLogin("Qazian-1423", "humabilal", "19");
                        getLoginUserData();
                    }
                }
            }
        }
    }

    private void getLoginUserData() {
        studentViewModel.getStudentLogin().observe(this, new Observer<Response>() {
            @Override
            public void onChanged(Response response) {
                if (response.getCode() == Constants.SUCCESS_CODE) {
                    uiHelper.showLongToastInCenter(LoginActivity.this, "User Login Successfully");
                    uiHelper.openActivity(LoginActivity.this, MainActivity.class);
                }
            }
        });
    }

    public boolean validation() {
        boolean check = true;

        if (binding.edtComputerID.getText().toString().isEmpty()) {
            binding.edtComputerID.setError(getString(R.string.empty_computerId));
            check = false;

        } else if (binding.edtPassword.getText().toString().isEmpty()) {
            binding.edtPassword.setError(getString(R.string.empty_password));
            check = false;

        }

        return check;
    }
}
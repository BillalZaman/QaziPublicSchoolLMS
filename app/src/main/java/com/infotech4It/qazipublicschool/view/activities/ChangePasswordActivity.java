package com.infotech4It.qazipublicschool.view.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.infotech4It.qazipublicschool.ApplicationState;
import com.infotech4It.qazipublicschool.R;
import com.infotech4It.qazipublicschool.databinding.ActivityChangePasswordBinding;
import com.infotech4It.qazipublicschool.helpers.PreferenceHelper;
import com.infotech4It.qazipublicschool.helpers.UIHelper;
import com.infotech4It.qazipublicschool.viewModel.StudentViewModel;
import com.infotech4It.qazipublicschool.viewModel.ViewModelStatus;
import com.infotech4It.qazipublicschool.webservices.response.Response;

import javax.inject.Inject;

import constants.Constants;

public class ChangePasswordActivity extends AppCompatActivity {
    @Inject
    UIHelper uiHelper;
    ProgressDialog loading;
    private ActivityChangePasswordBinding binding;
    private StudentViewModel studentViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_change_password);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        studentViewModel = ViewModelProviders.of(this).get(StudentViewModel.class);
        init();
    }

    private void init() {
        binding.setOnChangePasswordClick(this);
        getLoadingStatus();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgBack: {
                finish();
            }
            case R.id.btnChangePassword: {
                if (uiHelper.isNetworkAvailable(this)) {
                    if (validation()) {
                        studentViewModel.changePassword(PreferenceHelper.getInstance().getInt(Constants.userInfo, 0),
                                binding.edtOldPassword.getText().toString(),
                                binding.txtNewPassword.getText().toString(),
                                binding.edtConfirmPassword.getText().toString()
                        );
                    }
                }
                getStudentData();
            }
        }
    }

    private void getStudentData() {
        studentViewModel.getStudentLogin().observe(this, new Observer<Response>() {
            @Override
            public void onChanged(Response response) {
                if (response.getCode() == Constants.SUCCESS_CODE) {
                    uiHelper.showLongToastInCenter(ChangePasswordActivity.this, "Password Updated");
                    finish();
                }
            }
        });
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

    public boolean validation() {
        boolean check = true;

        if (binding.edtOldPassword.getText().toString().isEmpty()) {
            binding.edtOldPassword.setError("Old Password field cannot be empty");
            check = false;

        } else if (binding.txtNewPassword.getText().toString().isEmpty()) {
            binding.txtNewPassword.setError("New Password field cannot be empty");
            check = false;

        } else if (binding.edtConfirmPassword.getText().toString().isEmpty()) {
            binding.edtConfirmPassword.setError("Confirm Password field cannot be empty");
            check = false;

        } else if (!binding.txtNewPassword.getText().toString().equals(binding.edtConfirmPassword.getText().toString())) {
            binding.edtConfirmPassword.setError("Password Mismatch");
            check = false;
        }

        return check;
    }

}
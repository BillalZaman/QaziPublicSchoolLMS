package com.infotech4It.qazipublicschool.view.activities;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.infotech4It.qazipublicschool.ApplicationState;
import com.infotech4It.qazipublicschool.R;
import com.infotech4It.qazipublicschool.databinding.ProfileActivityBinding;
import com.infotech4It.qazipublicschool.helpers.PreferenceHelper;
import com.infotech4It.qazipublicschool.helpers.UIHelper;
import com.infotech4It.qazipublicschool.viewModel.StudentViewModel;
import com.infotech4It.qazipublicschool.viewModel.ViewModelStatus;
import com.infotech4It.qazipublicschool.webservices.response.Response;

import javax.inject.Inject;

import constants.Constants;

public class ProfileActivity extends AppCompatActivity {
    @Inject
    UIHelper uiHelper;
    ProgressDialog loading;
    private StudentViewModel studentViewModel;
    private ProfileActivityBinding binding;

    public ProfileActivity() {
        // Required empty public constructor
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.profile_activity);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        studentViewModel = ViewModelProviders.of(this).get(StudentViewModel.class);
        initData();
    }

    private void initData() {
        getLoadingStatus();
        if (uiHelper.isNetworkAvailable(this)) {
            studentViewModel.getUserProfile(PreferenceHelper.getInstance().getInt(Constants.userInfo, 0));
            getProfileData();
        } else {
            uiHelper.showLongToastInCenter(this, getString(R.string.no_internet));
        }
    }

    private void getProfileData() {
        studentViewModel.getStudentLogin().observe(this, new Observer<Response>() {
            @Override
            public void onChanged(Response response) {
                if (response.getCode() == Constants.SUCCESS_CODE) {
                    binding.setOnProfileModel(response.getDataObject().getStudentModel());
                    PreferenceHelper.getInstance().setString(Constants.className,
                            response.getDataObject().getStudentModel().getSection());
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
}
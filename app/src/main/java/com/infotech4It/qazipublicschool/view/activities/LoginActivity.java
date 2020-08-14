package com.infotech4It.qazipublicschool.view.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.infotech4It.qazipublicschool.ApplicationState;
import com.infotech4It.qazipublicschool.R;
import com.infotech4It.qazipublicschool.databinding.ActivityLoginBinding;
import com.infotech4It.qazipublicschool.helpers.PreferenceHelper;
import com.infotech4It.qazipublicschool.helpers.UIHelper;
import com.infotech4It.qazipublicschool.view.adapters.SpinnerAdapter;
import com.infotech4It.qazipublicschool.view.models.BranchModel;
import com.infotech4It.qazipublicschool.view.models.StudentModel;
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
    private String branch_id;

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
//        ArrayList<String> arrayList = new ArrayList<>();
//        arrayList.add("Please Select Branch");
//        arrayList.add("Qazi Apex Grammar School (Venus Campus)");
//        arrayList.add("Qazi Pilot High School");
//        arrayList.add("Qazi Grammer Boys High School");
//        arrayList.add("Qazi Girls High School");
//        arrayList.add("Qazi Grammar Girls School");
//        arrayList.add("Qazi Public Girls School");
//        arrayList.add("Qazi Apex Grammar School (Pak Arab Campus)");
//        binding.spinnerBranches.setAdapter(new SpinnerAdapter(this, android.R.layout.simple_spinner_item,
//                arrayList));


    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin: {
                if (validation()) {
                    if (uiHelper.isNetworkAvailable(this)) {
                        studentViewModel.getStudentLogin(binding.edtComputerID.getText().toString()
                                , binding.edtPassword.getText().toString(), branch_id);
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
                    PreferenceHelper.getInstance().setBol(Constants.IS_OPON_FIRST_TIME, true);

                    if (response.getDataObject().getBranchModelList() != null) {
                        ArrayList<BranchModel> arrayList = new ArrayList<>();
                        arrayList = (ArrayList<BranchModel>) response.getDataObject().getBranchModelList();
                        binding.spinnerBranches.setAdapter(new SpinnerAdapter(LoginActivity.this,
                                android.R.layout.simple_spinner_item,
                                arrayList));

                        final ArrayList<BranchModel> finalArrayList = arrayList;
                        binding.spinnerBranches.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                branch_id = String.valueOf(finalArrayList.get(position).getId());
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                    } else if (response.getDataObject().getStudentModel() != null) {
                        StudentModel studentModel = new StudentModel();
                        studentModel = response.getDataObject().getStudentModel();
                        PreferenceHelper.getInstance().setString(Constants.isLogin, Constants.yes);
                        PreferenceHelper.getInstance().setInt(Constants.userInfo, studentModel.getId());
                        PreferenceHelper.getInstance().setString(Constants.userName, studentModel.getClientName());
                        PreferenceHelper.getInstance().setString(Constants.userFather, studentModel.getFatherName());
                        uiHelper.showLongToastInCenter(LoginActivity.this, "User Login Successfully"+ response.getMessage());
                        uiHelper.openActivity(LoginActivity.this, MainActivity.class);
                    }
                }
            }
        });
    }

    public boolean validation() {
        boolean check = true;

        if (branch_id.equalsIgnoreCase("0")) {
            uiHelper.showLongToastInCenter(LoginActivity.this, "Please Select the branch");
            check = false;

        } else if (binding.edtComputerID.getText().toString().isEmpty()) {
            binding.edtComputerID.setError(getString(R.string.empty_computerId));
            check = false;

        } else if (binding.edtPassword.getText().toString().isEmpty()) {
            binding.edtPassword.setError(getString(R.string.empty_password));
            check = false;

        }

        return check;
    }

    @Override
    protected void onResume() {
        super.onResume();
        studentViewModel.getBranchList();
        getLoginUserData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        studentViewModel.clear();
    }
}
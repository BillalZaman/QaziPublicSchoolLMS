package com.infotech4It.qazipublicschool.view.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.infotech4It.qazipublicschool.ApplicationState;
import com.infotech4It.qazipublicschool.R;
import com.infotech4It.qazipublicschool.databinding.ActivityMainBinding;
import com.infotech4It.qazipublicschool.fragments.MoreFragment;
import com.infotech4It.qazipublicschool.fragments.NoticeBoardFragment;
import com.infotech4It.qazipublicschool.fragments.ProfileFragment;
import com.infotech4It.qazipublicschool.fragments.SubjectFragment;
import com.infotech4It.qazipublicschool.helpers.PreferenceHelper;
import com.infotech4It.qazipublicschool.helpers.SpecialSharedPrefHelper;
import com.infotech4It.qazipublicschool.helpers.UIHelper;
import com.infotech4It.qazipublicschool.interfaces.LogoutInterface;
import com.infotech4It.qazipublicschool.interfaces.SubjectListInterface;
import com.infotech4It.qazipublicschool.viewModel.StudentViewModel;
import com.infotech4It.qazipublicschool.viewModel.ViewModelStatus;
import com.infotech4It.qazipublicschool.webservices.response.Response;

import javax.inject.Inject;

import constants.Constants;

public class MainActivity extends AppCompatActivity implements SubjectListInterface, LogoutInterface {
    @Inject
    UIHelper uiHelper;
    ProgressDialog loading;
    private ActivityMainBinding binding;
    private StudentViewModel studentViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        studentViewModel = ViewModelProviders.of(this).get(StudentViewModel.class);
        SubjectFragment subjectFragment = new SubjectFragment();
        uiHelper.replaceFragment(MainActivity.this, R.id.frameLayout, subjectFragment);

        init();
    }

    private void init() {
//        getLoadingStatus();

        binding.bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_home: {
                        SubjectFragment subjectFragment = new SubjectFragment();
                        uiHelper.replaceFragment(MainActivity.this, R.id.frameLayout, subjectFragment);
                        return true;
                    }
                    case R.id.navigation_profile: {
                        ProfileFragment profileFragment = new ProfileFragment();
                        uiHelper.replaceFragment(MainActivity.this, R.id.frameLayout, profileFragment);
                        return true;
                    }
                    case R.id.navigation_notifications: {
                        NoticeBoardFragment noticeBoardFragment = new NoticeBoardFragment();
                        uiHelper.replaceFragment(MainActivity.this, R.id.frameLayout, noticeBoardFragment);
                        return true;
                    }
                    case R.id.navigation_more: {
                        MoreFragment moreFragment = new MoreFragment();
                        uiHelper.replaceFragment(MainActivity.this, R.id.frameLayout, moreFragment);
                        return true;
                    }
                }
                return false;
            }
        });
    }

    @Override
    public void onSubjectList(int position, String lessonName) {
        uiHelper.openActivity(this, ReleatedSubjectListActivity.class);
    }

    @Override
    public void onLogout(String logout) {
        if (logout.equalsIgnoreCase("logout")) {
            studentViewModel.logout(PreferenceHelper.getInstance().getInt(Constants.userInfo, 0));
            SpecialSharedPrefHelper.getInstance().removePreference(Constants.userInfo);
            PreferenceHelper.getInstance().setString(Constants.isLogin, Constants.no);
            uiHelper.openAndClearActivity(MainActivity.this, LoginActivity.class);
        } else {
            finish();
        }
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        studentViewModel.clear();
    }
}
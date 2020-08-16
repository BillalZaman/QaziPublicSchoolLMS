package com.infotech4It.qazipublicschool.view.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.infotech4It.qazipublicschool.ApplicationState;
import com.infotech4It.qazipublicschool.R;
import com.infotech4It.qazipublicschool.databinding.ActivityMainBinding;
import com.infotech4It.qazipublicschool.dialogs.LogoutFragmentDialog;
import com.infotech4It.qazipublicschool.fragments.FragmentNavigationDrawer;
import com.infotech4It.qazipublicschool.fragments.SubjectFragment;
import com.infotech4It.qazipublicschool.helpers.PreferenceHelper;
import com.infotech4It.qazipublicschool.helpers.SpecialSharedPrefHelper;
import com.infotech4It.qazipublicschool.helpers.UIHelper;
import com.infotech4It.qazipublicschool.interfaces.LogoutInterface;
import com.infotech4It.qazipublicschool.interfaces.SubjectListInterface;
import com.infotech4It.qazipublicschool.viewModel.StudentViewModel;
import com.infotech4It.qazipublicschool.viewModel.ViewModelStatus;

import javax.inject.Inject;

import constants.Constants;

public class MainActivity extends AppCompatActivity implements SubjectListInterface, LogoutInterface,
        FragmentNavigationDrawer.FragmentDrawerListener {
    @Inject
    UIHelper uiHelper;
    ProgressDialog loading;
    LogoutFragmentDialog logoutFragmentDialog = new LogoutFragmentDialog();
    private ActivityMainBinding binding;
    private StudentViewModel studentViewModel;
    private FragmentNavigationDrawer fragmentNavigationDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        studentViewModel = ViewModelProviders.of(this).get(StudentViewModel.class);

        init();
    }

    private void init() {
//        getLoadingStatus();
        fragmentNavigationDrawer = (FragmentNavigationDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        fragmentNavigationDrawer.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout));
        fragmentNavigationDrawer.setDrawerListener((FragmentNavigationDrawer.FragmentDrawerListener) this);
        displayPosition(0);

//        binding.bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                switch (menuItem.getItemId()) {
//                    case R.id.navigation_home: {
//                        SubjectFragment subjectFragment = new SubjectFragment();
//                        uiHelper.replaceFragment(MainActivity.this, R.id.frameLayout, subjectFragment);
//                        return true;
//                    }
//                    case R.id.navigation_profile: {
//                        ProfileFragment profileFragment = new ProfileFragment();
//                        uiHelper.replaceFragment(MainActivity.this, R.id.frameLayout, profileFragment);
//                        return true;
//                    }
//                    case R.id.navigation_notifications: {
//                        NoticeBoardFragment noticeBoardFragment = new NoticeBoardFragment();
//                        uiHelper.replaceFragment(MainActivity.this, R.id.frameLayout, noticeBoardFragment);
//                        return true;
//                    }
//                    case R.id.navigation_more: {
//                        MoreFragment moreFragment = new MoreFragment();
//                        uiHelper.replaceFragment(MainActivity.this, R.id.frameLayout, moreFragment);
//                        return true;
//                    }
//                }
//                return false;
//            }
//        });

        binding.navigationIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.drawerLayout.openDrawer(GravityCompat.START);
            }
        });

    }

    private void showHomeFragment() {
        SubjectFragment subjectFragment = new SubjectFragment();
        uiHelper.replaceFragment(MainActivity.this, R.id.frameLayout, subjectFragment);
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

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayPosition(position);
    }

    private void displayPosition(int position) {
        switch (position) {
            case 0: {
                showHomeFragment();
                break;
            }
            case 1: {
                uiHelper.openActivity(this, NoticeBoardActivity.class);
                binding.drawerLayout.closeDrawer(GravityCompat.START);
                break;
            }
            case 2: {
                uiHelper.openActivity(this, ChangePasswordActivity.class);
                binding.drawerLayout.closeDrawer(GravityCompat.START);
                break;
            }
            case 3: {
                uiHelper.replaceFragment(this, R.id.frameLayout, logoutFragmentDialog);
                binding.drawerLayout.closeDrawer(GravityCompat.START);
                break;
            }
            case 4: {

                binding.drawerLayout.closeDrawer(GravityCompat.START);
                break;
            }
            case 5: {

                binding.drawerLayout.closeDrawer(GravityCompat.START);
                break;
            }
            default: {
                break;
            }
        }
    }
}
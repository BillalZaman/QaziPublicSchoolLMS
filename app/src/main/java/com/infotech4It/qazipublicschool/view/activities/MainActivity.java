package com.infotech4It.qazipublicschool.view.activities;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.infotech4It.qazipublicschool.ApplicationState;
import com.infotech4It.qazipublicschool.R;
import com.infotech4It.qazipublicschool.databinding.ActivityMainBinding;
import com.infotech4It.qazipublicschool.fragments.MoreFragment;
import com.infotech4It.qazipublicschool.fragments.NoticeBoardFragment;
import com.infotech4It.qazipublicschool.fragments.ProfileFragment;
import com.infotech4It.qazipublicschool.fragments.SubjectFragment;
import com.infotech4It.qazipublicschool.helpers.UIHelper;
import com.infotech4It.qazipublicschool.interfaces.SubjectListInterface;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements SubjectListInterface {
    @Inject
    UIHelper uiHelper;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);

        SubjectFragment subjectFragment = new SubjectFragment();
        uiHelper.replaceFragment(MainActivity.this, R.id.frameLayout, subjectFragment);

        init();
    }

    private void init() {
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
}
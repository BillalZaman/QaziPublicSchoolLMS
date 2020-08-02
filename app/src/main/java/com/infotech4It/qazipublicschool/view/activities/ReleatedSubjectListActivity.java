package com.infotech4It.qazipublicschool.view.activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.infotech4It.qazipublicschool.ApplicationState;
import com.infotech4It.qazipublicschool.R;
import com.infotech4It.qazipublicschool.databinding.ActivityReleatedSubjectListBinding;
import com.infotech4It.qazipublicschool.fragments.AllAssessmentsFragment;
import com.infotech4It.qazipublicschool.fragments.AllLessonsFragment;
import com.infotech4It.qazipublicschool.fragments.RecentAssessmentsFragment;
import com.infotech4It.qazipublicschool.fragments.RecentLessonsFragment;
import com.infotech4It.qazipublicschool.helpers.UIHelper;

import javax.inject.Inject;

public class ReleatedSubjectListActivity extends AppCompatActivity {
    @Inject
    UIHelper uiHelper;
    private ActivityReleatedSubjectListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_releated_subject_list);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        initData();
    }

    private void initData() {
        binding.setOnRelatedTabClick(this);
        RecentLessonsFragment recentLessonsFragment = new RecentLessonsFragment();
        uiHelper.replaceFragment(this, R.id.framelayout, recentLessonsFragment);
        binding.tabRecentLessons.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        binding.tabRecentLessons.setTextColor(getResources().getColor(R.color.colorWhite));
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tab_recent_lessons: {
                RecentLessonsFragment recentLessonsFragment = new RecentLessonsFragment();
                uiHelper.replaceFragment(this, R.id.framelayout, recentLessonsFragment);
                binding.tabRecentLessons.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                binding.tabRecentLessons.setTextColor(getResources().getColor(R.color.colorWhite));
                resetAllColorPreferences(1);
                break;
            }
            case R.id.tab_all_lessons: {
                AllLessonsFragment allLessonsFragment = new AllLessonsFragment();
                uiHelper.replaceFragment(this, R.id.framelayout, allLessonsFragment);
                binding.tabAllLessons.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                binding.tabAllLessons.setTextColor(getResources().getColor(R.color.colorWhite));
                resetAllColorPreferences(2);
                break;
            }
            case R.id.tab_recent_assessment: {
                RecentAssessmentsFragment recentAssessmentsFragment = new RecentAssessmentsFragment();
                uiHelper.replaceFragment(this, R.id.framelayout, recentAssessmentsFragment);
                binding.tabRecentAssessment.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                binding.tabRecentAssessment.setTextColor(getResources().getColor(R.color.colorWhite));
                resetAllColorPreferences(3);
                break;
            }
            case R.id.tab_all_assessments: {
                AllAssessmentsFragment allAssessmentsFragment = new AllAssessmentsFragment();
                uiHelper.replaceFragment(this, R.id.framelayout, allAssessmentsFragment);
                binding.tabAllAssessments.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                binding.tabAllAssessments.setTextColor(getResources().getColor(R.color.colorWhite));
                resetAllColorPreferences(4);
                break;
            }
            case R.id.imgBack: {
                finish();
            }
        }
    }

    public void resetAllColorPreferences(int tabPosition){
        if (tabPosition == 1){
//            binding.tabRecentLessons.setBackgroundColor(getResources().getColor(R.color.colorWhite));
//            binding.tabRecentLessons.setTextColor(getResources().getColor(R.color.colorDark));

            binding.tabAllLessons.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            binding.tabAllLessons.setTextColor(getResources().getColor(R.color.colorDark));

            binding.tabRecentAssessment.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            binding.tabRecentAssessment.setTextColor(getResources().getColor(R.color.colorDark));

            binding.tabAllAssessments.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            binding.tabAllAssessments.setTextColor(getResources().getColor(R.color.colorDark));

        } else if (tabPosition == 2){
            binding.tabRecentLessons.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            binding.tabRecentLessons.setTextColor(getResources().getColor(R.color.colorDark));

//            binding.tabAllLessons.setBackgroundColor(getResources().getColor(R.color.colorWhite));
//            binding.tabAllLessons.setTextColor(getResources().getColor(R.color.colorDark));

            binding.tabRecentAssessment.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            binding.tabRecentAssessment.setTextColor(getResources().getColor(R.color.colorDark));

            binding.tabAllAssessments.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            binding.tabAllAssessments.setTextColor(getResources().getColor(R.color.colorDark));
        } else if (tabPosition == 3){
            binding.tabRecentLessons.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            binding.tabRecentLessons.setTextColor(getResources().getColor(R.color.colorDark));

            binding.tabAllLessons.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            binding.tabAllLessons.setTextColor(getResources().getColor(R.color.colorDark));

//            binding.tabRecentAssessment.setBackgroundColor(getResources().getColor(R.color.colorWhite));
//            binding.tabRecentAssessment.setTextColor(getResources().getColor(R.color.colorDark));

            binding.tabAllAssessments.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            binding.tabAllAssessments.setTextColor(getResources().getColor(R.color.colorDark));
        } else if (tabPosition == 4){
            binding.tabRecentLessons.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            binding.tabRecentLessons.setTextColor(getResources().getColor(R.color.colorDark));

            binding.tabAllLessons.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            binding.tabAllLessons.setTextColor(getResources().getColor(R.color.colorDark));

            binding.tabRecentAssessment.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            binding.tabRecentAssessment.setTextColor(getResources().getColor(R.color.colorDark));

//            binding.tabAllAssessments.setBackgroundColor(getResources().getColor(R.color.colorWhite));
//            binding.tabAllAssessments.setTextColor(getResources().getColor(R.color.colorDark));
        }
    }
}
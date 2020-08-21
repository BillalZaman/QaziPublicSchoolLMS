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
import com.infotech4It.qazipublicschool.helpers.PreferenceHelper;
import com.infotech4It.qazipublicschool.helpers.UIHelper;

import javax.inject.Inject;

import constants.Constants;

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
        binding.textView2.setText(PreferenceHelper.getInstance().getString(Constants.subjectName,""));
        RecentLessonsFragment recentLessonsFragment = new RecentLessonsFragment();
        uiHelper.replaceFragment(this, R.id.framelayout, recentLessonsFragment);
        binding.tabRecentLessons.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        binding.tabRecentLessons.setTextColor(getResources().getColor(R.color.colorWhite));
        binding.imgRecentLesson.setImageResource(R.drawable.lessonswhite);
        binding.imgRecentLesson.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgRecentLesson:
            case R.id.tab_recent_lessons: {
                RecentLessonsFragment recentLessonsFragment = new RecentLessonsFragment();
                uiHelper.replaceFragment(this, R.id.framelayout, recentLessonsFragment);
                binding.tabRecentLessons.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                binding.tabRecentLessons.setTextColor(getResources().getColor(R.color.colorWhite));
                binding.imgRecentLesson.setImageResource(R.drawable.lessonswhite);
                binding.imgRecentLesson.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                resetAllColorPreferences(1);
                break;
            }
            case R.id.imgAllLesson:
            case R.id.tab_all_lessons: {
                AllLessonsFragment allLessonsFragment = new AllLessonsFragment();
                uiHelper.replaceFragment(this, R.id.framelayout, allLessonsFragment);
                binding.tabAllLessons.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                binding.tabAllLessons.setTextColor(getResources().getColor(R.color.colorWhite));
                binding.imgAllLesson.setImageResource(R.drawable.alllessonswhite);
                binding.imgAllLesson.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                resetAllColorPreferences(2);
                break;
            }
            case R.id.imgRecentAssessment:
            case R.id.tab_recent_assessment: {
                RecentAssessmentsFragment recentAssessmentsFragment = new RecentAssessmentsFragment();
                uiHelper.replaceFragment(this, R.id.framelayout, recentAssessmentsFragment);
                binding.tabRecentAssessment.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                binding.tabRecentAssessment.setTextColor(getResources().getColor(R.color.colorWhite));
                binding.imgRecentAssessment.setImageResource(R.drawable.recentaccessmentwhite);
                binding.imgRecentAssessment.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                resetAllColorPreferences(3);
                break;
            }
            case R.id.imgAllAssessment:
            case R.id.tab_all_assessments: {
                AllAssessmentsFragment allAssessmentsFragment = new AllAssessmentsFragment();
                uiHelper.replaceFragment(this, R.id.framelayout, allAssessmentsFragment);
                binding.tabAllAssessments.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                binding.tabAllAssessments.setTextColor(getResources().getColor(R.color.colorWhite));
                binding.imgAllAssessment.setImageResource(R.drawable.asessmentallwhite);
                binding.imgAllAssessment.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                resetAllColorPreferences(4);
                break;
            }
            case R.id.imgBack: {
                finish();
            }
        }
    }

    public void resetAllColorPreferences(int tabPosition) {
        if (tabPosition == 1) {
//            binding.tabRecentLessons.setBackgroundColor(getResources().getColor(R.color.colorWhite));
//            binding.tabRecentLessons.setTextColor(getResources().getColor(R.color.colorDark));

            binding.tabAllLessons.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            binding.tabAllLessons.setTextColor(getResources().getColor(R.color.colorDark));
            binding.imgAllLesson.setImageResource(R.drawable.alllessonsblack);
            binding.imgAllLesson.setBackgroundColor(getResources().getColor(R.color.colorWhite));

            binding.tabRecentAssessment.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            binding.tabRecentAssessment.setTextColor(getResources().getColor(R.color.colorDark));
            binding.imgRecentAssessment.setImageResource(R.drawable.recentassessment);
            binding.imgRecentAssessment.setBackgroundColor(getResources().getColor(R.color.colorWhite));

            binding.tabAllAssessments.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            binding.tabAllAssessments.setTextColor(getResources().getColor(R.color.colorDark));
            binding.imgAllAssessment.setImageResource(R.drawable.assessmentallblack);
            binding.imgAllAssessment.setBackgroundColor(getResources().getColor(R.color.colorWhite));

        } else if (tabPosition == 2) {
            binding.tabRecentLessons.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            binding.tabRecentLessons.setTextColor(getResources().getColor(R.color.colorDark));
            binding.imgRecentLesson.setImageResource(R.drawable.recentassessment);
            binding.imgRecentLesson.setBackgroundColor(getResources().getColor(R.color.colorWhite));
//            binding.tabAllLessons.setBackgroundColor(getResources().getColor(R.color.colorWhite));
//            binding.tabAllLessons.setTextColor(getResources().getColor(R.color.colorDark));

            binding.tabRecentAssessment.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            binding.tabRecentAssessment.setTextColor(getResources().getColor(R.color.colorDark));
            binding.imgRecentAssessment.setImageResource(R.drawable.recentassessment);
            binding.imgRecentAssessment.setBackgroundColor(getResources().getColor(R.color.colorWhite));

            binding.tabAllAssessments.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            binding.tabAllAssessments.setTextColor(getResources().getColor(R.color.colorDark));
            binding.imgAllAssessment.setImageResource(R.drawable.assessmentallblack);
            binding.imgAllAssessment.setBackgroundColor(getResources().getColor(R.color.colorWhite));

        } else if (tabPosition == 3) {
            binding.tabRecentLessons.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            binding.tabRecentLessons.setTextColor(getResources().getColor(R.color.colorDark));
            binding.imgRecentLesson.setImageResource(R.drawable.recentassessment);
            binding.imgRecentLesson.setBackgroundColor(getResources().getColor(R.color.colorWhite));

            binding.tabAllLessons.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            binding.tabAllLessons.setTextColor(getResources().getColor(R.color.colorDark));
            binding.imgAllLesson.setImageResource(R.drawable.alllessonsblack);
            binding.imgAllLesson.setBackgroundColor(getResources().getColor(R.color.colorWhite));

//            binding.tabRecentAssessment.setBackgroundColor(getResources().getColor(R.color.colorWhite));
//            binding.tabRecentAssessment.setTextColor(getResources().getColor(R.color.colorDark));

            binding.tabAllAssessments.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            binding.tabAllAssessments.setTextColor(getResources().getColor(R.color.colorDark));
            binding.imgAllAssessment.setImageResource(R.drawable.assessmentallblack);
            binding.imgAllAssessment.setBackgroundColor(getResources().getColor(R.color.colorWhite));

        } else if (tabPosition == 4) {
            binding.tabRecentLessons.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            binding.tabRecentLessons.setTextColor(getResources().getColor(R.color.colorDark));
            binding.imgRecentLesson.setImageResource(R.drawable.recentassessment);
            binding.imgRecentLesson.setBackgroundColor(getResources().getColor(R.color.colorWhite));

            binding.tabAllLessons.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            binding.tabAllLessons.setTextColor(getResources().getColor(R.color.colorDark));
            binding.imgAllLesson.setImageResource(R.drawable.alllessonsblack);
            binding.imgAllLesson.setBackgroundColor(getResources().getColor(R.color.colorWhite));

            binding.tabRecentAssessment.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            binding.tabRecentAssessment.setTextColor(getResources().getColor(R.color.colorDark));
            binding.imgRecentAssessment.setImageResource(R.drawable.recentassessment);
            binding.imgRecentAssessment.setBackgroundColor(getResources().getColor(R.color.colorWhite));

//            binding.tabAllAssessments.setBackgroundColor(getResources().getColor(R.color.colorWhite));
//            binding.tabAllAssessments.setTextColor(getResources().getColor(R.color.colorDark));
        }
    }
}
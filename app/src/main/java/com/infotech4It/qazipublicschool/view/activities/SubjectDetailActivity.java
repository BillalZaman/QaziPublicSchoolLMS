package com.infotech4It.qazipublicschool.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.infotech4It.qazipublicschool.ApplicationState;
import com.infotech4It.qazipublicschool.R;
import com.infotech4It.qazipublicschool.databinding.ActivityReleatedSubjectListBinding;
import com.infotech4It.qazipublicschool.databinding.ActivitySubjectDetailBinding;
import com.infotech4It.qazipublicschool.fragments.AllAssessmentsFragment;
import com.infotech4It.qazipublicschool.fragments.AllLessonsFragment;
import com.infotech4It.qazipublicschool.fragments.CommentFragment;
import com.infotech4It.qazipublicschool.fragments.HomeWorkFragment;
import com.infotech4It.qazipublicschool.fragments.ImageFragment;
import com.infotech4It.qazipublicschool.fragments.RecentAssessmentsFragment;
import com.infotech4It.qazipublicschool.fragments.RecentLessonsFragment;
import com.infotech4It.qazipublicschool.fragments.TodoListFragment;
import com.infotech4It.qazipublicschool.fragments.VideoFragment;
import com.infotech4It.qazipublicschool.helpers.UIHelper;

import javax.inject.Inject;

public class SubjectDetailActivity extends AppCompatActivity {
    @Inject
    UIHelper uiHelper;
    private ActivitySubjectDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_subject_detail);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        initData();
    }

    private void initData() {
        binding.setOnRelatedTabClick(this);
        VideoFragment videoFragment = new VideoFragment();
        uiHelper.replaceFragment(this, R.id.framelayout, videoFragment);
        binding.tabRecentLessons.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        binding.tabRecentLessons.setTextColor(getResources().getColor(R.color.colorWhite));
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tab_recent_lessons: {
                VideoFragment videoFragment = new VideoFragment();
                uiHelper.replaceFragment(this, R.id.framelayout, videoFragment);
                binding.tabRecentLessons.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                binding.tabRecentLessons.setTextColor(getResources().getColor(R.color.colorWhite));
                resetAllColorPreferences(1);
                break;
            }
            case R.id.tab_all_lessons: {
                ImageFragment imageFragment = new ImageFragment();
                uiHelper.replaceFragment(this, R.id.framelayout, imageFragment);
                binding.tabAllLessons.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                binding.tabAllLessons.setTextColor(getResources().getColor(R.color.colorWhite));
                resetAllColorPreferences(2);
                break;
            }
            case R.id.tab_recent_assessment: {
                TodoListFragment recentAssessmentsFragment = new TodoListFragment();
                uiHelper.replaceFragment(this, R.id.framelayout, recentAssessmentsFragment);
                binding.tabRecentAssessment.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                binding.tabRecentAssessment.setTextColor(getResources().getColor(R.color.colorWhite));
                resetAllColorPreferences(3);
                break;
            }
            case R.id.tab_all_assessments: {
                HomeWorkFragment allAssessmentsFragment = new HomeWorkFragment();
                uiHelper.replaceFragment(this, R.id.framelayout, allAssessmentsFragment);
                binding.tabAllAssessments.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                binding.tabAllAssessments.setTextColor(getResources().getColor(R.color.colorWhite));
                resetAllColorPreferences(4);
                break;
            }
            case R.id.tab_comment: {
                CommentFragment commentFragment = new CommentFragment();
                uiHelper.replaceFragment(this, R.id.framelayout, commentFragment);
                binding.tabComment.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                binding.tabComment.setTextColor(getResources().getColor(R.color.colorWhite));
                resetAllColorPreferences(5);
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

            binding.tabComment.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            binding.tabComment.setTextColor(getResources().getColor(R.color.colorDark));

        } else if (tabPosition == 2){
            binding.tabRecentLessons.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            binding.tabRecentLessons.setTextColor(getResources().getColor(R.color.colorDark));

//            binding.tabAllLessons.setBackgroundColor(getResources().getColor(R.color.colorWhite));
//            binding.tabAllLessons.setTextColor(getResources().getColor(R.color.colorDark));

            binding.tabRecentAssessment.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            binding.tabRecentAssessment.setTextColor(getResources().getColor(R.color.colorDark));

            binding.tabAllAssessments.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            binding.tabAllAssessments.setTextColor(getResources().getColor(R.color.colorDark));

            binding.tabComment.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            binding.tabComment.setTextColor(getResources().getColor(R.color.colorDark));

        } else if (tabPosition == 3){
            binding.tabRecentLessons.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            binding.tabRecentLessons.setTextColor(getResources().getColor(R.color.colorDark));

            binding.tabAllLessons.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            binding.tabAllLessons.setTextColor(getResources().getColor(R.color.colorDark));

//            binding.tabRecentAssessment.setBackgroundColor(getResources().getColor(R.color.colorWhite));
//            binding.tabRecentAssessment.setTextColor(getResources().getColor(R.color.colorDark));

            binding.tabAllAssessments.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            binding.tabAllAssessments.setTextColor(getResources().getColor(R.color.colorDark));

            binding.tabComment.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            binding.tabComment.setTextColor(getResources().getColor(R.color.colorDark));

        } else if (tabPosition == 4){
            binding.tabRecentLessons.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            binding.tabRecentLessons.setTextColor(getResources().getColor(R.color.colorDark));

            binding.tabAllLessons.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            binding.tabAllLessons.setTextColor(getResources().getColor(R.color.colorDark));

            binding.tabRecentAssessment.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            binding.tabRecentAssessment.setTextColor(getResources().getColor(R.color.colorDark));

//            binding.tabAllAssessments.setBackgroundColor(getResources().getColor(R.color.colorWhite));
//            binding.tabAllAssessments.setTextColor(getResources().getColor(R.color.colorDark));

            binding.tabComment.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            binding.tabComment.setTextColor(getResources().getColor(R.color.colorDark));
        }

        else if (tabPosition == 5){
            binding.tabRecentLessons.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            binding.tabRecentLessons.setTextColor(getResources().getColor(R.color.colorDark));

            binding.tabAllLessons.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            binding.tabAllLessons.setTextColor(getResources().getColor(R.color.colorDark));

            binding.tabRecentAssessment.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            binding.tabRecentAssessment.setTextColor(getResources().getColor(R.color.colorDark));

            binding.tabAllAssessments.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            binding.tabAllAssessments.setTextColor(getResources().getColor(R.color.colorDark));

            binding.tabComment.setBackgroundColor(getResources().getColor(R.color.colorDark));
            binding.tabComment.setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }
}
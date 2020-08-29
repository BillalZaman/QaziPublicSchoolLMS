package com.infotech4It.qazipublicschool.view.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.infotech4It.qazipublicschool.R;
import com.infotech4It.qazipublicschool.databinding.ActivityStudentAssessmentBinding;
import com.infotech4It.qazipublicschool.fragments.MCQSFragment;
import com.infotech4It.qazipublicschool.fragments.QuestionAnswerFragment;
import com.infotech4It.qazipublicschool.interfaces.PickingAnswerInterface;

import java.util.ArrayList;
import java.util.List;

public class StudentAssessmentActivity extends AppCompatActivity implements PickingAnswerInterface {
    private ActivityStudentAssessmentBinding binding;
    MCQSFragment mcqsFragment = new MCQSFragment();
    QuestionAnswerFragment questionAnswerFragment = new QuestionAnswerFragment();
    private int[] tabIcons = {
            R.drawable.ic_msg_send,
            R.drawable.ic_msg_send
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_student_assessment);

        initData();
    }

    private void initData() {
        setupViewPager(binding.viewpager);
        binding.tabs.setupWithViewPager(binding.viewpager);
        setupTabIcons();
    }

    private void setupTabIcons() {
        binding.tabs.getTabAt(0);
        binding.tabs.getTabAt(1);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(mcqsFragment, "Mcqs");
        adapter.addFrag(questionAnswerFragment, "Fill in the Blanks");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void pickingAnswer(int questionID, String answer) {
        mcqsFragment.setData(questionID,answer);
        questionAnswerFragment.setData(questionID,answer);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
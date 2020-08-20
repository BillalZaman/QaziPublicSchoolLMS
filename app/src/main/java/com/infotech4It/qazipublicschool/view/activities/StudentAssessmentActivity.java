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

import java.util.ArrayList;
import java.util.List;

public class StudentAssessmentActivity extends AppCompatActivity {
    private ActivityStudentAssessmentBinding binding;
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
        binding.tabs.getTabAt(0).setIcon(tabIcons[0]);
        binding.tabs.getTabAt(1).setIcon(tabIcons[1]);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new MCQSFragment(), "Mcqs");
        adapter.addFrag(new QuestionAnswerFragment(), "Fill in the Blanks");
        viewPager.setAdapter(adapter);
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
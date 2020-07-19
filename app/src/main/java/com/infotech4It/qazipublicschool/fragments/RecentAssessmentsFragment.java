package com.infotech4It.qazipublicschool.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.infotech4It.qazipublicschool.R;
import com.infotech4It.qazipublicschool.databinding.FragmentRecentAssessmentsBinding;
import com.infotech4It.qazipublicschool.view.adapters.RecentAssessmentAdapter;
import com.infotech4It.qazipublicschool.view.adapters.RecentLessonAdapter;
import com.infotech4It.qazipublicschool.view.models.RecentAssessmentModel;
import com.infotech4It.qazipublicschool.view.models.RecentLessonModel;

import java.util.ArrayList;

public class RecentAssessmentsFragment extends Fragment {
    private FragmentRecentAssessmentsBinding binding;
    private RecentAssessmentAdapter adapter;
    private ArrayList<RecentAssessmentModel> data = new ArrayList<>();

    public RecentAssessmentsFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_recent_assessments, container, false);
        initData();
        return binding.getRoot();
    }

    private void initData() {
        adapter = new RecentAssessmentAdapter(getContext());
        for(int i=0 ; i<=20; i++) {
            data.add(new RecentAssessmentModel("Assessment "+ i, "16-07-2020",
                    "10"));
        }
        adapter.setList(data);
        binding.recyclerview.setAdapter(adapter);
    }
}
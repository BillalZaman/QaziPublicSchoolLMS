package com.infotech4It.qazipublicschool.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.infotech4It.qazipublicschool.R;
import com.infotech4It.qazipublicschool.databinding.FragmentAllLessonsBinding;
import com.infotech4It.qazipublicschool.view.adapters.AllLessonAdapter;
import com.infotech4It.qazipublicschool.view.adapters.RecentLessonAdapter;
import com.infotech4It.qazipublicschool.view.models.AllLessonModel;
import com.infotech4It.qazipublicschool.view.models.RecentLessonModel;

import java.util.ArrayList;

public class AllLessonsFragment extends Fragment {
    private FragmentAllLessonsBinding binding;
    private AllLessonAdapter adapter;
    private ArrayList<AllLessonModel> data = new ArrayList<>();

    public AllLessonsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_all_lessons, container, false);
        initData();
        return binding.getRoot();
    }

    private void initData() {
        adapter = new AllLessonAdapter(getContext());
        for(int i=0 ; i<=40; i++) {
            data.add(new AllLessonModel("Lesson "+ i));
        }
        adapter.setList(data);
        binding.recyclerview.setAdapter(adapter);
    }
}
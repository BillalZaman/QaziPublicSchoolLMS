package com.infotech4It.qazipublicschool.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.infotech4It.qazipublicschool.R;
import com.infotech4It.qazipublicschool.databinding.FragmentSubjectBinding;
import com.infotech4It.qazipublicschool.view.adapters.SubjectAdapter;
import com.infotech4It.qazipublicschool.view.models.SubjectModel;

import java.util.ArrayList;


public class SubjectFragment extends Fragment {
    private FragmentSubjectBinding binding;
    private SubjectAdapter adapter;
    private ArrayList<SubjectModel> dataList = new ArrayList<>();

    public SubjectFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_subject, container,false);
        initData();
        return binding.getRoot();
    }

    private void initData() {
        setRecyclerView();
    }

    private void setRecyclerView() {
        adapter = new SubjectAdapter(getContext());
        for (int i =0; i<=25; i++) {
            dataList.add(new SubjectModel(R.drawable.computer, "English " + i));
        }
        adapter.setList(dataList);
        binding.recyclerview.setAdapter(adapter);
    }
}
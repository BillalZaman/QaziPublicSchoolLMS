package com.infotech4It.qazipublicschool.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.infotech4It.qazipublicschool.ApplicationState;
import com.infotech4It.qazipublicschool.R;
import com.infotech4It.qazipublicschool.databinding.FragmentMCQSBinding;
import com.infotech4It.qazipublicschool.view.adapters.McqsAdapters;
import com.infotech4It.qazipublicschool.view.models.MCQsAnswerModel;
import com.infotech4It.qazipublicschool.view.models.MCQsModel;

import java.util.ArrayList;

public class MCQSFragment extends Fragment {
    private FragmentMCQSBinding binding;
    private ArrayList<MCQsModel> data = new ArrayList<>();
    private McqsAdapters adapters;


    public MCQSFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_m_c_q_s, container, false);
        initData();
        return binding.getRoot();
    }


    private void initData() {
        setRecyclerView();
    }

    private void setRecyclerView() {
        ArrayList<MCQsAnswerModel> dataAnswer = new ArrayList<>();
        dataAnswer.add(new MCQsAnswerModel("hellow"));
//        data.add(new MCQsModel("How many flowers are there?",answer1));
        adapters = new McqsAdapters(getContext(), data);
    }
}
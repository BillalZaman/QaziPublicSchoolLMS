package com.infotech4It.qazipublicschool.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.infotech4It.qazipublicschool.R;
import com.infotech4It.qazipublicschool.databinding.FragmentQuestionAnswerBinding;
import com.infotech4It.qazipublicschool.view.adapters.FillBlankAdapter;
import com.infotech4It.qazipublicschool.view.models.FillBlankModel;

import java.util.ArrayList;

public class QuestionAnswerFragment extends Fragment{
    private FragmentQuestionAnswerBinding binding;
    private ArrayList<FillBlankModel> data = new ArrayList<>();
    private FillBlankAdapter adapter;

    public QuestionAnswerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_question_answer, container, false);
        initData();
        return binding.getRoot();
    }

    private void initData() {
        for (int i=0; i<=10; i++){
            data.add(new FillBlankModel("What is your favourite color"));
        }
        adapter = new FillBlankAdapter(getContext(), data);
        binding.recyclerview.setAdapter(adapter);
    }
}
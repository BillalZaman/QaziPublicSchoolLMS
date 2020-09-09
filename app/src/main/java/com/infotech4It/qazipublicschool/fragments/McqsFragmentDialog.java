package com.infotech4It.qazipublicschool.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.infotech4It.qazipublicschool.R;
import com.infotech4It.qazipublicschool.databinding.FragmentMcqsDialogBinding;
import com.infotech4It.qazipublicschool.helpers.PreferenceHelper;

import constants.Constants;

public class McqsFragmentDialog extends Fragment {
    private FragmentMcqsDialogBinding binding;
    public McqsFragmentDialog() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_mcqs_dialog, container, false);
        init();
        return binding.getRoot();
    }

    private void init() {
        binding.textView6.setText("Total Number "+ PreferenceHelper.getInstance().getString(Constants.TOTAL_NUMBER,""));
        binding.textView7.setText("Obtained Number "+PreferenceHelper.getInstance().getString(Constants.OBTAINED_NUMBER,""));
    }
}
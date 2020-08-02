package com.infotech4It.qazipublicschool.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.infotech4It.qazipublicschool.R;
import com.infotech4It.qazipublicschool.databinding.FragmentCommentBinding;
import com.infotech4It.qazipublicschool.view.adapters.CommentingAdapter;
import com.infotech4It.qazipublicschool.view.models.CommentingModel;

import java.util.ArrayList;

public class CommentFragment extends Fragment {
    private FragmentCommentBinding binding;
    private ArrayList<CommentingModel> data = new ArrayList<>();
    private CommentingAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_comment, container, false);
        initData();
        return binding.getRoot();
    }

    private void initData() {
        adapter = new CommentingAdapter(getContext());
        for (int i=1;i<=10;i++){
            data.add(new CommentingModel("April-29-2020",
                    "AOA, Please do this homework properly",
                    "W/S, Maam sure I will work hard to do this, But need to understand some question. " +
                            "Please let me know when you are free so I can call you"));
        }
        adapter.setData(data);
        binding.recyclerview.setAdapter(adapter);
    }
}
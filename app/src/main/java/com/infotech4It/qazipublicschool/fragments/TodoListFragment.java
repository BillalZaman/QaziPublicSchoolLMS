package com.infotech4It.qazipublicschool.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.infotech4It.qazipublicschool.R;
import com.infotech4It.qazipublicschool.databinding.FragmentTodoListBinding;
import com.infotech4It.qazipublicschool.view.adapters.HomeWorkAdapter;
import com.infotech4It.qazipublicschool.view.models.HomeWorkModel;

import java.util.ArrayList;

public class TodoListFragment extends Fragment {
    private FragmentTodoListBinding binding;
    private ArrayList<HomeWorkModel> data = new ArrayList<>();
    private HomeWorkAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_todo_list, container, false);
        init();
        return binding.getRoot();
    }
    private void init() {
        adapter = new HomeWorkAdapter(getContext());
        data.add(new HomeWorkModel("Draw drawing of tiger"));
        adapter.setData(data);
        binding.recyclerview.setAdapter(adapter);
    }
}
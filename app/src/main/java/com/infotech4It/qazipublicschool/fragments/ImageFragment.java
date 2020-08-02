package com.infotech4It.qazipublicschool.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.infotech4It.qazipublicschool.R;
import com.infotech4It.qazipublicschool.databinding.FragmentImageBinding;

public class ImageFragment extends Fragment {
    private FragmentImageBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_image, container, false);
        loadImage();
        return binding.getRoot();
    }

    private void loadImage() {
        Glide.with(getContext())
                .load("https://cdn.pixabay.com/photo/2015/12/01/20/28/road-1072823__340.jpg")
                .into(binding.imgTask);
    }
}
package com.infotech4It.qazipublicschool.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.infotech4It.qazipublicschool.R;
import com.infotech4It.qazipublicschool.databinding.ActivityNoticeBoardBinding;

public class NoticeBoardActivity extends AppCompatActivity {
    private ActivityNoticeBoardBinding binding;

    public NoticeBoardActivity() {
        // Required empty public constructor
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_notice_board);
        initData();
    }

    private void initData() {

    }
}
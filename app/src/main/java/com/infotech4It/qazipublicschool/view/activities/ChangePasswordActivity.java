package com.infotech4It.qazipublicschool.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.infotech4It.qazipublicschool.R;
import com.infotech4It.qazipublicschool.databinding.ActivityChangePasswordBinding;

public class ChangePasswordActivity extends AppCompatActivity {
    private ActivityChangePasswordBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_change_password);

        init();
    }

    private void init() {
        binding.setOnChangePasswordClick(this);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.imgBack:{
                finish();
            }
            case R.id.btnChangePassword:{
                finish();
            }
        }
    }
}
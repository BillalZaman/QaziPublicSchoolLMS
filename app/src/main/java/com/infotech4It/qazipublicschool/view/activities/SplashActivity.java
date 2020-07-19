package com.infotech4It.qazipublicschool.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.infotech4It.qazipublicschool.ApplicationState;
import com.infotech4It.qazipublicschool.R;
import com.infotech4It.qazipublicschool.databinding.ActivitySplashBinding;
import com.infotech4It.qazipublicschool.helpers.UIHelper;

import javax.inject.Inject;

public class SplashActivity extends AppCompatActivity {
    private ActivitySplashBinding binding;
    private Handler handler;
    @Inject
    UIHelper uiHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        init();
    }

    private void init() {
        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                uiHelper.openActivity(SplashActivity.this, LoginActivity.class);
            }
        },3000);
    }
}
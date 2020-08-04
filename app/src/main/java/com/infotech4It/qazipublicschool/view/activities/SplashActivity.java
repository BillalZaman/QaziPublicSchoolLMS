package com.infotech4It.qazipublicschool.view.activities;

import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.infotech4It.qazipublicschool.ApplicationState;
import com.infotech4It.qazipublicschool.R;
import com.infotech4It.qazipublicschool.databinding.ActivitySplashBinding;
import com.infotech4It.qazipublicschool.helpers.PreferenceHelper;
import com.infotech4It.qazipublicschool.helpers.UIHelper;

import javax.inject.Inject;

import constants.Constants;

public class SplashActivity extends AppCompatActivity {
    @Inject
    UIHelper uiHelper;
    private ActivitySplashBinding binding;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        init();
    }

    private void init() {
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!PreferenceHelper.getInstance().getBol(Constants.IS_OPON_FIRST_TIME, false)) {
                    uiHelper.openActivity(SplashActivity.this, LoginActivity.class);
                    finish();

                } else {
                    if (PreferenceHelper.getInstance().getString(Constants.isLogin, Constants.no)
                            .equalsIgnoreCase(Constants.yes)) {
                        uiHelper.openActivity(SplashActivity.this, MainActivity.class);

                    } else {
                        uiHelper.openActivity(SplashActivity.this, LoginActivity.class);
                        finish();
                    }
                }
            }
        }, 3000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacksAndMessages(null);
    }
}
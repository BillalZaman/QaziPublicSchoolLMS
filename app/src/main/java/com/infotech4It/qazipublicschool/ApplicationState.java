package com.infotech4It.qazipublicschool;

import android.app.Application;
import android.content.Context;

import com.infotech4It.qazipublicschool.interfaces.ApplicationComponent;
import com.infotech4It.qazipublicschool.interfaces.DaggerApplicationComponent;
import com.infotech4It.qazipublicschool.module.internetModule.InternetModule;

import constants.Constants;


public class ApplicationState extends Application {

    ApplicationComponent applicationComponent;
    private static ApplicationState app;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        app = this;
    }
    @Override
    public void onCreate() {
        super.onCreate();

        Constants.CONTEXT = getApplicationContext();
//        Fabric.with(this, new Crashlytics());

        applicationComponent = DaggerApplicationComponent.builder()
                .internetModule(new InternetModule())
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public static ApplicationState getApp() {
        return app;
    }
}

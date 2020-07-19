package com.infotech4It.qazipublicschool.interfaces;

import com.infotech4It.qazipublicschool.fragments.MoreFragment;
import com.infotech4It.qazipublicschool.module.internetModule.InternetModule;
import com.infotech4It.qazipublicschool.module.uiHelperModule.UIHelperModule;
import com.infotech4It.qazipublicschool.view.activities.LoginActivity;
import com.infotech4It.qazipublicschool.view.activities.MainActivity;
import com.infotech4It.qazipublicschool.view.activities.ReleatedSubjectListActivity;
import com.infotech4It.qazipublicschool.view.activities.SplashActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Bilal Zaman on 17/07/2020.
 */
@Singleton
@Component(modules = {InternetModule.class, UIHelperModule.class})
public interface ApplicationComponent {

    void injectInternet(LoginActivity loginActivity);

    void injectUIHelper(SplashActivity splashActivity);

    void injectUIHelper(MainActivity mainActivity);

    void injectUIHelper(LoginActivity loginActivity);

    void injectUIHelper(ReleatedSubjectListActivity releatedSubjectListActivity);

    void injectUIHelper(MoreFragment moreFragment);
}

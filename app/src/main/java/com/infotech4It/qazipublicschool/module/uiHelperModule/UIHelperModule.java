package com.infotech4It.qazipublicschool.module.uiHelperModule;

import com.infotech4It.qazipublicschool.helpers.UIHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Bilal Zaman on 17/07/2020.
 */
@Module
public class UIHelperModule {
    @Singleton
    @Provides
    UIHelper providesUIHelper() {
        return new UIHelper();
    }
}

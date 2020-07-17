package com.infotech4It.qazipublicschool.module.internetModule;

import com.infotech4It.qazipublicschool.helpers.Internet;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Bilal Zaman on 17/07/2020.
 */
@Module
public class InternetModule {

    @Singleton
    @Provides
    Internet providesInternetState(){
        return new Internet();
    }
}

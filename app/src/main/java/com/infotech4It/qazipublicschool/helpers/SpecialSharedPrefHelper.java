package com.infotech4It.qazipublicschool.helpers;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.ArrayList;

import constants.Constants;


public class SpecialSharedPrefHelper {
    public static final String PREFS_NAME = "SPORT_APP";
    private static SpecialSharedPrefHelper instance_;

    public synchronized static SpecialSharedPrefHelper getInstance() {
        if (instance_ == null) {
            instance_ = new SpecialSharedPrefHelper();
        }
        return instance_;
    }

    // This four methods are used for maintaining favorites.
    public <T> void saveList(ArrayList<T> favorites, String key) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        settings = Constants.CONTEXT.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);
        editor = settings.edit();

        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(favorites);

        editor.putString(key, jsonFavorites);

        editor.apply();
    }

    // This four methods are used for maintaining favorites.
    public <T> void saveObject(ArrayList<T> favorites, String key) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        settings = Constants.CONTEXT.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);
        editor = settings.edit();

        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(favorites);

        editor.putString(key, jsonFavorites);

        editor.commit();
    }


//    public ArrayList<UserModel> getList(String KEY) {
//        SharedPreferences settings;
//        List<UserModel> favorites;
//
//        settings = ConstUtils.CONTEXT.getSharedPreferences(PREFS_NAME,
//                ConstUtils.CONTEXT.MODE_PRIVATE);
//
//        if (settings.contains(KEY)) {
//            String jsonFavorites = settings.getString(KEY, null);
//            Gson gson = new Gson();
//            UserModel[] favoriteItems = gson.fromJson(jsonFavorites,
//                    UserModel[].class);
//
//            favorites = Arrays.asList(favoriteItems);
//            favorites = new ArrayList<UserModel>(favorites);
//        } else
//            return null;
//
//        return (ArrayList<UserModel>) favorites;
//    }


    public void clearAllSpecialPreferences() {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        settings = Constants.CONTEXT.getSharedPreferences(PREFS_NAME,
                Constants.CONTEXT.MODE_PRIVATE);
        editor = settings.edit();
        editor.clear();
        editor.commit();

    }

    public void removePreference(String key) {

        SharedPreferences preferences = Constants.CONTEXT.getSharedPreferences(
                PREFS_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.remove(key);
        editor.commit();
    }
}
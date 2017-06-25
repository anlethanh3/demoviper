package com.anlt.viper.Util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.anlt.viper.BuildConfig;
import com.anlt.viper.Login.Entity.User;

/**
 * Created by An on 6/26/2017.
 */

public class Helper {
    static final String SHARED = BuildConfig.APPLICATION_ID + ".SHARED";
    static final String USER = BuildConfig.APPLICATION_ID + ".USER";
    static final String PASS = BuildConfig.APPLICATION_ID + ".PASS";

    public static void setUser(Activity activity, User user) {
        SharedPreferences settings = activity.getSharedPreferences(SHARED,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(USER, user.username);
        editor.putString(PASS, user.password);
        editor.commit();
    }

    public static User getUser(Activity activity) {
        SharedPreferences settings = activity.getSharedPreferences(SHARED,Context.MODE_PRIVATE);
        return new User(settings.getString(USER, ""), settings.getString(PASS, ""));
    }
}

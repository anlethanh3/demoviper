package com.anlt.viper.Login.Router;

import android.app.Activity;
import android.content.Intent;

import com.anlt.viper.Home.View.HomeActivity;
import com.anlt.viper.Login.Entity.User;
import com.anlt.viper.Login.Interface.Login;
import com.anlt.viper.Util.Helper;

/**
 * Created by An on 6/25/2017.
 */

public class LoginRouter implements Login.Router {

    Activity activity;

    public LoginRouter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void goToHomeScreen(User user) {
        Helper.setUser(activity, user);
        Intent intent = new Intent(activity, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }
}

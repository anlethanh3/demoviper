package com.anlt.viper.Home.Router;

import android.app.Activity;
import android.content.Intent;

import com.anlt.viper.Home.Interface.Home;
import com.anlt.viper.Login.View.LoginActivity;

/**
 * Created by An on 6/25/2017.
 */

public class HomeRouter implements Home.Router {
    Activity activity;

    public HomeRouter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void exitApp() {
        activity.finish();
    }

    @Override
    public void goToLoginScreen() {
        Intent intent = new Intent(activity, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }
}

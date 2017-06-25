package com.anlt.viper.Login.Interactor;

import android.app.Activity;

import com.anlt.viper.BuildConfig;
import com.anlt.viper.Login.Entity.User;
import com.anlt.viper.Login.Interface.Login;
import com.anlt.viper.Util.Helper;

/**
 * Created by An on 6/25/2017.
 */

public class LoginInteractor implements Login.Interactor {
    Login.InteractorOutput output;

    public LoginInteractor(Login.InteractorOutput output) {
        this.output = output;
    }

    @Override
    public void login(String username, String password) {
        if (username.contentEquals(BuildConfig.USER) && password.contentEquals(BuildConfig.PASS)) {
            output.onLoginSuccess(new User(username, password));
        } else {
            output.onLoginFail("Login fail");
        }
    }

    @Override
    public void checkLogin(Activity activity) {
        User user = Helper.getUser(activity);
        login(user.username, user.password);
    }
}
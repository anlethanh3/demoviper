package com.anlt.viper.Login.Interface;

import android.app.Activity;

import com.anlt.viper.Login.Entity.User;

/**
 * Created by An on 6/25/2017.
 */

public interface Login {
    interface View {
        void showError(String message);
    }

    interface Interactor {
        void login(String username, String password);

        void checkLogin(Activity activity);
    }

    interface InteractorOutput {
        void onLoginSuccess(User user);

        void onLoginFail(String message);
    }

    interface Presenter {
        void onLoginButtonClicked(String username, String password);

        void checkLogin();
    }

    interface Router {
        void goToHomeScreen(User user);
    }
}

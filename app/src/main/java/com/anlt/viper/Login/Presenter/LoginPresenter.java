package com.anlt.viper.Login.Presenter;

import android.app.Activity;

import com.anlt.viper.Login.Entity.User;
import com.anlt.viper.Login.Interactor.LoginInteractor;
import com.anlt.viper.Login.Interface.Login;
import com.anlt.viper.Login.Router.LoginRouter;

/**
 * Created by An on 6/25/2017.
 */

public class LoginPresenter implements Login.InteractorOutput, Login.Presenter {
    Login.View view;
    LoginRouter router;
    LoginInteractor interactor;

    public LoginPresenter(Login.View view) {
        this.view = view;
        this.router = new LoginRouter((Activity) view);
        interactor = new LoginInteractor(this);
    }

    @Override
    public void onLoginSuccess(User user) {
        router.goToHomeScreen(user);
    }

    @Override
    public void onLoginFail(String message) {
        view.showError(message);
    }

    @Override
    public void onLoginButtonClicked(String username, String password) {
        interactor.login(username, password);
    }

    @Override
    public void checkLogin() {
        interactor.checkLogin((Activity) view);
    }
}
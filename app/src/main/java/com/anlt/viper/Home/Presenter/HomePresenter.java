package com.anlt.viper.Home.Presenter;

import android.app.Activity;

import com.anlt.viper.Home.Interactor.HomeInteractor;
import com.anlt.viper.Home.Interface.Home;
import com.anlt.viper.Home.Router.HomeRouter;
import com.anlt.viper.R;

/**
 * Created by An on 6/25/2017.
 */

public class HomePresenter implements Home.Presenter, Home.InteractorOutput {
    Home.View view;
    HomeInteractor interactor;
    HomeRouter router;

    public HomePresenter(Home.View view) {
        this.view = view;
        this.interactor = new HomeInteractor(this);
        this.router = new HomeRouter((Activity) view);
    }

    @Override
    public void onClickBackButton() {
        interactor.back();
    }

    @Override
    public void onClickLogoutButton() {
        interactor.logout((Activity) view);
    }

    @Override
    public void onBackPressedSuccess() {
        router.exitApp();
    }

    @Override
    public void onLogout() {
        router.goToLoginScreen();
    }

    @Override
    public void onBackPressedFail() {
        view.showMessage(((Activity) view).getResources().getString(R.string.back));
    }
}

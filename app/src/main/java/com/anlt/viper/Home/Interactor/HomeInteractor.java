package com.anlt.viper.Home.Interactor;

import android.app.Activity;

import com.anlt.viper.Home.Interface.Home;
import com.anlt.viper.Login.Entity.User;
import com.anlt.viper.Util.Helper;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by An on 6/25/2017.
 */

public class HomeInteractor implements Home.Interactor {
    Home.InteractorOutput output;
    boolean isBack = false;

    public HomeInteractor(Home.InteractorOutput output) {
        this.output = output;
    }

    @Override
    public void back() {
        if (isBack == true) {
            output.onBackPressedSuccess();
        } else {

            output.onBackPressedFail();
        }
        isBack = true;
        Observable.just(1)
                .delay(3, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(o -> isBack = false);
    }

    @Override
    public void logout(Activity activity) {
        Helper.setUser(activity, new User("", ""));
        output.onLogout();
    }
}

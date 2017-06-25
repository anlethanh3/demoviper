package com.anlt.viper.Home.Interface;

import android.app.Activity;

/**
 * Created by An on 6/25/2017.
 */

public interface Home {
    interface View {
        void showMessage(String message);
    }

    interface Presenter {
        void onClickBackButton();

        void onClickLogoutButton();
    }

    interface Interactor {
        void back();
        void logout(Activity activity);
    }

    interface InteractorOutput {
        void onBackPressedSuccess();

        void onBackPressedFail();

        void onLogout();
    }

    interface Router {
        void exitApp();

        void goToLoginScreen();
    }

}

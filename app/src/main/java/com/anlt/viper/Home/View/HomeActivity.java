package com.anlt.viper.Home.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.widget.Toast;

import com.anlt.viper.Home.Interface.Home;
import com.anlt.viper.Home.Presenter.HomePresenter;
import com.anlt.viper.R;

public class HomeActivity extends AppCompatActivity implements Home.View {
    HomePresenter presenter = new HomePresenter(this);
    AppCompatButton logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        logout = (AppCompatButton) findViewById(R.id.logout);

        logout.setOnClickListener(v -> presenter.onClickLogoutButton());
    }

    @Override
    public void onBackPressed() {
        presenter.onClickBackButton();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}

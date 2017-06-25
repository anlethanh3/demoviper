package com.anlt.viper.Login.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.widget.Toast;

import com.anlt.viper.Login.Interface.Login;
import com.anlt.viper.Login.Presenter.LoginPresenter;
import com.anlt.viper.R;

public class LoginActivity extends AppCompatActivity implements Login.View {

    LoginPresenter presenter = new LoginPresenter(this);

    AppCompatEditText username;
    AppCompatEditText password;
    AppCompatButton login;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (AppCompatEditText) findViewById(R.id.username);
        password = (AppCompatEditText) findViewById(R.id.password);
        login = (AppCompatButton) findViewById(R.id.login);

        login.setOnClickListener(v ->
                presenter.onLoginButtonClicked(username.getText().toString(), password.getText().toString())
        );

        presenter.checkLogin();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}

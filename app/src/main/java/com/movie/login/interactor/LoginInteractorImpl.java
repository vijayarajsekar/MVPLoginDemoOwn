package com.movie.login.interactor;

import android.text.TextUtils;

/**
 * Created by vijayaraj_s on 9/28/2017.
 */

public class LoginInteractorImpl implements LoginInteractor {

    @Override
    public void login(String username, String password, onLoginFinishedListener listener) {

        if (TextUtils.isEmpty(username)) {
            listener.onUsenameError();
        } else if (TextUtils.isEmpty(password)) {
            listener.onPasswordError();
        } else if (username.equals("admin") && password.equals("12345")) {
            listener.onSuccess();
        } else {
            listener.onFailure("Invalid Credentials");
        }
    }
}

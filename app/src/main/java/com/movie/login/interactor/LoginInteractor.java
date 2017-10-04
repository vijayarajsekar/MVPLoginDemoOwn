package com.movie.login.interactor;

/**
 * Created by vijayaraj_s on 9/28/2017.
 */

public interface LoginInteractor {

    interface onLoginFinishedListener {

        void onUsenameError();

        void onPasswordError();

        void onSuccess();

        void onFailure(String msg);

    }

    void login(String username, String password, onLoginFinishedListener listener);

}

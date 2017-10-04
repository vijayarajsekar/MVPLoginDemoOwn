package com.movie.login.view;

/**
 * Created by vijayaraj_s on 9/28/2017.
 */

public interface LoginView {

    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswdError();

    void navigatetoMainActivity();

    void showAlert(String msg);

}

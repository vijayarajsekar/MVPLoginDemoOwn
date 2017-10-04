package com.movie.login.presenter;

import com.movie.login.view.LoginView;
import com.movie.login.interactor.LoginInteractor;
import com.movie.login.interactor.LoginInteractorImpl;

/**
 * Created by vijayaraj_s on 9/28/2017.
 */

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.onLoginFinishedListener {

    LoginView mLoginView;
    LoginInteractor mLoginInteractor;

    public LoginPresenterImpl(LoginView mView) {
        this.mLoginView = mView;
        this.mLoginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void validateCredentials(String uname, String mPass) {

        if (mLoginView != null) {
            mLoginView.showProgress();
            mLoginInteractor.login(uname, mPass, this);
        }
    }

    @Override
    public void onDestroy() {
        if (mLoginView != null) mLoginView = null;
    }

    @Override
    public void onUsenameError() {
        if (mLoginView != null) {
            mLoginView.hideProgress();
            mLoginView.setUsernameError();
        }
    }

    @Override
    public void onPasswordError() {
        if (mLoginView != null) {
            mLoginView.hideProgress();
            mLoginView.setPasswdError();
        }
    }

    @Override
    public void onSuccess() {
        if (mLoginView != null) {
            mLoginView.hideProgress();
            mLoginView.navigatetoMainActivity();
        }
    }

    @Override
    public void onFailure(String msg) {
        if (mLoginView != null) {
            mLoginView.hideProgress();
            mLoginView.showAlert(msg);
        }
    }
}
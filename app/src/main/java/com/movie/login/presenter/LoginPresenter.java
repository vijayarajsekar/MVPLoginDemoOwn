package com.movie.login.presenter;

/**
 * Created by vijayaraj_s on 9/28/2017.
 */

public interface LoginPresenter {

    void validateCredentials(String uname, String mPass);

    void onDestroy();

}

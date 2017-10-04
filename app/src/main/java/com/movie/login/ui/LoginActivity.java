package com.movie.login.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.movie.MainActivity;
import com.movie.R;
import com.movie.login.presenter.LoginPresenter;
import com.movie.login.presenter.LoginPresenterImpl;
import com.movie.login.view.LoginView;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private EditText mUsername, mPassword;
    private Button mDone;
    private ProgressBar mProgressBar;

    private LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mPresenter = new LoginPresenterImpl(this);

        mUsername = (EditText) findViewById(R.id.username);
        mPassword = (EditText) findViewById(R.id.password);
        mDone = (Button) findViewById(R.id.btnDone);
        mProgressBar = (ProgressBar) findViewById(R.id.progressbar);

        mDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.validateCredentials(mUsername.getText().toString().trim(), mPassword.getText().toString().trim());
            }
        });

    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        mUsername.setError("Username Empty");
    }

    @Override
    public void setPasswdError() {
        mPassword.setError("Password Empty");
    }

    @Override
    public void navigatetoMainActivity() {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }

    @Override
    public void showAlert(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }
}
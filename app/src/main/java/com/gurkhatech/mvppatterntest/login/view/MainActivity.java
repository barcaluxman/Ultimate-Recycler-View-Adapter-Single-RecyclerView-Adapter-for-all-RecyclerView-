package com.gurkhatech.mvppatterntest.login.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.gurkhatech.mvppatterntest.BuildConfig;
import com.gurkhatech.mvppatterntest.R;
import com.gurkhatech.mvppatterntest.colorlist.view.ColorsListActivity;
import com.gurkhatech.mvppatterntest.login.presenter.LogInPresenter;
import com.gurkhatech.mvppatterntest.orientationinfo.view.HomeActivity;
import com.gurkhatech.mvppatterntest.utils.Util;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements ILogInView {

ProgressDialog dialog;
LogInPresenter presenter = LogInPresenter.getInstance ( this );

@BindView(R.id.email)
EditText email;

@BindView(R.id.password)
EditText password;

@OnClick(R.id.log_in)
public void login ( ) {
    dialog = ProgressDialog.show ( this, getString ( R.string.loading_text ), getString ( R.string.please_wait_text ) );
    presenter.attemptLogIn ( email.getText ().toString (), password.getText ().toString () );
}

@Override
public void onCreate ( Bundle savedInstanceState ) {
    super.onCreate ( savedInstanceState );
    setContentView ( R.layout.activity_main );
    ButterKnife.bind ( this );
    if (BuildConfig.DEBUG) {
        email.setText ( getString ( R.string.dummy_email ) );
        password.setText ( getString ( R.string.dummy_password ) );
    }


}


@Override
public void showLogInFailed ( ) {
    dialog.dismiss ();

    Util.toast ( getString ( R.string.login_failed ), this );
    startActivity ( new Intent ( this, ColorsListActivity.class ) );

}

@Override
public void navigateToHome ( ) {
    dialog.dismiss ();
    Util.toast ( getString ( R.string.login_success ), this );
    startActivity ( new Intent ( this, HomeActivity.class ) );

}


}
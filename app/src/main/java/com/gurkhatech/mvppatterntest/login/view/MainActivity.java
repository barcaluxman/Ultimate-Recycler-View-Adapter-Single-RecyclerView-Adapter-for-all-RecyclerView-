package com.gurkhatech.mvppatterntest.login.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.gurkhatech.mvppatterntest.BuildConfig;
import com.gurkhatech.mvppatterntest.R;
import com.gurkhatech.mvppatterntest.colorlist.ColorsListActivity_;
import com.gurkhatech.mvppatterntest.login.presenter.LogInPresenter;
import com.gurkhatech.mvppatterntest.orientationinfo.view.HomeActivity_;
import com.gurkhatech.mvppatterntest.utils.Util;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;


@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity implements ILogInView {

ProgressDialog dialog;
LogInPresenter presenter = LogInPresenter.getInstance ( this );

@ViewById
EditText email;

@ViewById
EditText password;

@Click(R.id.log_in)
public void login ( ) {
    dialog = ProgressDialog.show ( this, getString ( R.string.loading_text ), getString ( R.string.please_wait_text ) );
    presenter.attemptLogIn ( email.getText ().toString (), password.getText ().toString () );
}

@Override
public void onCreate ( Bundle savedInstanceState, PersistableBundle persistentState ) {
    super.onCreate ( savedInstanceState, persistentState );
    if (BuildConfig.DEBUG) {
        email.setText ( getString ( R.string.dummy_email ) );
        password.setText ( getString ( R.string.dummy_password ) );
    }


}


@Override
public void showLogInFailed ( ) {
    dialog.dismiss ();

    Util.toast ( getString ( R.string.login_failed ), this );
    ColorsListActivity_.intent ( this ).start ();

}

@Override
public void navigateToHome ( ) {
    dialog.dismiss ();
    Util.toast ( getString ( R.string.login_success ), this );
    HomeActivity_.intent ( this ).start ();
}


}
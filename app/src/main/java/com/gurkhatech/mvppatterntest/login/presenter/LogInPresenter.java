package com.gurkhatech.mvppatterntest.login.presenter;

import com.gurkhatech.mvppatterntest.login.model.LoginModel;
import com.gurkhatech.mvppatterntest.login.view.ILogInView;

/**
 * Created by adventure on 2/2/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */
public class LogInPresenter implements ILoginPresenter, OnLoginFinishedListener {

private ILogInView view;
private LoginModel model;
private static LogInPresenter logInPresenter;


private LogInPresenter ( ILogInView view ) {
    this ( view, new LoginModel () );
}

private LogInPresenter ( ILogInView view, LoginModel model ) {
    this.view = view;
    this.model = model;
}

public static LogInPresenter getInstance ( ILogInView logInView ) {
    if(logInPresenter==null){
        logInPresenter = new LogInPresenter ( logInView );
    }
    return logInPresenter;
}

@Override
public void attemptLogIn ( String userName, String password ) {
    model.validateLogInAsync ( this, userName, password );

}

@Override
public void onSuccess ( ) {
    view.navigateToHome ();

}

@Override
public void onError ( ) {
    view.showLogInFailed ();
}
}

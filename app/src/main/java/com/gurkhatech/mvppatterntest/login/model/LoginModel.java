package com.gurkhatech.mvppatterntest.login.model;

import android.os.Handler;

import com.gurkhatech.mvppatterntest.login.presenter.OnLoginFinishedListener;
import com.gurkhatech.mvppatterntest.utils.OKHttpSingleton;

/**
 * Created by adventure on 2/2/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */
public class LoginModel {
public void validateLogInAsync ( final OnLoginFinishedListener listener, final String userName, final String password ) {
    OKHttpSingleton.testOKHttpUrl ( "http://www.mocky.io/v2/5894a8b32600000b2600aa79" );

    new Handler ().postDelayed ( new Runnable () {
        @Override
        public void run ( ) {
            if (( userName.length () > 3 ) && ( password.length () > 3 )) {
                listener.onSuccess ();
            }
            else {
                listener.onError ();
            }
        }
    }, 2000 );
}
}

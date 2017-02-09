package com.gurkhatech.mvppatterntest.utils;

import android.app.Application;

/**
 * Created by adventure on 2/4/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

public class MyApplication extends Application {
private static Application application;

public static Application getInstance ( ) {
    return application;
}

@Override
public void onCreate ( ) {
    super.onCreate ();
    application = this;
}

}


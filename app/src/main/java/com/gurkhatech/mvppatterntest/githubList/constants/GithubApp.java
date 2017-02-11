package com.gurkhatech.mvppatterntest.githubList.constants;

import android.app.Application;

import com.gurkhatech.mvppatterntest.utils.MyApplication;

/**
 * Created by adventure on 2/9/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

public class GithubApp extends Application {
public static Application application = MyApplication.getInstance ();

public static Application getInstance ( ) {
    return application;
}


@Override
public void onCreate ( ) {
    super.onCreate ();
    application = this;
}
}

package com.gurkhatech.mvppatterntest.utils;

import android.app.Application;

import com.gurkhatech.mvppatterntest.utils.di.AppDaggerComponent;
import com.gurkhatech.mvppatterntest.utils.di.ContextModule;
import com.gurkhatech.mvppatterntest.utils.di.DaggerAppDaggerComponent;

/**
 * Created by adventure on 2/4/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

public class MyApplication extends Application {
private static MyApplication application;
private AppDaggerComponent component;

public static MyApplication getInstance ( ) {
    application= (application==null)?new MyApplication ():application;
    return application;
}

@Override
public void onCreate ( ) {
    super.onCreate ();
    application = this;
    component = DaggerAppDaggerComponent
            .builder ()
            .contextModule ( new ContextModule ( this ) )
            .build ();

}

public AppDaggerComponent getComponent ( ) {
    return component;
}
}


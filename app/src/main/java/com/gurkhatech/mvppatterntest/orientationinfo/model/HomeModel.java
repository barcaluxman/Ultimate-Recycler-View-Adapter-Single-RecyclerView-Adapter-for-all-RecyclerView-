package com.gurkhatech.mvppatterntest.orientationinfo.model;

import android.content.res.Configuration;

import com.gurkhatech.mvppatterntest.orientationinfo.presenter.IOrientationListener;

/**
 * Created by adventure on 2/2/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */
public class HomeModel {

public void validateOrientation ( IOrientationListener listener, int orientation ) {
    if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
        listener.isLandScape ();
    }
    else {
        listener.isPortrait ();
    }
}

}

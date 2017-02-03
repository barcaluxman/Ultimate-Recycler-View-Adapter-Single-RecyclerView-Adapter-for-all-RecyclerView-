package com.gurkhatech.mvppatterntest.orientationinfo.presenter;

import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.v4.content.ContextCompat;

import com.gurkhatech.mvppatterntest.R;
import com.gurkhatech.mvppatterntest.utils.Util;
import com.gurkhatech.mvppatterntest.orientationinfo.model.HomeModel;
import com.gurkhatech.mvppatterntest.orientationinfo.view.IHomeView;

/**
 * Created by adventure on 2/2/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */
public class HomePresenter implements IHomePresenter, IOrientationListener {

private IHomeView homeView;
private HomeModel model;

public HomePresenter ( IHomeView homeView ) {
    this ( homeView, new HomeModel () );
}

private HomePresenter ( IHomeView homeView, HomeModel model ) {
    this.homeView = homeView;
    this.model = model;
}

public static HomePresenter getInstance ( IHomeView homeView ) {
    return new HomePresenter ( homeView );
}

@Override
public void isPortrait ( ) {
    setScreen ( ContextCompat.getColor ( homeView.getContext (), R.color.colorAccent ) );
    homeView.showScreenOrientationInfo ( "This is portrait Screen" );

}

@Override
public void isLandScape ( ) {
    setScreen ( ContextCompat.getColor ( homeView.getContext (), R.color.colorPrimaryDark ) );
    homeView.showScreenOrientationInfo ( "This is landscape Screen" );
}

@Override
public void findOrientation ( ) {
    model.validateOrientation ( this, ( (Context) homeView ).getResources ().getConfiguration ().orientation );
}

@Override
public void setScreen ( @ColorInt int color ) {
    homeView.setBackGroundColor ( color );
    homeView.setTextColor ( Util.getComplimentaryColor ( color ) );
}
}

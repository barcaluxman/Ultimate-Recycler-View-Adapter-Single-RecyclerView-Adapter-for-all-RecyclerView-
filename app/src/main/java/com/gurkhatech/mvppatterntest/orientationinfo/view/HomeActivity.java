package com.gurkhatech.mvppatterntest.orientationinfo.view;

import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.gurkhatech.mvppatterntest.R;
import com.gurkhatech.mvppatterntest.orientationinfo.presenter.HomePresenter;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_home)
public class HomeActivity extends AppCompatActivity implements IHomeView {

@ViewById
TextView homeText;


@Override
protected void onResume ( ) {
    super.onResume ();
    displayFromBG ();
    HomePresenter.getInstance ( this ).findOrientation ();

}

@Override
public Context getContext ( ) {
    return this;
}

@Override
@UiThread
public void showScreenOrientationInfo ( String info ) {
    homeText.setText ( info );

}

@Override
public void setBackGroundColor ( @ColorInt int color ) {
    homeText.setBackgroundColor ( color );
}

@Override
public void setTextColor ( @ColorInt int color ) {
    homeText.setTextColor ( color );

}

@Override
@Background
public void displayFromBG ( ) {
    for (int i = 0 ; i < 912345678 ; i++) {
        if (i % 100000 == 0) {
            showScreenOrientationInfo ( "The thousand is : " + i / 100000 );
        }
    }
}
}

package com.gurkhatech.mvppatterntest.orientationinfo.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.gurkhatech.mvppatterntest.R;
import com.gurkhatech.mvppatterntest.orientationinfo.presenter.HomePresenter;
import com.gurkhatech.mvppatterntest.utils.Util;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity implements IHomeView {

@BindView(R.id.homeText)
TextView homeText;

@OnClick(R.id.homeText)
public void goToRx ( ) {
    Util.log ( "textView clicked" );
}

@Override
public void onCreate ( Bundle savedInstanceState ) {
    super.onCreate ( savedInstanceState );
    setContentView ( R.layout.activity_home );
    ButterKnife.bind ( this );
}

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
public void displayFromBG ( ) {
    for (int i = 0 ; i < 912345678 ; i++) {
        if (i % 100000 == 0) {
            showScreenOrientationInfo ( "The thousand is : " + i / 100000 );
        }
    }
}
}

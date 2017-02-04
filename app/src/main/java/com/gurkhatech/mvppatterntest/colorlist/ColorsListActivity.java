package com.gurkhatech.mvppatterntest.colorlist;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.gurkhatech.mvppatterntest.R;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_colors_list_actvity)
public class ColorsListActivity extends AppCompatActivity implements IColorView {
@ViewById
TextView colorText;

ColorLoaderListener colorPresenter = ColorLoaderListener.getInstance ( this );

@Override
public void setText ( String text ) {
    colorText.setText ( text );
}


@Override
protected void onResume ( ) {
    super.onResume ();
    colorPresenter.loadColor ();
}
}

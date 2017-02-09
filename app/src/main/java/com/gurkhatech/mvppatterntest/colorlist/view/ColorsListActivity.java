package com.gurkhatech.mvppatterntest.colorlist.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.gurkhatech.mvppatterntest.R;
import com.gurkhatech.mvppatterntest.colorlist.presenter.ColorLoaderListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ColorsListActivity extends AppCompatActivity implements IColorView {
@BindView(R.id.colorText)
TextView colorText;

ColorLoaderListener colorPresenter = ColorLoaderListener.getInstance ( this );

@Override
public void setText ( String text ) {
    colorText.setText ( text );
}


@Override
protected void onCreate ( Bundle savedInstanceState ) {
    super.onCreate ( savedInstanceState );
    setContentView ( R.layout.activity_colors_list_actvity );
    ButterKnife.bind ( this );
}

@Override
protected void onResume ( ) {
    super.onResume ();
    colorPresenter.loadColor ();
}

}

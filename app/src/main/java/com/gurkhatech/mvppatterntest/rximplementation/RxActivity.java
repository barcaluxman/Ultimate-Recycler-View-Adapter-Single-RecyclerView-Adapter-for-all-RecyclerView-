package com.gurkhatech.mvppatterntest.rximplementation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.gurkhatech.mvppatterntest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class RxActivity extends AppCompatActivity implements RxContract.View {

    @BindView(R.id.rxText)
    TextView rxText;


    RxPresenter presenter = RxPresenter.getInstance(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.callAMethod(presenter.setUpRx());
    }

    @Override
    public void displayText(String s) {
        rxText.setText(s);
    }

    @OnClick(R.id.rxText)
    void textClicked() {
        presenter.unSubscribeRx();
    }
}

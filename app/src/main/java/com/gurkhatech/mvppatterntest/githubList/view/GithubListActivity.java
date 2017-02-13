package com.gurkhatech.mvppatterntest.githubList.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.gurkhatech.mvppatterntest.R;
import com.gurkhatech.mvppatterntest.githubList.GithubListContract;
import com.gurkhatech.mvppatterntest.githubList.model.dtos.GithubUserDTO;
import com.gurkhatech.mvppatterntest.githubList.presenter.GithubListPresenter;
import com.gurkhatech.mvppatterntest.githubList.view.di.DaggerGithubListActivityComponent;
import com.gurkhatech.mvppatterntest.githubList.view.di.GithubListActivityModule;
import com.gurkhatech.mvppatterntest.githubList.view.viewcomponents.GithubUserListAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GithubListActivity extends AppCompatActivity implements GithubListContract.View {

@BindView(R.id.userInput)
EditText userInput;

@BindView(R.id.userList)
RecyclerView userList;

@Inject
GithubUserListAdapter githubUserListAdapter;

@Inject
LinearLayoutManager linearLayoutManager;

GithubListPresenter githubListPresenter = GithubListPresenter.getInstance ( this );


@Override
protected void onCreate ( Bundle savedInstanceState ) {
    super.onCreate ( savedInstanceState );
    setContentView ( R.layout.activity_github_list );
    ButterKnife.bind ( this );

    DaggerGithubListActivityComponent.builder ()
            .githubListActivityModule ( new GithubListActivityModule ( this ) )
            .build ().inject ( this );
    userList.setLayoutManager ( linearLayoutManager);
    userList.setAdapter ( githubUserListAdapter );


}

@Override
protected void onDestroy ( ) {
    super.onDestroy ();
    githubListPresenter.disconnect ();
}

@Override
public void setData ( List < GithubUserDTO > data ) {
    githubUserListAdapter.setData ( data );
}


@OnClick(R.id.search)
public void triggerSearch ( ) {
    githubListPresenter.searchUser (userInput.getText ().toString ());
}
}

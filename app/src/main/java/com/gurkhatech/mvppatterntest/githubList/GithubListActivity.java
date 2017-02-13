package com.gurkhatech.mvppatterntest.githubList;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.ImageView;

import com.gurkhatech.mvppatterntest.R;
import com.gurkhatech.mvppatterntest.githubList.dtos.GithubUserDTO;
import com.gurkhatech.mvppatterntest.githubList.view.di.DaggerGithubListActivityComponent;
import com.gurkhatech.mvppatterntest.githubList.view.di.GithubListActivityModule;
import com.gurkhatech.mvppatterntest.githubList.view.viewcomponents.GithubUserListAdapter;
import com.gurkhatech.mvppatterntest.utils.Util;

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
@BindView(R.id.search)
ImageView search;

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
    userList.setLayoutManager ( linearLayoutManager );
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

@Override
public void enableSearchButton ( boolean enable ) {
    userInput.setClickable ( enable );
    search.setClickable ( enable );
    userInput.setEnabled ( enable );
    search.setEnabled ( enable );
}

@Override
public void showNetworkError ( ) {
    Util.log ( "Network Error" );

}

@Override
public void showNoDataError ( ) {
    Util.log ( "No data found" );

}


@OnClick(R.id.search)
public void triggerSearch ( ) {
    githubListPresenter.searchUser ( userInput.getText ().toString () );
    Util.log ( "search Clicked" );
}

@Override
protected void onResume ( ) {
    super.onResume ();
    githubListPresenter.enableSearch ( true );
}
}

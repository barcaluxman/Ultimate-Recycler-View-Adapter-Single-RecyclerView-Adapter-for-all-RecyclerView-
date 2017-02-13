package com.gurkhatech.mvppatterntest.githubList;

import android.support.annotation.NonNull;

import com.gurkhatech.mvppatterntest.githubList.view.viewcomponents.dtos.GithubUserDTO;

import java.util.List;

/**
 * Created by adventure on 2/9/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

public class GithubListPresenter implements GithubListContract.Presenter {

private static GithubListPresenter githubListPresenter;

private GithubListContract.View githubListView;
private GithubListContract.Model githubListModel;

private GithubListPresenter ( GithubListContract.View view ) {
    this.githubListView = view;
    this.githubListModel = new GithubListModel ();
}

public static GithubListPresenter getInstance ( GithubListContract.View view ) {
    githubListPresenter = ( githubListPresenter == null ) ?
            new GithubListPresenter ( view ) : githubListPresenter;
    return githubListPresenter;
}

@Override
public void searchUser ( @NonNull String userName ) {
    githubListModel.makeAsyncRequest ( userName, this );
    enableSearch ( false );

}

@Override
public void loadData ( List < GithubUserDTO > data ) {
    githubListView.setData ( data );
}

@Override
public void disconnect ( ) {
    githubListModel.cancelNetworkCall ();

}

@Override
public void enableSearch ( boolean enable ) {
    githubListView.enableSearchButton ( enable );

}

@Override
public void alertNetworkError ( ) {
githubListView.showNetworkError ();
}

@Override
public void alertNoDataFound ( ) {
githubListView.showNoDataError ();
}
}

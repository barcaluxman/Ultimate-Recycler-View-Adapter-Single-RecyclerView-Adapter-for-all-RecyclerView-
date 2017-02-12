package com.gurkhatech.mvppatterntest.githubList.presenter;

import com.gurkhatech.mvppatterntest.githubList.GithubListContract;
import com.gurkhatech.mvppatterntest.githubList.model.GithubListModel;

/**
 * Created by adventure on 2/9/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

public class GithubListPresenter implements GithubListContract.IGithubListPresenter {

private static GithubListPresenter githubListPresenter;

private GithubListContract.IGithubListView githubListView;
private GithubListContract.IGithubListModel githubListModel;

private GithubListPresenter ( GithubListContract.IGithubListView view ) {
    this.githubListView = view;
    this.githubListModel = new GithubListModel ();
}

public static GithubListPresenter getInstance ( GithubListContract.IGithubListView view ) {
    githubListPresenter = ( githubListPresenter == null ) ?
            new GithubListPresenter ( view ) : githubListPresenter;
    return githubListPresenter;
}

@Override
public void searchUser ( ) {
    githubListView.setLayoutManager ();
    githubListView.setAdapter ();
    githubListView.setList ( githubListModel.getUserList ( githubListView.getUserInput () ) );

}

@Override
public void disconnect ( ) {
    githubListModel.cancelNetworkCall ();

}
}

package com.gurkhatech.mvppatterntest.githubList.presenter;

import com.gurkhatech.mvppatterntest.githubList.constants.GithubApp;
import com.gurkhatech.mvppatterntest.githubList.model.GithubListModel;
import com.gurkhatech.mvppatterntest.githubList.model.IGithubListModel;
import com.gurkhatech.mvppatterntest.githubList.view.IGithubListView;
import com.gurkhatech.mvppatterntest.utils.Util;

/**
 * Created by adventure on 2/9/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

public class GithubListPresenter implements IGithubListPresenter {

private static GithubListPresenter githubListPresenter;

private IGithubListView githubListView;
private IGithubListModel githubListModel;

private GithubListPresenter ( IGithubListView view ) {
    this.githubListView = view;
    this.githubListModel = new GithubListModel ();
}

public static GithubListPresenter getInstance ( IGithubListView view ) {
    githubListPresenter = ( githubListPresenter == null ) ? new GithubListPresenter ( view ) : githubListPresenter;
    return githubListPresenter;
}

@Override
public void searchUser ( String name ) {
    githubListView.setList ( githubListModel.getUserList ( name ) );

}

@Override
public void disconnect ( ) {
    githubListModel.cancelNetworkCall ();

}
}

package com.gurkhatech.mvppatterntest.githubList.presenter;

import android.support.annotation.NonNull;

import com.gurkhatech.mvppatterntest.githubList.GithubListContract;
import com.gurkhatech.mvppatterntest.githubList.model.GithubListModel;

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
    githubListView.setData ( githubListModel.getUserList ( userName ) );

}

@Override
public void disconnect ( ) {
    githubListModel.cancelNetworkCall ();

}
}

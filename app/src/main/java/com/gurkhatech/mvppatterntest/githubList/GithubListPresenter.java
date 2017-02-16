package com.gurkhatech.mvppatterntest.githubList;

import android.support.annotation.NonNull;

import com.gurkhatech.mvppatterntest.R;
import com.gurkhatech.mvppatterntest.githubList.components.adapters.gurkha.lib.GurkhaComboDTO;
import com.gurkhatech.mvppatterntest.githubList.components.dtos.GithubUserDTO;
import com.gurkhatech.mvppatterntest.githubList.components.viewholders.GitHubUserListViewHolder;
import com.gurkhatech.mvppatterntest.githubList.components.viewholders.GitHubUserListViewHolderAlter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adventure on 2/9/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

class GithubListPresenter implements GithubListContract.Presenter {

private static GithubListPresenter githubListPresenter;

private GithubListContract.View githubListView;
private GithubListContract.Model githubListModel;

private GithubListPresenter ( GithubListContract.View view ) {
    this ( view, new GithubListModel () );
}

@SuppressWarnings("WeakerAccess")
public GithubListPresenter ( GithubListContract.View view, GithubListContract.Model model ) {
    this.githubListView = view;
    this.githubListModel = model;
}

static GithubListPresenter getInstance ( GithubListContract.View view ) {
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
    List < GurkhaComboDTO > fullData = new ArrayList <> ();
    for (int i = 0 ; i < data.size () ; i++) {

        if (data.get ( i ).getUserName ().length () > 10) {
            fullData.add ( new GurkhaComboDTO ( R.layout.item_github_use_list, data.get ( i ), GitHubUserListViewHolder.class ) );
        }
        else {
            fullData.add ( new GurkhaComboDTO ( R.layout.item_github_use_list_alter, data.get ( i ), GitHubUserListViewHolderAlter.class ) );

        }
    }
    githubListView.setData ( fullData );

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

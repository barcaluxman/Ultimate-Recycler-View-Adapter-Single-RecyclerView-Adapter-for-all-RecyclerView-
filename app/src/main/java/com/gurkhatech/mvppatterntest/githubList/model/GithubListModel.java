package com.gurkhatech.mvppatterntest.githubList.model;

import com.gurkhatech.mvppatterntest.githubList.GithubListContract;
import com.gurkhatech.mvppatterntest.githubList.model.dtos.GithubUserListDTO;
import com.gurkhatech.mvppatterntest.githubList.utils.GithubAPIService;
import com.gurkhatech.mvppatterntest.githubList.utils.GithubApp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by adventure on 2/9/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

public class GithubListModel implements GithubListContract.Model {
private Call < GithubUserListDTO > userListCall;
private GithubAPIService apiService = GithubApp.getInstance ().getGithubAPIService ();

@Override
public void makeAsyncRequest ( String name, final GithubListContract.Presenter presenter ) {
    userListCall = apiService.searchGitHubUsers ( name );
    userListCall.enqueue ( new Callback < GithubUserListDTO > () {
        @Override
        public void onResponse ( Call < GithubUserListDTO > call, Response < GithubUserListDTO > response ) {
            try {
                presenter.loadData ( response.body ().getList () );
            } catch (Exception ignored) {
                presenter.alertNoDataFound ();
            }
            presenter.enableSearch ( true );

        }

        @Override
        public void onFailure ( Call < GithubUserListDTO > call, Throwable t ) {

            presenter.enableSearch ( true );
            presenter.alertNetworkError ();
        }
    } );

}

@Override
public void cancelNetworkCall ( ) {
    userListCall.cancel ();
}
}

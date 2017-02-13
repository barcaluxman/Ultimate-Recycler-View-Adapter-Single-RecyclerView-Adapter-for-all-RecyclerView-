package com.gurkhatech.mvppatterntest.githubList;

import com.gurkhatech.mvppatterntest.githubList.view.viewcomponents.dtos.GithubUserListDTO;
import com.gurkhatech.mvppatterntest.utils.GithubAPIService;
import com.gurkhatech.mvppatterntest.utils.Util;

import javax.inject.Inject;

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


@SuppressWarnings("WeakerAccess")
@Inject
public GithubAPIService apiService;
private Call < GithubUserListDTO > userListCall;

GithubListModel ( ) {
    GithubListActivity.getDaggerComponent ().injectGithubListModel ( this );

}

@Override
public void makeAsyncRequest ( String name, final GithubListContract.Presenter presenter ) {
    injectModel ();
    userListCall = apiService.searchGitHubUsers ( name );
    userListCall.enqueue ( new Callback < GithubUserListDTO > () {
        @Override
        public void onResponse ( Call < GithubUserListDTO > call, Response < GithubUserListDTO > response ) {
            try {
                presenter.loadData ( response.body ().getList () );
            } catch (Exception ignored) {
                Util.log ( ignored.getMessage () );
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

@Override
public void injectModel ( ) {


}

}

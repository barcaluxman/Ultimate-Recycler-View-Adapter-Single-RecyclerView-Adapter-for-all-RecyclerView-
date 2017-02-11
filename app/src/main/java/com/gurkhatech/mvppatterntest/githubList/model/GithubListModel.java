package com.gurkhatech.mvppatterntest.githubList.model;

import com.gurkhatech.mvppatterntest.githubList.constants.GithubApp;
import com.gurkhatech.mvppatterntest.githubList.constants.modules.OkHttpSynchronous;
import com.gurkhatech.mvppatterntest.utils.Util;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

/**
 * Created by adventure on 2/9/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

public class GithubListModel implements IGithubListModel {
private Call < GithubUserListDTO > userListCall;
private GithubAPIService apiService = GithubApp.getInstance ().getGithubAPIService ();

@Override
public List < GithubUserDTO > getUserList ( String name ) {
    userListCall = apiService.searchGitHubUsers ( name );
    List < GithubUserDTO > userList;
    try {
        userList = ( (GithubUserListDTO) OkHttpSynchronous.getInstance ().synchronousCall ( userListCall ) ).getList ();
    } catch (Exception e) {
        userList = new ArrayList <> ();
        Util.log ( e.getMessage () );
    }
    return userList;

}

@Override
public void cancelNetworkCall ( ) {
    userListCall.cancel ();
}
}

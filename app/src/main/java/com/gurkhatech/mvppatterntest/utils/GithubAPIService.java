package com.gurkhatech.mvppatterntest.utils;

import com.gurkhatech.mvppatterntest.githubUsersList.components.dtos.GithubUserDTO;
import com.gurkhatech.mvppatterntest.githubUsersList.components.dtos.GithubUserListDTO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by adventure on 2/9/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

public interface GithubAPIService {

@GET(GithubListConstants.END_POINT_SINGLE_USER_FROM_SEARCH + "/{username}")
Call < GithubUserDTO > getSingleUser ( @Path("username") String username );

@GET(GithubListConstants.END_POINT_USER_LIST_FROM_SEARCH)
Call < GithubUserListDTO > searchGitHubUsers ( @Query("q") String name );
}

package com.gurkhatech.mvppatterntest.githubList.utils;

import com.gurkhatech.mvppatterntest.githubList.dtos.GitHubRepoItemDTO;
import com.gurkhatech.mvppatterntest.githubList.dtos.GitHubRepoListDTO;
import com.gurkhatech.mvppatterntest.githubList.dtos.GithubUserDTO;
import com.gurkhatech.mvppatterntest.githubList.dtos.GithubUserListDTO;

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

@GET("{url}")
Call < GitHubRepoItemDTO > getSingleRepo ( @Path("url") String url );

@GET(GithubListConstants.END_POINT_USER_LIST_FROM_SEARCH)
Call < GithubUserListDTO > searchGitHubUsers ( @Query("q") String name );


@GET(GithubListConstants.END_POINT_REPO_LIST_FROM_SEARCH + "/{name}")
Call < GitHubRepoListDTO > searchGitHubRepo ( @Path("name") String name );
}

package com.gurkhatech.mvppatterntest.githubUsersList

import com.gurkhatech.mvppatterntest.githubUsersList.models.GithubUserData
import com.gurkhatech.mvppatterntest.githubUsersList.models.GithubUserListDTO
import com.gurkhatech.mvppatterntest.utils.commons.GithubListConstants

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by adventure on 2/9/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

interface GithubAPIServiceKotlin {

    @GET(GithubListConstants.END_POINT_SINGLE_USER_FROM_SEARCH + "/{username}")
    fun getSingleUser(@Path("username") username: String): Call<GithubUserData>

    @GET(GithubListConstants.END_POINT_USER_LIST_FROM_SEARCH)
    fun searchGitHubUsers(@Query("q") name: String): Call<GithubUserListDTO>
}

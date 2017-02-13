package com.gurkhatech.mvppatterntest.githubList.utils;

/**
 * Created by adventure on 2/9/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

public class GithubListConstants {

public static final String BASE_URL = "https://api.github.com";
public static final String AUTH_URL = "";
public static final String END_POINT_PROJECT_INFO = "";
public static final long GITHUB_CACHE_TIME_OUT = 60 * 60 * 24 * 7;  // cache timeout -> one week
public static final long GITHUB_CACHE_SIZE = 3 * 1000 * 1000;  // cache size-> 30 MB
public static final long CONNECTION_TIME_OUT = 20 * 1000;  // network timeout -> 20 seconds
static final String END_POINT_USER_LIST_FROM_SEARCH = "/search/users";
static final String END_POINT_SINGLE_USER_FROM_SEARCH = "/users";
static final String END_POINT_REPO_LIST_FROM_SEARCH = "/search/repositories?q=";

}

package com.gurkhatech.mvppatterntest.githubList.dtos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by adventure on 2/9/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

public class GitHubRepoItemDTO {

@SerializedName("name")
private String repoName;

@SerializedName("html_url")
private String repoUrl;

@SerializedName("language")
private String language;

@SerializedName("private")
private boolean isPrivate;
@SerializedName("size")
private int size;

public String getRepoName ( ) {
    return repoName;
}

public String getRepoUrl ( ) {
    return repoUrl;
}

public String getLanguage ( ) {
    return language;
}

public boolean isPrivate ( ) {
    return isPrivate;
}

public int getSize ( ) {
    return size;
}
}


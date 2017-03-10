package com.gurkhatech.mvppatterntest.githubList.components.dtos;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;
import com.gurkhatech.mvppatterntest.githubList.components.adapters.gurkha.lib.GurkhaDTO;

/**
 * Created by adventure on 2/9/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

public class GithubUserDTO implements GurkhaDTO {

    public GithubUserDTO(String userName) {
        this.userName = userName;
    }

    @SerializedName("login")
    private String userName;

    @SerializedName("name")
    private String FullName;

    @SerializedName("html_url")
    private String profileUrl;

    @SerializedName("avatar_url")
    private String avatarUrl;

    @SerializedName("email")
    private String email;

    @SerializedName("repos_url")
    private String repoUrl;

    @NonNull
    public String getUserName() {
        return userName;
    }

    public String getFullName() {
        return FullName;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getEmail() {
        return email;
    }

    public String getRepoUrl() {
        return repoUrl;
    }
}

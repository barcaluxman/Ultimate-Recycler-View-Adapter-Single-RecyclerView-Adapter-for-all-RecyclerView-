package com.gurkhatech.mvppatterntest.githubUsersList.models;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;
import com.gurkhatech.mvppatterntest.R;
import com.gurkhatech.mvppatterntest.githubUsersList.viewholders.GitHubUserListViewHolder;
import com.gurkhatech.mvppatterntest.utils.lib.OmniAdapter;

/**
 * Created by adventure on 2/9/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

public class GithubUserData extends OmniAdapter.OmniModel {

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

    public GithubUserData(String userName) {
        this.userName = userName;
    }

    @NonNull
    public String getUserName() {
        return userName;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getRepoUrl() {
        return repoUrl;
    }


    @Override
    @LayoutRes
    public int getDefaultLayout() {
        return getUserName().length() > 10 ? R.layout.item_github_use_list : R.layout.item_github_use_list_alter;
    }

    @Override
    public Class getDefaultViewHolder() {
        return getUserName().length() > 10 ? GitHubUserListViewHolder.class : GitHubUserListViewHolder.class;
    }
}

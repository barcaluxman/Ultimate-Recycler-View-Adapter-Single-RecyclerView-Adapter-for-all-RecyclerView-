package com.gurkhatech.mvppatterntest.githubUsersList.models

import android.support.annotation.LayoutRes

import com.google.gson.annotations.SerializedName
import com.gurkhatech.mvppatterntest.R
import com.gurkhatech.mvppatterntest.githubUsersList.viewholders.GitHubUserListViewHolder
import com.gurkhatech.mvppatterntest.utils.lib.OmniAdapter

/**
 * Created by adventure on 2/9/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

class GithubUserDataKotlin(@SerializedName("login")
                           val userName: String) : OmniAdapter.OmniModel() {
    @SerializedName("name")
    private val FullName: String? = ""
    @SerializedName("html_url")
    val profileUrl: String? = ""
    @SerializedName("avatar_url")
    val avatarUrl: String? = ""
    @SerializedName("email")
    private val email: String? = ""
    @SerializedName("repos_url")
    val repoUrl: String? = ""


    @LayoutRes
    override fun getDefaultLayout(): Int {
        return if (userName.length > 10) R.layout.item_github_use_list else R.layout.item_github_use_list_alter
    }

    override fun getDefaultViewHolder(): Class<*> {
        return if (userName.length > 10) GitHubUserListViewHolder::class.java else GitHubUserListViewHolder::class.java
    }
}

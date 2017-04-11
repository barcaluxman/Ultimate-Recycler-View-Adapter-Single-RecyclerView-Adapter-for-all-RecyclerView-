package com.gurkhatech.mvppatterntest.githubUsersList.components.adapters;

import com.gurkhatech.mvppatterntest.githubUsersList.components.adapters.gurkha.lib.GithubAdapterData;
import com.gurkhatech.mvppatterntest.githubUsersList.components.adapters.gurkha.lib.GurkhaRecyclerAdapter;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by adventure on 2/10/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */
public class GithubUserListAdapter extends GurkhaRecyclerAdapter {
    private final List<GithubAdapterData> data;

    @Inject
    public GithubUserListAdapter(List<GithubAdapterData> data) {
        this.data = data;
    }
}

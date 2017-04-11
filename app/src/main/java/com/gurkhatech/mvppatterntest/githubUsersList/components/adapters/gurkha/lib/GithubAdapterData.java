package com.gurkhatech.mvppatterntest.githubUsersList.components.adapters.gurkha.lib;

/**
 * Created by Laxman Bhattarai on 4/11/17.
 * erluxman@gmail.com
 * https://github.com/erluxman
 * https://twitter.com/erluxman
 */

public class GithubAdapterData {
    private GurkhaRecyclerAdapter.GurkhaDTO dto;
    private GurkhaRecyclerAdapter.GurkhaViewHolder viewHolder;

    GurkhaRecyclerAdapter.GurkhaDTO getDto() {
        return dto;
    }

    GurkhaRecyclerAdapter.GurkhaViewHolder getViewHolder() {
        return viewHolder;
    }

    public GithubAdapterData(GurkhaRecyclerAdapter.GurkhaDTO dto, GurkhaRecyclerAdapter.GurkhaViewHolder viewHolder) {
        this.dto = dto;
        this.viewHolder = viewHolder;
    }

}

package com.gurkhatech.mvppatterntest.githubUsersList.components.adapters.gurkha.lib;

/**
 * Created by Laxman Bhattarai on 4/11/17.
 * erluxman@gmail.com
 * https://github.com/erluxman
 * https://twitter.com/erluxman
 */

public class GithubAdapterData {
    private  GurkhaDTO dto;
    private GurkhaViewHolder viewHolder;

    public GurkhaDTO getDto() {
        return dto;
    }

    public GurkhaViewHolder getViewHolder() {
        return viewHolder;
    }

    public GithubAdapterData(GurkhaDTO dto, GurkhaViewHolder viewHolder) {
        this.dto = dto;
        this.viewHolder = viewHolder;
    }

}

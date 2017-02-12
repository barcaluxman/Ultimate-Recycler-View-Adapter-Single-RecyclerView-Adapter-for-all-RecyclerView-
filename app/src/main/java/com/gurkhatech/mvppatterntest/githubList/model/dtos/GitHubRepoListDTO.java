package com.gurkhatech.mvppatterntest.githubList.model.dtos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by adventure on 2/9/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

public class GitHubRepoListDTO {

@SerializedName("items")
private List < GitHubRepoItemDTO > list;

public List < GitHubRepoItemDTO > getList ( ) {
    return list;
}
}

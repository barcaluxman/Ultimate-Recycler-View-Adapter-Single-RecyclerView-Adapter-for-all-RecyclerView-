package com.gurkhatech.mvppatterntest.githubList.view;

import com.gurkhatech.mvppatterntest.githubList.model.GithubUserDTO;

import java.util.List;

/**
 * Created by adventure on 2/9/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

public interface IGithubListView  {
void setList( List<GithubUserDTO> data);
void triggerSearch();
void initList();
}

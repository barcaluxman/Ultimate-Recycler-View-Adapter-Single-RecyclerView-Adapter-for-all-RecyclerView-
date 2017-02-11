package com.gurkhatech.mvppatterntest.githubList.model;

import java.util.List;

/**
 * Created by adventure on 2/9/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

public interface IGithubListModel {
List<GithubUserDTO> getUserList( String name);
void cancelNetworkCall();

}

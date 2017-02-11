package com.gurkhatech.mvppatterntest.githubList.constants.modules;

import com.bumptech.glide.RequestManager;
import com.gurkhatech.mvppatterntest.githubList.model.GithubAPIService;

import dagger.Component;

/**
 * Created by adventure on 2/11/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */
@Component(modules = { GithubApiServiceModule.class, GlideModule.class })
public interface GithubAppListComponent {

RequestManager getGlideRequestManager ( );

GithubAPIService getGitHubApiService ( );
}

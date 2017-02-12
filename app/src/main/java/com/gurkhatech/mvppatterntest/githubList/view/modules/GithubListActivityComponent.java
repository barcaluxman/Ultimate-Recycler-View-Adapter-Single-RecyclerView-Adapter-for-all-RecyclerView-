package com.gurkhatech.mvppatterntest.githubList.view.modules;

import com.gurkhatech.mvppatterntest.githubList.view.GithubListActivity;

import dagger.Component;

/**
 * Created by adventure on 2/11/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */
@SuppressWarnings("WeakerAccess")
@GithubListActivityScope
@Component(modules = { GithubListActivityModule.class, GlideActivityModule.class })
public interface GithubListActivityComponent {
void inject ( GithubListActivity activity );
}

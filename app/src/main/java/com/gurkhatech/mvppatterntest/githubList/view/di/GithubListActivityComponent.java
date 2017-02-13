package com.gurkhatech.mvppatterntest.githubList.view.di;

import com.gurkhatech.mvppatterntest.githubList.GithubListActivity;
import com.gurkhatech.mvppatterntest.githubList.GithubListModel;

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
@Component(modules = { ContextModule.class, GlideModule.class,GithubApiServiceModule.class })
public interface GithubListActivityComponent {
void injectGithubListActivity ( GithubListActivity activity );
void injectGithubListModel( GithubListModel model);
}

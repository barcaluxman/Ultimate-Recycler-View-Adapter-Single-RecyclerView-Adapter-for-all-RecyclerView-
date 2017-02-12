package com.gurkhatech.mvppatterntest.githubList.view.modules;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;

import com.bumptech.glide.RequestManager;
import com.gurkhatech.mvppatterntest.githubList.view.GithubListActivity;
import com.gurkhatech.mvppatterntest.githubList.view.GithubUserListAdapter;

import dagger.Component;

/**
 * Created by adventure on 2/11/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */
@GithubListActivityScope
@Component(modules = { GithubListActivityModule.class, GlideActivityModule.class })
public interface GithubListActivityComponent {
void inject( GithubListActivity activity);
}

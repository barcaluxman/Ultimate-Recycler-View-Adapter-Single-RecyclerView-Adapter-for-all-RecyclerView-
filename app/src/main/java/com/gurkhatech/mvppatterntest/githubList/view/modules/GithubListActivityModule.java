package com.gurkhatech.mvppatterntest.githubList.view.modules;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;

import com.bumptech.glide.RequestManager;
import com.gurkhatech.mvppatterntest.githubList.view.GithubListActivity;
import com.gurkhatech.mvppatterntest.githubList.view.GithubUserListAdapter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by adventure on 2/11/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

@Module
public class GithubListActivityModule {
private final GithubListActivity githubListActivity;


public GithubListActivityModule ( GithubListActivity activity ) {
    this.githubListActivity = activity;

}

@Provides
@GithubListActivityScope
GithubListActivity activity ( ) {
    return this.githubListActivity;
}

@Provides
@GithubListActivityScope
LinearLayoutManager linearLayoutManager(GithubListActivity activity){
    return  new LinearLayoutManager ( activity );
}
}

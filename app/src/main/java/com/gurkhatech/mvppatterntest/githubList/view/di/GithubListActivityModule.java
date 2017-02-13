package com.gurkhatech.mvppatterntest.githubList.view.di;

import android.support.v7.widget.LinearLayoutManager;

import com.gurkhatech.mvppatterntest.githubList.GithubListActivity;

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
GithubListActivity activity ( ) {
    return this.githubListActivity;
}

@Provides
LinearLayoutManager linearLayoutManager ( GithubListActivity activity ) {
    return new LinearLayoutManager ( activity );
}
}

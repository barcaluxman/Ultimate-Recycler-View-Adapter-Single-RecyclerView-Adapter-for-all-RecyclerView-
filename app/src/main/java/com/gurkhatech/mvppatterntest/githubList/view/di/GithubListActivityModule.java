package com.gurkhatech.mvppatterntest.githubList.view.di;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import com.gurkhatech.mvppatterntest.githubList.view.GithubListActivity;

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
private final Context githubListActivity;


public GithubListActivityModule ( Context activity ) {
    this.githubListActivity = activity;

}

@Provides
@GithubListActivityScope
Context activity ( ) {
    return this.githubListActivity;
}

@Provides
@GithubListActivityScope
LinearLayoutManager linearLayoutManager ( Context activity ) {
    return new LinearLayoutManager ( activity );
}
}

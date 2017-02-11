package com.gurkhatech.mvppatterntest.githubList.view.modules;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;

import com.bumptech.glide.RequestManager;
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

@Module(includes = {GlideActivityModule.class})
public class GithubListActivityModule {
private final Activity githubListActivity;


public GithubListActivityModule ( Activity activity ) {
    this.githubListActivity = activity;

}

@Provides
@GithubListActivityScope
Activity activity ( ) {
    return this.githubListActivity;
}

@Provides
@GithubListActivityScope
GithubUserListAdapter githubUserListAdapter ( RequestManager manager ) {
    return GithubUserListAdapter.getInstance ( manager );
}
@Provides
@GithubListActivityScope
LinearLayoutManager linearLayoutManager(Activity activity){
    return  new LinearLayoutManager ( activity );
}
}

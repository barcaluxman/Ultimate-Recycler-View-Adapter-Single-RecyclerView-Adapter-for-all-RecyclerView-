package com.gurkhatech.mvppatterntest.githubList.constants;

import android.app.Application;

import com.bumptech.glide.RequestManager;
import com.gurkhatech.mvppatterntest.githubList.constants.modules.ContextModule;
import com.gurkhatech.mvppatterntest.githubList.constants.modules.DaggerGithubAppListComponent;
import com.gurkhatech.mvppatterntest.githubList.constants.modules.GithubAppListComponent;
import com.gurkhatech.mvppatterntest.githubList.model.GithubAPIService;

/**
 * Created by adventure on 2/9/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

public class GithubApp extends Application {
public static GithubApp application;
GithubAppListComponent githubAppListComponent;
GithubAPIService githubAPIService;
RequestManager glideRequestManager;

public static GithubApp getInstance ( ) {
    application = ( application == null ) ? new GithubApp () : application;
    return application;
}


@Override
public void onCreate ( ) {
    super.onCreate ();
    application = this;
    githubAppListComponent = DaggerGithubAppListComponent.builder ()
            .contextModule ( new ContextModule ( this ) )
            .build ();
    githubAPIService = githubAppListComponent.getGitHubApiService ();
    glideRequestManager = githubAppListComponent.getGlideRequestManager ();

}

public GithubAPIService getGithubAPIService ( ) {
    return githubAPIService;
}

public RequestManager getGlideRequestManager ( ) {
    return glideRequestManager;
}


}

package com.gurkhatech.mvppatterntest.utils.oldrefrences;

import android.content.Context;
import android.support.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.gurkhatech.mvppatterntest.githubUsersList.GithubAPIService;
import com.gurkhatech.mvppatterntest.utils.commons.GithubListConstants;
import com.gurkhatech.mvppatterntest.utils.MyApplication;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by adventure on 2/9/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

public class GitHubRestClientStandAlone {

private static GitHubRestClientStandAlone gitHubRestClientStandAlone;
private GithubAPIService githubAPIService;


private RequestManager glideRequestManager;

private GitHubRestClientStandAlone ( Context context ) {
    final Interceptor interceptor = new Interceptor () {
        @Override
        public Response intercept ( Chain chain ) throws IOException {
            Request request = chain.request ();
            if (!String.valueOf ( request.url ().uri ().getPath () ).equals ( GithubListConstants.AUTH_URL )) {
                request = request
                        .newBuilder ()
                        .header ( "Cache-control", "public, max-age=" + GithubListConstants.GITHUB_CACHE_TIME_OUT )
                        .build ();

            }
            return chain.proceed ( request );
        }
    };
    //Network
    Cache cache = new Cache ( context.getCacheDir (), GithubListConstants.GITHUB_CACHE_SIZE );

    OkHttpClient okHttpClient = new OkHttpClient.Builder ()
            .cache ( cache )
            .connectTimeout ( GithubListConstants.CONNECTION_TIME_OUT, TimeUnit.MILLISECONDS )
            .addInterceptor ( interceptor )
            .build ();

    //Glide
    glideRequestManager = Glide.with ( context );

    //Client computation
    Retrofit retrofit = new Retrofit
            .Builder ()
            .baseUrl ( GithubListConstants.BASE_URL )
            .addConverterFactory ( GsonConverterFactory.create () )
            .client ( okHttpClient )
            .build ();
    githubAPIService = retrofit.create ( GithubAPIService.class );

}

@NonNull
public static GitHubRestClientStandAlone getInstance ( ) {
    gitHubRestClientStandAlone = ( gitHubRestClientStandAlone == null ) ?
            new GitHubRestClientStandAlone ( MyApplication.getInstance () ) : gitHubRestClientStandAlone;
    return gitHubRestClientStandAlone;
}

@NonNull
public RequestManager getGlideRequestManager ( ) {
    return glideRequestManager;
}

@NonNull
public GithubAPIService getGithubAPIService ( ) {
    return githubAPIService;
}


}

package com.gurkhatech.mvppatterntest.githubList.constants;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.gurkhatech.mvppatterntest.githubList.model.GithubAPIService;
import com.gurkhatech.mvppatterntest.utils.Util;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
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

private GitHubRestClientStandAlone ( @NonNull final Context context ) {
    final Interceptor interceptor = new Interceptor () {
        @Override
        public Response intercept ( Chain chain ) throws IOException {
            Request request = chain.request ();
            if (!String.valueOf ( request.url ().uri ().getPath () ).equals ( GithubListConstants.AUTH_URL )) {
                if (Util.isInternetConnected ( context )) {
                    request = request.newBuilder ().header ( "Cache-control", "public, max-age=" + 60 ).build ();
                }
                else {
                    request = request.newBuilder ().header ( "Cache-control", "public, max-age=" + 60 * 60 ).build ();

                }
            }
            return chain.proceed ( request );
        }
    };
    OkHttpClient okHttpClient = new OkHttpClient.Builder ().cache ( new Cache ( GithubApp.getInstance ().getApplicationContext ().getCacheDir (), 300 * 1000 * 1000 ) ).addInterceptor ( interceptor ).build ();
    Retrofit retrofit = new Retrofit.Builder ().baseUrl ( GithubListConstants.BASE_URL ).addConverterFactory ( GsonConverterFactory.create () ).client ( okHttpClient ).build ();
    githubAPIService = retrofit.create ( GithubAPIService.class );

}

@NonNull
public static GitHubRestClientStandAlone getInstance ( ) {
    gitHubRestClientStandAlone = ( gitHubRestClientStandAlone == null ) ? new GitHubRestClientStandAlone ( GithubApp.getInstance () ) : gitHubRestClientStandAlone;
    return gitHubRestClientStandAlone;
}

@NonNull
public GithubAPIService getGithubAPIService ( ) {
    return githubAPIService;
}

@Nullable
public Object synchronousCall ( @NonNull final Call call ) {
    final ArrayList < Object > responseArray = new ArrayList <> ();
    Thread t = new Thread () {
        @Override
        public void run ( ) {
            retrofit2.Response response;
            try {
                response = call.execute ();
                if (response.isSuccessful ()) {
                    responseArray.add ( 0, response.body () );
                }
            } catch (IOException e) {
                Util.log ( e.getMessage () );
            }

        }
    };

    try {
        t.start ();
        t.join ( 20000 );
    } catch (InterruptedException e) {
        e.printStackTrace ();
    }
    return responseArray.size () > 0 ? responseArray.get ( 0 ) : new Object ();
}
}

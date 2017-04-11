package com.gurkhatech.mvppatterntest.utils.di;

import android.content.Context;

import com.gurkhatech.mvppatterntest.utils.commons.GithubListConstants;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by adventure on 2/11/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

@Module(includes = {ContextModule.class})
class NetworkModule {

@Provides
Interceptor interceptor ( ) {
    return new Interceptor () {
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
}

@Provides
OkHttpClient okHttpClient ( Interceptor interceptor, Cache cache ) {
    return new OkHttpClient.Builder ()
            .cache ( cache )
            .connectTimeout ( GithubListConstants.CONNECTION_TIME_OUT, TimeUnit.MILLISECONDS )
            .addInterceptor ( interceptor )
            .build ();
}


@Provides
Cache cache ( Context context ) {
    return new Cache ( context.getCacheDir (), GithubListConstants.GITHUB_CACHE_SIZE );

}
}

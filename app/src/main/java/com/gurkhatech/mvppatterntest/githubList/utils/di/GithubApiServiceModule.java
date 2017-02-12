package com.gurkhatech.mvppatterntest.githubList.utils.di;

import com.gurkhatech.mvppatterntest.githubList.utils.GithubListConstants;
import com.gurkhatech.mvppatterntest.githubList.utils.GithubAPIService;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by adventure on 2/11/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */
@Module (includes = {NetworkModule.class})
class GithubApiServiceModule {

@Provides
GithubAPIService githubAPIService ( Retrofit retrofit ){
   return retrofit.create ( GithubAPIService.class );
}

@Provides
Retrofit retrofit ( OkHttpClient okHttpClient ){
    return new Retrofit
            .Builder ()
            .baseUrl ( GithubListConstants.BASE_URL )
            .addConverterFactory ( GsonConverterFactory.create () )
            .client ( okHttpClient )
            .build ();
}
}

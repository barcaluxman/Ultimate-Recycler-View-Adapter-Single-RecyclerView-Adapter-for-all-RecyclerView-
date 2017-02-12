package com.gurkhatech.mvppatterntest.githubList.utils.di;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import dagger.Module;
import dagger.Provides;

/**
 * Created by adventure on 2/11/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

@Module(includes = { ContextModule.class })
class GlideModule {

@Provides
RequestManager requestManager ( Context context ) {
    return Glide.with ( context );
}
}

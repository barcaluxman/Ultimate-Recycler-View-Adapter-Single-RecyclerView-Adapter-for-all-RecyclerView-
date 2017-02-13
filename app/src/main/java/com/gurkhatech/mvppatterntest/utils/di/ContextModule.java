package com.gurkhatech.mvppatterntest.utils.di;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

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
public class ContextModule {

private final Context context;

public ContextModule ( Context context ) {
    this.context = context;
}

@Provides
Context context ( ) {
    return this.context;
}

@Provides
LinearLayoutManager linearLayoutManager ( Context context ) {
    return new LinearLayoutManager ( context );
}


}

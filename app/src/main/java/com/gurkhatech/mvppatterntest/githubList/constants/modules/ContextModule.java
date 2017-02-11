package com.gurkhatech.mvppatterntest.githubList.constants.modules;

import android.content.Context;

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
public ContextModule(Context context){
    this.context = context;
}

@Provides
Context context(){
return  this.context;
}
}

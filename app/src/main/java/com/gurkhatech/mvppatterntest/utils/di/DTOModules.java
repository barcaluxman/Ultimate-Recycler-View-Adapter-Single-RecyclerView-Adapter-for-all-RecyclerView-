package com.gurkhatech.mvppatterntest.utils.di;


import com.gurkhatech.mvppatterntest.utils.lib.SwissKnifeRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * Created by adventure on 2/13/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

@Module
class DTOModules {


    @Provides
    List<SwissKnifeRecyclerViewAdapter.SwissKnifeData> adapterData() {
        return new ArrayList<>();
    }
}

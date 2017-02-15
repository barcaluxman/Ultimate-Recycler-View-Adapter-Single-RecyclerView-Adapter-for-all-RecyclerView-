package com.gurkhatech.mvppatterntest.githubList.components.adapters.gurkh.lib;

import android.support.v7.widget.RecyclerView;

/**
 * Created by adventure on 2/15/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

public abstract class GurkhaRecyclerAdapter < G extends RecyclerView.ViewHolder > extends RecyclerView.Adapter < GurkhaViewHolder > {

public abstract GurkhaDTO addToMap ( GurkhaMap.GurkhaMapDTO dto );


}

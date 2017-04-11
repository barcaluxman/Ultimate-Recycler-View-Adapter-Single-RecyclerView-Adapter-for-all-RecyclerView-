package com.gurkhatech.mvppatterntest.githubUsersList.components.adapters.gurkha.lib;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by adventure on 2/15/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

@SuppressWarnings("unused")
public abstract class GurkhaRecyclerAdapter extends RecyclerView.Adapter < GurkhaViewHolder > {

public abstract void replaceData ( @NonNull List <GithubAdapterData> dtoList );

public void addDataItem ( @NonNull GithubAdapterData dto ) {
}

public void addDataList ( @NonNull List <GithubAdapterData> dtoList ) {
}
}

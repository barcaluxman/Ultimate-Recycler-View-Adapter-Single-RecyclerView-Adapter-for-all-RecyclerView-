package com.gurkhatech.mvppatterntest.githubUsersList.components.adapters.gurkha.lib;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by adventure on 2/14/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

public abstract class GurkhaViewHolder extends RecyclerView.ViewHolder {
public GurkhaViewHolder ( View itemView ) {
    super ( itemView );

}

public abstract void bindView ( GurkhaDTO data );


}

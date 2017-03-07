package com.gurkhatech.mvppatterntest.githubList.components.adapters.gurkha.lib;

import android.support.annotation.LayoutRes;

public class GurkhaComboDTO {

@LayoutRes
private Integer resId;
private GurkhaDTO dto;
private Class viewHolderClass;

public GurkhaComboDTO ( Integer resId, GurkhaDTO dto, Class viewHolderClass ) {
    this.resId = resId;
    this.dto = dto;
    this.viewHolderClass = viewHolderClass;
}

public Integer getResId ( ) {
    return resId;
}

public GurkhaDTO getGurkhaDto ( ) {
    return dto;
}

Class getViewHolder ( ) {
    return viewHolderClass;
}
}
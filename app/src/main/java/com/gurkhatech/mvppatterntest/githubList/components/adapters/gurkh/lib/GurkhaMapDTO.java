package com.gurkhatech.mvppatterntest.githubList.components.adapters.gurkh.lib;

import android.support.annotation.LayoutRes;

public class GurkhaMapDTO{
    @LayoutRes
    private  Integer resId;
    private GurkhaDTO dto;
    private Class viewHolderClass;

    public GurkhaMapDTO ( Integer resId, GurkhaDTO dto, Class viewHolderClass ) {
        this.resId = resId;
        this.dto = dto;
        this.viewHolderClass = viewHolderClass;
    }

    Integer getResId ( ) {
        return resId;
    }

    public GurkhaDTO getDto ( ) {
        return dto;
    }

    Class getViewHolder ( ) {
        return viewHolderClass;
    }
}
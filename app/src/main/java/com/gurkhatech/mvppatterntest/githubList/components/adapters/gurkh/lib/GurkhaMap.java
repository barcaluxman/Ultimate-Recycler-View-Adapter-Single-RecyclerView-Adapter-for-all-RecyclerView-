package com.gurkhatech.mvppatterntest.githubList.components.adapters.gurkh.lib;

import android.annotation.SuppressLint;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by adventure on 2/15/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

public class GurkhaMap {


private HashMap< Integer, Class > dataIdAndViewHolder;
private HashMap < Integer, GurkhaDTO > dataIdAndDTO;

@LayoutRes
public Integer getResIdFromDTO ( GurkhaDTO dto ) {
    return invertIDDTO ( dataIdAndDTO ).get ( dto );
}

private Map< GurkhaDTO, Integer > invertIDDTO ( Map < Integer, GurkhaDTO > map ) {
    Map < GurkhaDTO, Integer > inverted = new HashMap <> ();
    for (Map.Entry < Integer, GurkhaDTO > entry : map.entrySet ()) {
        inverted.put ( entry.getValue (), entry.getKey () );
    }
    return inverted;
}

@SuppressWarnings("TryWithIdenticalCatches")
public GurkhaViewHolder getViewHolderFromResId ( @LayoutRes Integer layoutRes, ViewGroup parent ) {
    Class < ? > c = dataIdAndViewHolder.get ( layoutRes );
    Constructor< ? > cons = null;
    try {
        cons = c.getConstructor ( View.class );
    } catch (NoSuchMethodException e) {
        e.printStackTrace ();
    }
    LayoutInflater inflater = LayoutInflater.from ( parent.getContext () );
    View v = inflater.inflate ( layoutRes, parent, false );
    Object object = null;
    try {
        assert cons != null;
        object = cons.newInstance ( v );
    } catch (IllegalAccessException e) {
        e.printStackTrace ();
    } catch (InstantiationException e) {
        e.printStackTrace ();
    } catch (InvocationTargetException e) {
        e.printStackTrace ();
    }
    return (GurkhaViewHolder) object;

}

@SuppressLint("UseSparseArrays")
public GurkhaDTO putData ( GurkhaMapDTO gurkhaMapDTO ) {
    if (dataIdAndViewHolder == null) {
        dataIdAndViewHolder = new HashMap <> ();
    }

    if (dataIdAndDTO == null) {
        dataIdAndDTO = new HashMap <> ();
    }
    dataIdAndViewHolder.put ( gurkhaMapDTO.getResId (), gurkhaMapDTO.getViewHolder () );
    dataIdAndDTO.put ( gurkhaMapDTO.getResId (), gurkhaMapDTO.getDto () );
    return gurkhaMapDTO.getDto ();
}

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

}

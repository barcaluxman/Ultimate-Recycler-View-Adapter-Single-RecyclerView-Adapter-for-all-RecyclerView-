package com.gurkhatech.mvppatterntest.githubList.components.adapters.gurkha.lib;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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

public abstract void replaceData ( @NonNull List < GurkhaComboDTO > dtoList );

public void addDataItem ( @NonNull GurkhaComboDTO dto ) {
}

public void addDataList ( @NonNull List < GurkhaComboDTO > dtoList ) {
}


@SuppressWarnings("TryWithIdenticalCatches")
protected GurkhaViewHolder getViewHolderFromResId ( @LayoutRes Integer layoutRes, ViewGroup parent, Class viewHolder ) {
    //Class < ? > c = dataIdAndViewHolder.get ( layoutRes );
    Constructor < ? > cons = null;
    try {
        cons = ( (Class < ? >) viewHolder ).getConstructor ( View.class );
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

protected Class getViewHolderClassByLayoutID ( List < GurkhaComboDTO > data, int id ) {
    for (int i = 0 ; i < data.size () ; i++) {
        if (data.get ( i ).getResId () == id) {
            return data.get ( i ).getViewHolder ();
        }
    }
    return null;
}


}

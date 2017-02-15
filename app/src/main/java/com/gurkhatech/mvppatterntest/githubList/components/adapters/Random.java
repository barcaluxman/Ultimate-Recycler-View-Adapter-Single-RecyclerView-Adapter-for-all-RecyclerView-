package com.gurkhatech.mvppatterntest.githubList.components.adapters;

import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gurkhatech.mvppatterntest.githubList.components.viewholders.GitHubUserListViewHolder;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by adventure on 2/14/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

class Random {
@SuppressWarnings("TryWithIdenticalCatches")
static GitHubUserListViewHolder getViewHolderFromResId ( @LayoutRes Integer layoutRes, ViewGroup parent ) {
    GitHubUserListViewHolder viewHolder = new GitHubUserListViewHolder ( parent );
    //Class < ? > c = viewHolder.getClass ();
    Class < ? > c = GitHubUserListViewHolder.class;
    Constructor < ? > cons = null;
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
    return (GitHubUserListViewHolder) object;

}
}

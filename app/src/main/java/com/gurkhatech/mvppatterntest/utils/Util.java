package com.gurkhatech.mvppatterntest.utils;

import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.ColorInt;
import android.util.Log;
import android.widget.Toast;

import com.gurkhatech.mvppatterntest.BuildConfig;
import com.gurkhatech.mvppatterntest.R;
import com.gurkhatech.mvppatterntest.githubList.utils.GithubApp;

/**
 * Created by adventure on 2/2/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

public class Util {

public static void toast ( String s, Context c ) {
    Toast.makeText ( c, s, Toast.LENGTH_LONG ).show ();
}

public static void toast ( String s ) {
    Toast.makeText ( GithubApp.getInstance (), s, Toast.LENGTH_LONG ).show ();
}

public static void log ( String s ) {
    log ( GithubApp.getInstance ().getString ( R.string.default_log_filter ), s );
}

private static void log ( String s, String text ) {
    if (BuildConfig.DEBUG) Log.d ( s, text );
}

@ColorInt
public static int getComplimentaryColor ( @ColorInt int color ) {
    return Color.rgb (
            255 - Color.red ( color ),
            255 - Color.green ( color ),
            255 - Color.blue ( color )
    );
}

public static boolean isInternetConnected ( Context context ) {
    ConnectivityManager connectivityManager
            = (ConnectivityManager) context.getSystemService ( Context.CONNECTIVITY_SERVICE );
    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo ();
    return activeNetworkInfo != null && activeNetworkInfo.isConnected ();
}

}

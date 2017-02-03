package com.gurkhatech.mvppatterntest.utils;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.util.Log;
import android.widget.Toast;

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
static void log ( String s ) {
    log ( "datatest",s );
}
private static void log ( String s, String text ) {
    Log.i ( s,text );
}

@ColorInt
public static int getComplimentaryColor ( @ColorInt int color ) {
    return Color.rgb (
            255 - Color.red ( color ),
            255 - Color.green ( color ),
            255 - Color.blue ( color )
    );
}

}

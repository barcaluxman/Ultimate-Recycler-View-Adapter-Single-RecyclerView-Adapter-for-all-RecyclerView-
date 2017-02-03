package com.gurkhatech.mvppatterntest.orientationinfo.view;

import android.content.Context;
import android.support.annotation.ColorInt;

/**
 * Created by adventure on 2/2/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */
public interface IHomeView {
Context getContext ( );

void showScreenOrientationInfo ( String info );

void setBackGroundColor ( @ColorInt int color );

void setTextColor ( @ColorInt int color );
void displayFromBG ( );
}

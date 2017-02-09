package com.gurkhatech.mvppatterntest.colorlist.presenter;

/**
 * Created by adventure on 2/4/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

public interface IColorLoaderListener {

void onColorLoaded(String text);
void colorLoadFailed(String text);
}


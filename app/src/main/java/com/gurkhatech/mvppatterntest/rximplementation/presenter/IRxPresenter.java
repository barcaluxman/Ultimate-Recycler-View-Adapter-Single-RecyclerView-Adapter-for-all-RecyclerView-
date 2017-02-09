package com.gurkhatech.mvppatterntest.rximplementation.presenter;

/**
 * Created by adventure on 2/7/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

public interface IRxPresenter {

Runnable setUpRx ( );

void callAMethod ( Runnable runnable );

Runnable sayHello ( );

Runnable sayHi ( );
}

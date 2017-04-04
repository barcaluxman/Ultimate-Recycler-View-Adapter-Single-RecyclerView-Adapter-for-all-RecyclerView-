package com.gurkhatech.mvppatterntest.rximplementation;

/**
 * Created by adventure on 2/13/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

public interface RxContract {
    interface View {

        void displayText(String s);
    }


    interface Presenter {

        Runnable setUpRx();

        void callAMethod(Runnable runnable);

        Runnable sayHello();

        Runnable sayHi();

        void unSubscribeRx();
    }

}

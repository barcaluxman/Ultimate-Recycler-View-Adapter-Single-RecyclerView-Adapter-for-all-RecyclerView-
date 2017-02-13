package com.gurkhatech.mvppatterntest.utils.others;

import android.support.annotation.NonNull;

import com.gurkhatech.mvppatterntest.utils.Util;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;

/**
 * Created by adventure on 2/11/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

public class OkHttpSynchronous {
private static OkHttpSynchronous synchronous;
public static OkHttpSynchronous getInstance(){
    synchronous = synchronous != null ? synchronous : new OkHttpSynchronous ();
    return synchronous;
}
@NonNull
public Object synchronousCall ( @NonNull final Call call ) {
    final ArrayList< Object > responseArray = new ArrayList <> ();
    Thread t = new Thread () {
        @Override
        public void run ( ) {
            retrofit2.Response response;
            try {
                response = call.execute ();
                if (response.isSuccessful ()) {
                    responseArray.add ( 0, response.body () );
                }
            } catch (IOException e) {
                Util.log ( "here"+e.getMessage () );
            }

        }
    };

    try {
        t.start ();
        t.join ();  //wait for the thread to finish running
    } catch (InterruptedException e) {
        e.printStackTrace ();
    }
    return responseArray.size () > 0 ?
            responseArray.get ( 0 ) : new Object (); // ! Do not return null !


}
}

package com.gurkhatech.mvppatterntest.utils;

import android.support.v7.app.AppCompatActivity;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by adventure on 2/3/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */


public class OKHttpSingleton extends AppCompatActivity {

private static OKHttpSingleton okHttpSingleton;
private OkHttpClient client;


private OKHttpSingleton ( ) {
    client = new OkHttpClient ();

}

public static OKHttpSingleton getInstance ( ) {
    if (okHttpSingleton == null) {
        okHttpSingleton = new OKHttpSingleton ();
    }
    return okHttpSingleton;
}
public OkHttpClient getClient ( ) {
    return client;
}

public static void testOKHttpUrl ( String url ) {
    OkHttpClient client = OKHttpSingleton.getInstance ().getClient ();
    Request request = new Request.Builder ().url ( url).build ();
    client.newCall ( request ).enqueue ( new Callback () {
        @Override
        public void onFailure ( Call call, IOException e ) {
            Util.log ( e.getMessage () );
        }

        @Override
        public void onResponse ( Call call, Response response ) throws IOException {
            Util.log ( response.body ().string () );

        }
    } );

}


}

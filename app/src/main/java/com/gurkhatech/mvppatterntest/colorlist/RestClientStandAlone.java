package com.gurkhatech.mvppatterntest.colorlist;

import android.content.Context;

import com.gurkhatech.mvppatterntest.utils.MyApplication;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.gurkhatech.mvppatterntest.colorlist.Constants.BASE_URL;

/**
 * Created by adventure on 2/4/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

class RestClientStandAlone {

private static RestClientStandAlone restClientStandAlone;
private APIService apiService;

private RestClientStandAlone ( final Context context ) {
    Interceptor interceptor = new Interceptor () {
        @Override
        public okhttp3.Response intercept ( Chain chain ) throws IOException {

            Request request = chain.request ();
            if (!String.valueOf ( request.url ().uri ().getPath () ).equals ( Constants.END_COLORS_LIST )) {
                if (com.gurkhatech.mvppatterntest.utils.Util.isInternetConnected ( context )) {
                    request = request.newBuilder ().header ( "Cache-control", "public, max-age=" + 60 ).build ();
                }
                else {
                    request = request.newBuilder ().header ( "Cache-control", "public, max-age=" + 60 * 60 ).build ();

                }
            }
            return chain.proceed ( request );
        }
    };

    OkHttpClient client = new OkHttpClient.Builder ().cache ( new Cache ( MyApplication.getInstance ().getApplicationContext ().getCacheDir (), 300 ) ).addInterceptor ( interceptor ).build ();
    Retrofit retrofit = new Retrofit.Builder ().addConverterFactory ( GsonConverterFactory.create () ).baseUrl ( BASE_URL ).client ( client ).build ();
    apiService = retrofit.create ( APIService.class );
}

public static RestClientStandAlone getInstance ( ) {
    if (restClientStandAlone == null) {
        restClientStandAlone = new RestClientStandAlone ( MyApplication.getInstance () );
    }
    return restClientStandAlone;
}

APIService getApiService ( ) {
    return apiService;
}

Object callForResponse ( final Call call ) {

    final ArrayList < Object > responseArray = new ArrayList <> ();

    Thread thread = new Thread () {
        @Override
        public void run ( ) {
            Response response;
            try {
                response = call.execute ();
                if (response.isSuccessful ()) {
                    responseArray.add ( 0, response.body () );
                }
                // TODO do sth here when user cannot connect to the server

            } catch (IOException e) {
                e.printStackTrace ();
            }
        }
    };


    try {
        thread.start ();
        thread.join ();
    } catch (InterruptedException e) {
        e.printStackTrace ();
    }

    if (responseArray.size () < 1) {
        return null;
    }
    return responseArray.get ( 0 );
}
}

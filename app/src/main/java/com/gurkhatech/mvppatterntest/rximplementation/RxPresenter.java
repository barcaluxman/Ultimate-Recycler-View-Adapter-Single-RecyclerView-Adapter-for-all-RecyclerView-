package com.gurkhatech.mvppatterntest.rximplementation;

import com.gurkhatech.mvppatterntest.utils.Util;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by adventure on 2/7/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

public class RxPresenter implements RxContract.Presenter {

private static RxPresenter presenter;
private String temp = "";
private RxContract.View rxView;

private RxPresenter ( RxContract.View view ) {
    this.rxView = view;
}


public static RxPresenter getInstance ( RxContract.View view ) {
    if (presenter == null) {
        presenter = new RxPresenter ( view );
    }
    return presenter;
}

@Override
public Runnable setUpRx ( ) {
    return new Runnable () {
        @Override
        public void run ( ) {

            Observable < String > onlineDataObservable = Observable.create ( new ObservableOnSubscribe < String > () {
                @Override
                public void subscribe ( ObservableEmitter < String > e ) throws Exception {
                    e.onNext ( getString () );
                    e.onComplete ();
                }
            } );
            Observable < String > onlineDataObservableHI = Observable.create ( new ObservableOnSubscribe < String > () {
                @Override
                public void subscribe ( ObservableEmitter < String > e ) throws Exception {
                    e.onNext ( getStringHI () );
                    e.onComplete ();
                }
            } );


            Observable < String > zipped = Observable.concat ( onlineDataObservable, onlineDataObservableHI );
            zipped.observeOn ( AndroidSchedulers.mainThread () )
                    .subscribeOn ( Schedulers.newThread () )
                    .subscribe ( new Observer < String > () {
                        @Override
                        public void onSubscribe ( Disposable d ) {

                        }

                        @Override
                        public void onNext ( String value ) {

                            Util.log ( value );
                            rxView.displayText ( value );


                        }

                        @Override
                        public void onError ( Throwable e ) {
                            Util.log ( e.getMessage () );
                        }

                        @Override
                        public void onComplete ( ) {

                        }
                    } );


        }
    };
}

@Override
public void callAMethod ( Runnable runnable ) {
    runnable.run ();
}

@Override
public Runnable sayHello ( ) {
    return new Runnable () {
        @Override
        public void run ( ) {
            rxView.displayText ( "Hello" );
        }
    };
}

@Override
public Runnable sayHi ( ) {
    return new Runnable () {
        @Override
        public void run ( ) {
            rxView.displayText ( "Hi" );
        }
    };
}

public String getString ( ) {

    for (int i = 0 ; i < 9999999 ; i++) {

        temp = i + "";
        if (i % 1000000 == 0) {
            Util.log ( temp );
        }

    }
    return temp;
}

private String getStringHI ( ) {

    for (int i = 0 ; i < 9999999 ; i++) {

        temp = i + "";
        if (i % 1000000 == 0) {
            Util.log ( temp + "HI" );

        }

    }
    return temp + "HI";
}
}

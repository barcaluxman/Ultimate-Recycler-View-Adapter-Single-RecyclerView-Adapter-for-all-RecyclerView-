package com.gurkhatech.mvppatterntest.colorlist.model;
import com.gurkhatech.mvppatterntest.colorlist.constants.RestClientStandAlone;
import com.gurkhatech.mvppatterntest.colorlist.presenter.IColorLoaderListener;

import retrofit2.Call;

/**
 * Created by adventure on 2/4/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

public class ColorModel {
public void downloadColor ( final IColorLoaderListener listener ) {
    APIService apiService = RestClientStandAlone.getInstance ().getApiService ();
    Call < ColorListDTO > call = apiService.requestForColorList ();
    ColorListDTO obj = (ColorListDTO) RestClientStandAlone.getInstance ().callForResponse ( call );
    if (obj != null) {
        listener.onColorLoaded ( "Array size" + obj.getColors ().get ( obj.getColors ().size () - 2 ).getColorName () + " " + obj.getColors ().get ( obj.getColors ().size () - 2 ).getHexValue () );

    }
    else {
        listener.colorLoadFailed ( "Color failed to load" );

    }

}
}

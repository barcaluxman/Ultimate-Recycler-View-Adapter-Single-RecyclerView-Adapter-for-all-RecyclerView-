package com.gurkhatech.mvppatterntest.colorlist;

import retrofit2.Call;

/**
 * Created by adventure on 2/4/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

class ColorModel {
void downloadColor ( final IColorLoaderListener listener ) {
    APIService apiService = RestClientStandAlone.getInstance ().getApiService ();
    Call < ColorListDTO > call = apiService.requestForColorList ();
    ColorListDTO obj = (ColorListDTO) RestClientStandAlone.getInstance ().callForResponse ( call );
    if (obj != null) {
        listener.onColorLoaded ( "Array size" + obj.colors.get ( obj.colors.size () - 2 ).colorName + " " + obj.colors.get ( obj.colors.size () - 2 ).hexValue );

    }
    else {
        listener.colorLoadFailed ( "Color failed to load" );

    }

}
}

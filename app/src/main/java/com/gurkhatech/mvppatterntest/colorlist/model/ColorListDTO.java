package com.gurkhatech.mvppatterntest.colorlist.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by adventure on 2/4/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

class ColorListDTO {

@SerializedName("colorsArray")
private
ArrayList < ColorDTO > colors;

ArrayList < ColorDTO > getColors ( ) {
    return colors;
}

@SuppressWarnings("WeakerAccess")
class ColorDTO {

    @SerializedName("colorName")
    @Expose
    String colorName;


    @SerializedName("hexValue")
    @Expose
    String hexValue;

    String getHexValue ( ) {
        return hexValue;
    }

    String getColorName ( ) {
        return colorName;
    }
}
}



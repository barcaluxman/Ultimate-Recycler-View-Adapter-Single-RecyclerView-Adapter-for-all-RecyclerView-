package com.gurkhatech.mvppatterntest.colorlist;

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

public class ColorListDTO {

@SerializedName("colorsArray")
ArrayList < ColorDTO > colors;


public class ColorDTO {

    @SerializedName("colorName")
    @Expose
    String colorName;
    @SerializedName("hexValue")
    @Expose
    String hexValue;
}
}



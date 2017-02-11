package com.gurkhatech.mvppatterntest.colorlist.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
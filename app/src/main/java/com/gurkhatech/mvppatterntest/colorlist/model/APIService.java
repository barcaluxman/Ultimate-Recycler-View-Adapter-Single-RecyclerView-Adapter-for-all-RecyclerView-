package com.gurkhatech.mvppatterntest.colorlist.model;

import com.gurkhatech.mvppatterntest.colorlist.constants.Constants;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by adventure on 2/4/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

public interface APIService {
@GET(Constants.END_COLORS_LIST)
Call<ColorListDTO > requestForColorList ();
}

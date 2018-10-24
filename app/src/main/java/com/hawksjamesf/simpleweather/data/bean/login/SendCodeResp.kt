package com.hawksjamesf.simpleweather.data.bean.login

import com.google.gson.annotations.SerializedName

/**
 * Copyright ® $ 2017
 * All right reserved.
 *
 * @author: hawks.jamesf
 * @since: Oct/23/2018  Tue
 */
data class SendCodeResp(
        @SerializedName("id")
        val profileId: Int,
        val mobile: String
)
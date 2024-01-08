package com.jamesfchen.mockserver.model

import com.jamesfchen.mockserver.model.weather.City

/**
 * Copyright ® $ 2017
 * All right reserved.
 *
 * @author: hawks.jamesf
 * @since: Sep/27/2018  Thu
 */
data class ListRes<T>(
        var cod: String,
        var message: Float,
        var cnt: Int,
        var list: MutableList<T>,
        var city: City
)
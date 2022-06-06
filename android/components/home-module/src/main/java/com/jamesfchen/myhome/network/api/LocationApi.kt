package com.jamesfchen.myhome.network.api

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.jamesfchen.myhome.BuildConfig
import com.jamesfchen.myhome.model.L7
import com.jamesfchen.myhome.network.Httper
import okhttp3.CacheControl
import okhttp3.Request
import okhttp3.Response
import java.io.InputStreamReader

object LocationApi {
    //location/datas
    suspend fun getDatas(): List<L7> {
        val r = Request.Builder().url("${BuildConfig.CONFIG_SERVER_BASE_URL}/location/datas")
//            .cacheControl(CacheControl.FORCE_NETWORK)
            .get()
            .build()
        val response = Httper.getInstance().sendRequest(r)
        val reader = JsonReader(InputStreamReader(response.body?.byteStream()))
        return Gson().fromJson(reader, object : TypeToken<List<L7>>() {}.type)
    }
}
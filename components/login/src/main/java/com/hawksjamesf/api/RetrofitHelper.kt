package com.hawksjamesf.api

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.hawksjamesf.login.BuildConfig
import com.hawksjamesf.network.DefaultAuthenticator
import com.hawksjamesf.network.DefaultDns
import com.hawksjamesf.network.adapter.ObservableOrMainCallAdapterFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import okhttp3.OkHttpClient
import okhttp3.internal.tls.OkHostnameVerifier
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.wire.WireConverterFactory
import java.security.KeyStore
import java.util.*
import java.util.concurrent.TimeUnit
import javax.net.ssl.*

/**
 * Copyright ® $ 2017
 * All right reserved.
 *
 * @author: hawks.jamesf
 * @since: May/21/2021  Fri
 */
object RetrofitHelper {
    fun createSiginApi(): SignInApi {
        val baseUrl = BuildConfig.BASE_URL

        val (sslSocketFactory, trustManager) = createMetadata()

        /***
         * 非对称密匙：
         * 对称密匙：
         */
        val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .pingInterval(1, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
//                .protocols(listOf(Protocol.HTTP_2))
//                .addInterceptor(URLInterceptor())
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .addNetworkInterceptor(StethoInterceptor())
//                .addNetworkInterceptor(MetricInterceptor())
//                .socketFactory(SocketFactory.getDefault())
                .sslSocketFactory(sslSocketFactory, trustManager)
                .hostnameVerifier(OkHostnameVerifier)
//                .certificatePinner(DefaultCertificatePinner())
//                .eventListenerFactory(PrintingEventListener.FACTORY)
//                .eventListener()
                .authenticator(DefaultAuthenticator())
                .dns(DefaultDns())
//                .proxy(DefaultProxy())
//                .proxyAuthenticator(DefaultProxyAuthenticator())
//                .proxySelector(DefaultProxySelector())
                .build()
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                //                .baseUrl("http://localhost:50195")
//                .client(okHttpClient)
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addCallAdapterFactory(ObservableOrMainCallAdapterFactory(AndroidSchedulers.mainThread()))
                //                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
//                .addConverterFactory(MoshiConverterFactory.create())
//                .addConverterFactory(ProtoConverterFactory.create())
                .addConverterFactory(WireConverterFactory.create())
                .build()
                .create(SignInApi::class.java)
    }

    data class SocketMetadata(val sslSocketFactory: SSLSocketFactory, val trustManager: X509TrustManager)

    private fun createMetadata(): SocketMetadata {

        //android system ssl(openssl)
        val trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm()).also {
            it.init(null as KeyStore?)
        }
        val trustManagers = trustManagerFactory.trustManagers
        if (trustManagers.size != 1 || trustManagers[0] !is X509TrustManager) {
            throw IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers))
        }
        val trustManager = trustManagers[0] as X509TrustManager

        val sslContext = SSLContext.getInstance("TLS")
        sslContext.init(null, arrayOf<TrustManager>(trustManager), null)
        val sslSocketFactory = sslContext.socketFactory

        //third-party platform
        return SocketMetadata(sslSocketFactory, trustManager)
    }
}
// IAudioServiceApi.aidl
package com.jamesfchen.av;

// Declare any non-default types here with import statements

interface IAudioServiceApi {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

    void setUriPath(String path);
    void start();
    void pause();
    void stop();
}

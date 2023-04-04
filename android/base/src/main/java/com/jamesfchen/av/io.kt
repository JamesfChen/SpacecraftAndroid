package com.jamesfchen.av

import android.system.ErrnoException
import android.system.Os
import android.system.OsConstants
import java.io.FileDescriptor
import java.io.IOException
import java.nio.ByteBuffer

/**
 * Copyright ® $ 2017
 * All right reserved.
 *
 * @author: hawks.jamesf
 * @since: Aug/16/2020  Sun
 */

@Throws(IOException::class)
fun readFully(fd: FileDescriptor?, to: ByteBuffer?) {


}
@Throws(IOException::class)
fun writeFully(fd: FileDescriptor?, from: ByteBuffer?) {
    if (fd == null || from == null) return
    // ByteBuffer position is not updated as expected by Os.write() on old Android versions, so
    // count the remaining bytes manually.
    // See <https://github.com/Genymobile/scrcpy/issues/291>.
    var remaining = from.remaining()
    while (remaining > 0) {
        try {
            val w = Os.write(fd, from)
            if (BuildConfig.DEBUG && w < 0) {
                // w should not be negative, since an exception is thrown on error
                throw java.lang.AssertionError("Os.write() returned a negative value ($w)")
            }
            remaining -= w
        } catch (e: ErrnoException) {
            if (e.errno != OsConstants.EINTR) {
                throw IOException(e)
            }
        }
    }
}

@Throws(IOException::class)
fun writeFully(fd: FileDescriptor?, buffer: ByteArray?, offset: Int, len: Int) {
    writeFully(fd, ByteBuffer.wrap(buffer, offset, len))
}
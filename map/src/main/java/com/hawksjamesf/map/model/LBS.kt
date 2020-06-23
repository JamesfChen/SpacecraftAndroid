package com.hawksjamesf.map.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class LBS {
    @PrimaryKey(autoGenerate = true)
    @get:JvmName("index")
    var index: Int = 0
    var needUpload=false
    @Embedded
    @get:JvmName("appCellInfo")
    var appCellInfo: AppCellInfo? = null
    @Embedded
    @get:JvmName("appLocation")
    var appLocation: AppLocation? = null

    override fun toString(): String {
        return "LBS(index=$index, needUpload=$needUpload, appCellInfo=$appCellInfo, appLocation=$appLocation)"
    }
}
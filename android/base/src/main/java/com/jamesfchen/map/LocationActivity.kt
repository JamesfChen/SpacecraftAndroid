package com.jamesfchen.map

import android.os.Bundle
import android.os.RemoteException
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.blankj.utilcode.util.NetworkUtils
import com.jamesfchen.common.util.DeviceUtil
import com.jamesfchen.map.model.AppCellInfo
import com.jamesfchen.map.model.AppLocation
import com.jamesfchen.map.model.LBS
import com.jamesfchen.map.model.LBSViewModel

/**
 * Copyright ® $ 2017
 * All right reserved.
 *
 * @author: hawks.jamesf
 * @since: Apr/27/2020  Mon
 */
class LocationActivity : LBSActivity() {
    private val viewModel by viewModels<LBSViewModel>()
    var ibsListenerStub: ILbsListener.Stub = object : ILbsListener.Stub() {
        val pid: Int
            get() = android.os.Process.myPid()

        @Throws(RemoteException::class)
        override fun onLocationChanged(appLocation: AppLocation?, appCellInfos: List<AppCellInfo>?, count: Long) {
//            this@LocationActivity.runOnUiThread(Runnable { bt_cellInfos.text = "统计次数：$count" })
            val s = StringBuffer()
            var appCellInfo:AppCellInfo?=null
            for (index in 0 until (appCellInfos?.size?:0)){
                s.append("${appCellInfos?.get(index)?.lac},${appCellInfos?.get(index)?.cid}  ")
                val theCell = appCellInfos?.get(index)
                if (theCell?.isRegistered == true){
                    appCellInfo =theCell
                }
            }
            Log.d(TAG, "onLocationChanged:index:" + count + "\n" +
                    "${appLocation?.lat},${appLocation?.lon}\n" +
                    s)
            bt_cellInfos.text = "统计次数：$count"
            viewModel.insert(appCellInfo, appLocation)
//            ReportApi.reportLocation(appLocation,appCellInfo,count, auth)
//            FileIOUtils.write2File(lbsFile, location, cellInfoList, count, auth)
        }

        @Throws(RemoteException::class)
        override fun onStatusChanged(s: String, i: Int, bundle: Bundle) {
//            Log.d(TAG, "onStatusChanged:$s  $i $bundle")
        }

        @Throws(RemoteException::class)
        override fun onProviderEnabled(s: String) {
            Log.d(TAG, "onProviderEnabled:$s")
        }

        @Throws(RemoteException::class)
        override fun onProviderDisabled(s: String) {
            Log.d(TAG, "onProviderDisabled:$s")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLocatioinBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val ipAddressByWifi = NetworkUtils.getIpAddressByWifi()
        val ipAddressipv4 = NetworkUtils.getIPAddress(true)
        val ipAddressipv6 = NetworkUtils.getIPAddress(false)
        Log.d(TAG, "onCreate: " + ipAddressByWifi + "  " + ipAddressipv4 + " " + ipAddressipv6)
        val macAddressByNetworkInterface = DeviceUtil.getMacAddressByNetworkInterface()
        val macAddressByInetAddress = DeviceUtil.getMacAddressByInetAddress()
        val macAddressByWifiInfo = DeviceUtil.getMacAddressByWifiInfo()
        val getMacAddressByFile = DeviceUtil.getMacAddressByFile()
        Log.d(TAG, "onCreate: 网卡：" + macAddressByNetworkInterface + "\n网络地址:" + macAddressByInetAddress + "\nwifi:" + macAddressByWifiInfo + "\nfile:" + getMacAddressByFile)

        val adapter = LbsAdapter()
        binding.rvCellinfos.adapter = adapter
        val observer = Observer(adapter::submitList)
        viewModel.allLbsDatas.observe(this, Observer<PagedList<LBS>> { p ->
            adapter.submitList(p)
            if (p.size > 2) {
                binding.rvCellinfos.smoothScrollToPosition(p.size - 1)
            }
        })
        viewModel.clearAll()
        binding.rvCellinfos.setOnRefreshListener {
            binding.rvCellinfos.isRefreshing = false
        }
//        val lbsDir = File(Environment.getExternalStorageDirectory().absoluteFile, "lbsPath")
//        if (!lbsDir.exists()) {
//            lbsDir.mkdir()
//        }
//        this.lbsFile = File(lbsDir, "lbsPath_" + System.currentTimeMillis() + ".json")
    }


    override fun onDestroy() {
        super.onDestroy()
    }

}
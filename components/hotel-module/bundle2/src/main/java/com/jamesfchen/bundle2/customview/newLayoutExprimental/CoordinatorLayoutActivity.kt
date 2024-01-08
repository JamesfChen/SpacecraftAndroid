package com.jamesfchen.bundle2.customview.newLayoutExprimental

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jamesfchen.bundle2.databinding.ActivityCoordinatorlayoutBinding
import com.jamesfchen.uicomponent.coordinator.ViewPagerAdapterv2

/**
 * Copyright ® $ 2019
 * All right reserved.
 *
 * @author: hawksjamesf
 * @email: hawksjamesf@gmail.com
 * @since: Feb/16/2019  Sat
 */
class CoordinatorLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCoordinatorlayoutBinding.inflate(layoutInflater)
       val  mSectionsPagerAdapter = ViewPagerAdapterv2()
        binding.tablayout.setupWithViewPager(binding.container)
        binding.container.adapter = mSectionsPagerAdapter

    }

}
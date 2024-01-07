package com.jamesfchen.main

import android.content.ComponentName
import android.content.Context
import android.content.ServiceConnection
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.view.drawToBitmap
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.transition.Transition
import com.jamesfchen.common.util.ConvertUtil.dp2px
import com.jamesfchen.main.databinding.FragmentInfosBinding
import com.jamesfchen.mockserver.service.MockIntentService
import io.reactivex.Observable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.internal.wait
import java.util.concurrent.TimeUnit

class InfosFragment : Fragment() {
    lateinit var binding: FragmentInfosBinding
    val infoViewModel: InfosViewModel by viewModels()
    val mainViewModel by activityViewModels<MainViewModel>()
    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentInfosBinding.inflate(inflater, container, false)
//        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_infos, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewmodel = infoViewModel
        Log.d("cjf", "onViewCreated")
//        binding.myTextView.poem
        lifecycleScope.launchWhenResumed {
            val defer = async(Dispatchers.IO) {
                Glide.get(context?.applicationContext!!).clearDiskCache()
                Log.d("baseimageview", "async")
            }
            Log.d("baseimageview", "wait before")
            defer.await()
            Log.d("baseimageview", "wait after")
            val images = getImageApi().getImages()
            for (image in images) {
                val imageView = ImageView(context)
                binding.ll.addView(imageView,LinearLayout.LayoutParams(dp2px(400f), dp2px(200f)))
                Glide.with(this@InfosFragment)
                    .asBitmap()
//                    .load(R.raw.parting_ways_600_300)
                    .load(image)
                    .addListener(object : RequestListener<Bitmap> {
                        override fun onLoadFailed(
                            e: GlideException?,
                            model: Any?,
                            target: Target<Bitmap>?,
                            isFirstResource: Boolean
                        ): Boolean {
                            return false
                        }

                        override fun onResourceReady(
                            resource: Bitmap?,
                            model: Any?,
                            target: Target<Bitmap>?,
                            dataSource: DataSource?,
                            isFirstResource: Boolean
                        ): Boolean {
                            Log.d(
                                "baseimageview",
                                "bitmap w/h:${resource?.width}/${resource?.height} size:${resource?.allocationByteCount} imageview w/h:${imageView.width}/${imageView.height} dataSource:${dataSource?.name}"
                            )
                            return false
                        }
                    })
//                    .into(imageView)
                    .into(object: CustomTarget<Bitmap>() {
                        override fun onResourceReady(
                            resource: Bitmap,
                            transition: Transition<in Bitmap>?
                        ) {
                            imageView.setImageBitmap(resource)
                        }

                        override fun onLoadCleared(placeholder: Drawable?) {
                        }
                    })
                MyIntentService.bindAndStartService(requireContext(), object : ServiceConnection {
                    override fun onServiceConnected(name: ComponentName?, service: IBinder?) {

                    }

                    override fun onServiceDisconnected(name: ComponentName?) {
                    }
                })
            }
        }

    }

}
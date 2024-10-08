package com.electrolytej.widget.recyclerview

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.electrolytej.base.R

class InsetDecoration(context: Context) : RecyclerView.ItemDecoration() {
    private var mInsets = 0
    init {
        mInsets = context.resources.getDimensionPixelSize(R.dimen.card_insets)
    }
    override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
    ) {
        outRect[mInsets, mInsets, mInsets] = mInsets
//        super.getItemOffsets(outRect, view, parent, state)
    }
}
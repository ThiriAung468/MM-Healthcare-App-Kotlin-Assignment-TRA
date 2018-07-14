package com.padcmyanmar.mmnews.kotlin.views.holders

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class BaseViewHolder<W>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    protected var mData: W? = null



    abstract fun setData(data: W)
}
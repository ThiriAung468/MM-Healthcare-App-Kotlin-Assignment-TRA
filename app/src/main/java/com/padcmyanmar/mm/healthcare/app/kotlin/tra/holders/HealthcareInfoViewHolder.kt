package com.padcmyanmar.mmnews.kotlin.views.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.padcmyanmar.mm.healthcare.app.kotlin.tra.data.vos.HealthcareInfoVO

import kotlinx.android.synthetic.main.view_holder_healthcare_info.view.*


class HealthcareInfoViewHolder(itemView: View) : BaseViewHolder<HealthcareInfoVO>(itemView) {


    override fun setData(data: HealthcareInfoVO) {
        mData = data
        if (data.healthcareImage != null) {
            Glide.with(itemView.context)
                    .load(data.healthcareImage)
                    .into(itemView.iv_image)

        }

        itemView.tv_title.text = data.healthcareTitle


    }


}
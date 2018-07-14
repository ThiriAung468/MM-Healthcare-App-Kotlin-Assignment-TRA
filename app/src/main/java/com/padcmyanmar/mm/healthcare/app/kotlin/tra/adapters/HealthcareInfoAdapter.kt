package com.padcmyanmar.mm.healthcare.app.kotlin.tra.adapters

import android.content.Context
import android.view.ViewGroup
import com.padcmyanmar.mm.healthcare.app.kotlin.tra.R
import com.padcmyanmar.mm.healthcare.app.kotlin.tra.data.vos.HealthcareInfoVO

import com.padcmyanmar.mmnews.kotlin.views.holders.HealthcareInfoViewHolder

class HealthcareInfoAdapter(context: Context) : BaseRecyclerAdapter<HealthcareInfoViewHolder, HealthcareInfoVO>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HealthcareInfoViewHolder {
        val healthcareInfoView = mLayoutInflator.inflate(R.layout.view_holder_healthcare_info, parent, false)
        return HealthcareInfoViewHolder(healthcareInfoView)
    }
}
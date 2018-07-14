package com.padcmyanmar.mmnews.kotlin.network.responses

import com.google.gson.annotations.SerializedName
import com.padcmyanmar.mm.healthcare.app.kotlin.tra.data.vos.HealthcareInfoVO

import java.util.ArrayList

class GetHealthcareInfoResponse {

    @SerializedName("code")
    private val code: Int = 0

    @SerializedName("message")
    private val message: String? = null


    @SerializedName("healthcare-info")
    private var healthcareInfoList: List<HealthcareInfoVO>? = null

    fun getCode(): Int {
        return code
    }

    fun getMessage(): String? {
        return message
    }



    fun getHealthcareInfoList(): List<HealthcareInfoVO> {
        if (healthcareInfoList == null) {
            healthcareInfoList = ArrayList<HealthcareInfoVO>()
        }
        val healthcareInfoListVal = healthcareInfoList
        return healthcareInfoListVal!!
    }
}
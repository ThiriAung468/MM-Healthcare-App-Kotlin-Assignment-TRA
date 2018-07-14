package com.padcmyanmar.mm.healthcare.app.kotlin.tra.data.models

import com.padcmyanmar.mm.healthcare.app.kotlin.tra.data.vos.HealthcareInfoVO
import com.padcmyanmar.mm.healthcare.app.kotlin.tra.utils.AppConstants
import com.padcmyanmar.mmnews.kotlin.events.DataEvent
import com.padcmyanmar.mmnews.kotlin.network.HealthcareInfoDataAgent
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class HealthcareInfoModel {
    companion object {
        private var INSTANCE: HealthcareInfoModel? = null
        // private lateinit var INSTANCE: HealthcareInfoModel ==> same the above
        fun getInstance(): HealthcareInfoModel {
            if (INSTANCE == null) {
                INSTANCE = HealthcareInfoModel()
            }

            val i = INSTANCE
            return i!!
        }
    }

    private constructor() {
        EventBus.getDefault().register(this)
    }
    private var mHealthcareInfoData: HashMap<Int, HealthcareInfoVO> = HashMap()

    fun loadHealthcareInfo() {
        HealthcareInfoDataAgent.getInstance().loadHealthcareInfo(AppConstants.ACCESS_TOKEN)
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onNewsLoadedEvent(healthcareInfoLoadedEvent: DataEvent.HealthcareInfoLoadedEvent) {
        for (info: HealthcareInfoVO in healthcareInfoLoadedEvent.loadedHealthcareInfo) {
            mHealthcareInfoData[info.healthcareId] = info
        }

    }
}
package com.padcmyanmar.mmnews.kotlin.events

import com.padcmyanmar.mm.healthcare.app.kotlin.tra.data.vos.HealthcareInfoVO


class DataEvent {

    class HealthcareInfoLoadedEvent( val loadedHealthcareInfo: List<HealthcareInfoVO>)

    class EmptyDataLoadedEvent(val errorMsg: String? = "Empty Body Response")
}
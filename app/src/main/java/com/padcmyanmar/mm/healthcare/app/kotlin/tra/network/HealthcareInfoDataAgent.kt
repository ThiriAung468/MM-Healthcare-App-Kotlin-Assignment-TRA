package com.padcmyanmar.mmnews.kotlin.network

import com.google.gson.Gson
import com.padcmyanmar.mmnews.kotlin.events.DataEvent
import com.padcmyanmar.mmnews.kotlin.events.ErrorEvent
import com.padcmyanmar.mmnews.kotlin.network.responses.GetHealthcareInfoResponse
import okhttp3.OkHttpClient
import org.greenrobot.eventbus.EventBus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class HealthcareInfoDataAgent {

    companion object {
        private var INSTANCE: HealthcareInfoDataAgent? = null
        fun getInstance(): HealthcareInfoDataAgent {
            if (INSTANCE == null) {
                INSTANCE = HealthcareInfoDataAgent()
            }

            val i = INSTANCE
            return i!!
        }
    }

    private val mNewsApi: NewsApi

    private constructor() {
        val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build()

        val retrofit = Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-5/")
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .client(okHttpClient)
                .build()

        mNewsApi = retrofit.create(NewsApi::class.java) // class type ko hte chin yin
    }

    fun loadHealthcareInfo(accessToken: String) {
        val healthcareInfoResponseCall = mNewsApi.loadHealthcare( accessToken)
        healthcareInfoResponseCall.enqueue(object : Callback<GetHealthcareInfoResponse> { //annonymous class ==> object :
            override fun onFailure(call: Call<GetHealthcareInfoResponse>?, t: Throwable?) {
                EventBus.getDefault().post(ErrorEvent.ApiErrorEvent(t))
            }

            override fun onResponse(call: Call<GetHealthcareInfoResponse>, response: Response<GetHealthcareInfoResponse>) {
                val healthcareInfoResponse: GetHealthcareInfoResponse? = response.body()
                if (healthcareInfoResponse != null
                        && healthcareInfoResponse.getCode() == 200
                        && healthcareInfoResponse.getHealthcareInfoList().isNotEmpty()) {
                    val healthcareInfoLoadedEvent = DataEvent.HealthcareInfoLoadedEvent( healthcareInfoResponse.getHealthcareInfoList())
                    EventBus.getDefault().post(healthcareInfoLoadedEvent)
                } else {
                    if(healthcareInfoResponse != null)
                        EventBus.getDefault().post(DataEvent.EmptyDataLoadedEvent(healthcareInfoResponse.getMessage()))
                    else
                        EventBus.getDefault().post(DataEvent.EmptyDataLoadedEvent())
                }
            }
        })
    }
}
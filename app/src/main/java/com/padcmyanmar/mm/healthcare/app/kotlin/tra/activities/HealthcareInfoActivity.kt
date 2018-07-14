package com.padcmyanmar.mm.healthcare.app.kotlin.tra.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.padcmyanmar.mm.healthcare.app.kotlin.tra.R
import com.padcmyanmar.mm.healthcare.app.kotlin.tra.adapters.HealthcareInfoAdapter
import com.padcmyanmar.mm.healthcare.app.kotlin.tra.data.models.HealthcareInfoModel
import com.padcmyanmar.mm.healthcare.app.kotlin.tra.data.vos.HealthcareInfoVO
import com.padcmyanmar.mmnews.kotlin.events.DataEvent
import kotlinx.android.synthetic.main.activity_healthcare_info.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class HealthcareInfoActivity : AppCompatActivity() {
    private var mHealthcareInfoAdapter: HealthcareInfoAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_healthcare_info)
        setSupportActionBar(toolbar)

        rv_get_healthcare_info.layoutManager = LinearLayoutManager(applicationContext)
        mHealthcareInfoAdapter = HealthcareInfoAdapter(applicationContext)
        rv_get_healthcare_info.adapter = mHealthcareInfoAdapter

        HealthcareInfoModel.getInstance().loadHealthcareInfo()



    }

    override fun onStart() {
        super.onStart()
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this)
        }
    }

    override fun onStop() {
        super.onStop()
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this)
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onNewsLoadedEvent(healthcareInfoLoadedEvent: DataEvent.HealthcareInfoLoadedEvent) {

        mHealthcareInfoAdapter!!.appendNewData(healthcareInfoLoadedEvent.loadedHealthcareInfo as MutableList<HealthcareInfoVO>)
    }
}
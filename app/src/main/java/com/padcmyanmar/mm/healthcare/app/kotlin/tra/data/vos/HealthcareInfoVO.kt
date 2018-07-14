package com.padcmyanmar.mm.healthcare.app.kotlin.tra.data.vos

import com.google.gson.annotations.SerializedName

open class HealthcareInfoVO(healthcareId: Int = 1,
                            healthcareTitle: String = "",
                            healthcareImage: String = "",
                            healthcareAuthor: AuthorVO? = null,
                            healthcareShortDec: String = "",
                            healthcarePubDate: String = "",
                            healthcareCompleteUrl: String = "") {

    @SerializedName("id")
    open var healthcareId: Int = healthcareId

    @SerializedName("title")
    var healthcareTitle: String = healthcareTitle

    @SerializedName("image")
    var healthcareImage: String = healthcareImage

    @SerializedName("author")
    var  healthcareAuthor: AuthorVO? = healthcareAuthor

    @SerializedName("short-description")
    var healthcareShortDec: String = healthcareShortDec

    @SerializedName("published-date")
    var healthcarePubDate: String = healthcarePubDate

    @SerializedName("complete-url")
    var healthcareCompleteUrl: String = healthcareCompleteUrl




}



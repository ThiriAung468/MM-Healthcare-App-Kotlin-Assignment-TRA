package com.padcmyanmar.mmnews.kotlin.network

import com.padcmyanmar.mmnews.kotlin.network.responses.GetHealthcareInfoResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface NewsApi {

    @FormUrlEncoded
    @POST("mm-healthcare/GetHealthcareInfo.php")
    fun loadHealthcare(
            @Field("access_token") accessToken: String) : Call<GetHealthcareInfoResponse>
}
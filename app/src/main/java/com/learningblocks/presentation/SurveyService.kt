package com.learningblocks.presentation

import com.learningblocks.domain.TokenBalance
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface SurveyService {
    @GET("call")
    fun pushTokens(): Call<TokenBalance>
}
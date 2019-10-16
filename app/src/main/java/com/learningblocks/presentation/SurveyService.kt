package com.learningblocks.presentation

import com.learningblocks.domain.NewTokenBalance
import com.learningblocks.domain.TokenBalance
import retrofit2.Call
import retrofit2.http.GET

interface SurveyService {
    @GET("call")
    fun pushTokens(): Call<TokenBalance>

    @GET("balance")
    fun getBalance(): Call<NewTokenBalance>
}
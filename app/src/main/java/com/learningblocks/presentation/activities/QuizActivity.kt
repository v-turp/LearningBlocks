package com.learningblocks.presentation.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioGroup
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.learningblocks.R
import com.learningblocks.domain.NewTokenBalance
import com.learningblocks.domain.TokenBalance
import com.learningblocks.presentation.SurveyService
import kotlinx.android.synthetic.main.activity_quiz.*
import kotlinx.android.synthetic.main.activity_transaction_history.*
import kotlinx.android.synthetic.main.activity_transaction_history.navigation
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QuizActivity: BaseActivity(), View.OnClickListener{

    var response1: Boolean = false
    var response2: Boolean = false
    var response3: Boolean = false
    var response4: Boolean = false
    var response5: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        rb_q1_true.setOnClickListener(this)
        rb_q1_false.setOnClickListener(this)

        rb_q2_true.setOnClickListener(this)
        rb_q2_false.setOnClickListener(this)

        rb_q3_true.setOnClickListener(this)
        rb_q3_false.setOnClickListener(this)

        rb_q4_true.setOnClickListener(this)
        rb_q4_false.setOnClickListener(this)

        rb_q5_true.setOnClickListener(this)
        rb_q5_false.setOnClickListener(this)
        getTokenBalance()
        btn_submit_survey.setOnClickListener(View.OnClickListener {
            val BASE_URL = "http://54.191.48.144:5000/"

            val okHttpClient = OkHttpClient.Builder()
            var interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            okHttpClient.addInterceptor(interceptor)

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val surveyService = retrofit.create(SurveyService::class.java)
            val tokenBalance = surveyService.pushTokens()

            tokenBalance.enqueue(TokenPushCallback())
        })
    }

    override fun onStart() {
        super.onStart()
        val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_home -> {
                    startActivity(Intent(applicationContext, HomeActivity::class.java))
                    return@OnNavigationItemSelectedListener true
                }
                R.id.action_transaction_history -> {
                    startActivity(Intent(applicationContext, TransactionHistoryActivity::class.java))
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    override fun onStop() {
        super.onStop()
        navigation.setOnNavigationItemSelectedListener(null)
    }

    override fun onClick(p0: View?) {
        if(rb_q1_true.isChecked){
            response1 = true
        } else if(rb_q1_false.isChecked){
            response1 = false
        }

        if(rb_q2_true.isChecked){
            response2 = true
        } else if(rb_q2_false.isChecked){
            response2 = false
        }

        if(rb_q3_true.isChecked){
            response3 = true
        } else if(rb_q3_false.isChecked){
            response3 = false
        }

        if(rb_q4_true.isChecked){
            response4 = true
        } else if(rb_q4_false.isChecked){
            response4 = false
        }

        if(rb_q5_true.isChecked){
            response5 = true
        } else if(rb_q5_false.isChecked){
            response5 = false
        }

        var responseMap: HashMap<String, Boolean> = HashMap()
        responseMap.put("response1", response1)
        responseMap.put("response2", response2)
        responseMap.put("response3", response3)
        responseMap.put("response4", response4)
        responseMap.put("response5", response5)
        Log.d("Response", response1.toString())
        Log.d("Response", response2.toString())
        Log.d("Response", response3.toString())
        Log.d("Response", response4.toString())
        Log.d("Response", response5.toString())
    }

    private fun getTokenBalance(){
        val BASE_URL = "http://54.191.48.144:5000/"

        val okHttpClient = OkHttpClient.Builder()
        var interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        okHttpClient.addInterceptor(interceptor)

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val surveyService = retrofit.create(SurveyService::class.java)
        val newTokenBalance = surveyService.getBalance()

        newTokenBalance.enqueue(TokenBalanceCallback())
    }

    //--- callback for adding tokens/increasing balance
    inner class TokenPushCallback: Callback<TokenBalance> {
        override fun onFailure(call: retrofit2.Call<TokenBalance>, t: Throwable) {
            Log.d("TokenPushCallback", " onFailure()")
        }

        override fun onResponse(call: retrofit2.Call<TokenBalance>, response: Response<TokenBalance>) {
            Log.d("TokenPushCallback", "onResponse")
        }
    }

    //---callback for checking balance
    inner class TokenBalanceCallback: Callback<NewTokenBalance>{
        override fun onFailure(call: retrofit2.Call<NewTokenBalance>, t: Throwable) {
            Log.d("TokenPushCallback", " onFailure()")
        }

        override fun onResponse(call: retrofit2.Call<NewTokenBalance>, response: Response<NewTokenBalance>) {
            Log.d("TokenPushCallback", "onResponse")
        }
    }

}
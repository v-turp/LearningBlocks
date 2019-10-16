package com.learningblocks.presentation.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.learningblocks.R
import kotlinx.android.synthetic.main.activity_transaction_history.*

class QuizActivity: BaseActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
    }

    override fun onStart() {
        super.onStart()
        val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_home -> {
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
        TODO("not implemented") // implement logic for submitting quiz/survey results to blockchain
    }
}
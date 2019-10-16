package com.learningblocks.presentation.activities

import android.content.Intent
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.learningblocks.R
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_transaction_history.*

class HomeActivity: BaseActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    override fun onStart() {
        super.onStart()
        val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_transaction_history -> {
                    startActivity(Intent(applicationContext, TransactionHistoryActivity::class.java))
                    return@OnNavigationItemSelectedListener true
                }
                R.id.action_quiz -> {
                    startActivity(Intent(applicationContext, QuizActivity::class.java))
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }
        navigation_home.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    override fun onStop() {
        super.onStop()
        navigation_home.setOnNavigationItemSelectedListener(null)
    }
}

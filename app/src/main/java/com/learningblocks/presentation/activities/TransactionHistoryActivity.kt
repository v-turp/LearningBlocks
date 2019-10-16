package com.learningblocks.presentation.activities

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener
import com.learningblocks.R
import com.learningblocks.presentation.adapters.TransactionHistoryAdapter
import kotlinx.android.synthetic.main.activity_transaction_history.*

class TransactionHistoryActivity : BaseActivity(){

    companion object{
        const val TRANSACTION_HASH = "hash"
        const val TRANSACTION_DATE = "transaction_date"
        const val TRANSACTION_SENT_RECEIVED = "transaction_sent_received"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction_history)
        init()
    }

    override fun onStart() {
        super.onStart()
        val mOnNavigationItemSelectedListener = OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_home -> {
                    startActivity(Intent(applicationContext, HomeActivity::class.java))
                    return@OnNavigationItemSelectedListener true
                }
                R.id.action_quiz -> {
                    startActivity(Intent(applicationContext, QuizActivity::class.java))
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

    private fun init(){
        rv_transactions.layoutManager = LinearLayoutManager(this)
        rv_transactions.adapter = TransactionHistoryAdapter(getMockData())
    }

    // --- purely used for mck data
    private fun getMockData(): ArrayList< Map<String, String> >{
        val mockData: ArrayList< Map<String, String>> = ArrayList<Map<String, String>>()
        val mockDataMap: HashMap<String, String> = HashMap<String, String>()
        mockDataMap.put(TRANSACTION_HASH, "gf8g8afaH8lkR")
        mockDataMap.put(TRANSACTION_DATE, "10/12/2019")
        mockDataMap.put(TRANSACTION_SENT_RECEIVED, "-0.0000567")

        val mockDataMap2: HashMap<String, String> = HashMap<String, String>()
        val mockDataMap3: HashMap<String, String> = HashMap<String, String>()
        val mockDataMap4: HashMap<String, String> = HashMap<String, String>()
        val mockDataMap5: HashMap<String, String> = HashMap<String, String>()
        val mockDataMap7: HashMap<String, String> = HashMap<String, String>()
        val mockDataMap8: HashMap<String, String> = HashMap<String, String>()
        val mockDataMap9: HashMap<String, String> = HashMap<String, String>()
        val mockDataMap10: HashMap<String, String> = HashMap<String, String>()
        val mockDataMap11: HashMap<String, String> = HashMap<String, String>()
        val mockDataMap12: HashMap<String, String> = HashMap<String, String>()
        val mockDataMap13: HashMap<String, String> = HashMap<String, String>()
        val mockDataMap14: HashMap<String, String> = HashMap<String, String>()



        mockDataMap2.put(TRANSACTION_HASH, "gf8g8afaH8lkR")
        mockDataMap2.put(TRANSACTION_DATE, "10/13/2019")
        mockDataMap2.put(TRANSACTION_SENT_RECEIVED, "-0.0000567")

        mockDataMap3.put(TRANSACTION_HASH, "gf8g8afapod8eH8lkR")
        mockDataMap3.put(TRANSACTION_DATE, "10/14/2019")
        mockDataMap3.put(TRANSACTION_SENT_RECEIVED, "-0.0000567")

        mockDataMap4.put(TRANSACTION_HASH, "gf8g8afaH8ldfse90kR")
        mockDataMap4.put(TRANSACTION_DATE, "10/15/2019")
        mockDataMap4.put(TRANSACTION_SENT_RECEIVED, "-0.0000567")

        mockDataMap5.put(TRANSACTION_HASH, "gf8g8afaHxs4syhs8lkR")
        mockDataMap5.put(TRANSACTION_DATE, "10/16/2019")
        mockDataMap5.put(TRANSACTION_SENT_RECEIVED, "-0.0000567")

        mockDataMap7.put(TRANSACTION_HASH, "gf8g8afaH8lkR")
        mockDataMap7.put(TRANSACTION_DATE, "10/13/2019")
        mockDataMap7.put(TRANSACTION_SENT_RECEIVED, "-0.0000567")

        mockDataMap8.put(TRANSACTION_HASH, "gf8g8afapod8eH8lkR")
        mockDataMap8.put(TRANSACTION_DATE, "10/14/2019")
        mockDataMap8.put(TRANSACTION_SENT_RECEIVED, "-0.0000567")

        mockDataMap9.put(TRANSACTION_HASH, "gf8g8afaH8ldfse90kR")
        mockDataMap9.put(TRANSACTION_DATE, "10/15/2019")
        mockDataMap9.put(TRANSACTION_SENT_RECEIVED, "-0.0000567")

        mockDataMap10.put(TRANSACTION_HASH, "gf8g8afaHxs4syhs8lkR")
        mockDataMap10.put(TRANSACTION_DATE, "10/16/2019")
        mockDataMap10.put(TRANSACTION_SENT_RECEIVED, "-0.0000567")

        mockDataMap11.put(TRANSACTION_HASH, "gf8g8afaH8lkR")
        mockDataMap11.put(TRANSACTION_DATE, "10/13/2019")
        mockDataMap11.put(TRANSACTION_SENT_RECEIVED, "-0.0000567")

        mockDataMap12.put(TRANSACTION_HASH, "gf8g8afapod8eH8lkR")
        mockDataMap12.put(TRANSACTION_DATE, "10/14/2019")
        mockDataMap12.put(TRANSACTION_SENT_RECEIVED, "-0.0000567")

        mockDataMap13.put(TRANSACTION_HASH, "gf8g8afaH8ldfse90kR")
        mockDataMap13.put(TRANSACTION_DATE, "10/15/2019")
        mockDataMap13.put(TRANSACTION_SENT_RECEIVED, "-0.0000567")

        mockDataMap14.put(TRANSACTION_HASH, "gf8g8afaHxs4syhs8lkR")
        mockDataMap14.put(TRANSACTION_DATE, "10/16/2019")
        mockDataMap14.put(TRANSACTION_SENT_RECEIVED, "-0.0000567")


        mockData.add(mockDataMap2)
        mockData.add(mockDataMap3)
        mockData.add(mockDataMap4)
        mockData.add(mockDataMap5)
        mockData.add(mockDataMap7)
        mockData.add(mockDataMap8)
        mockData.add(mockDataMap9)
        mockData.add(mockDataMap10)
        mockData.add(mockDataMap11)
        mockData.add(mockDataMap12)
        mockData.add(mockDataMap13)
        mockData.add(mockDataMap14)

        return mockData
    }
}

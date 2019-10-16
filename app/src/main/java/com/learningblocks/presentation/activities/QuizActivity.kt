package com.learningblocks.presentation.activities

import android.os.Bundle
import android.view.View
import com.learningblocks.R

class QuizActivity: BaseActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
    }

    override fun onClick(p0: View?) {
        TODO("not implemented") // implement logic for submitting quiz/survey results to blockchain
    }
}
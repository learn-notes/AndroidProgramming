package com.joh.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {

    private val TAG = "QuizActivity"
    private val KEY_INDEX = "index"

    private lateinit var mQuestionTextView: TextView
    private val mQuestionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )

    private var mCurrentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        Log.e(TAG, "onCreate()")

        val s =  this.intent.getStringExtra("TAG")
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()

        if (savedInstanceState != null) {
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX,0)
        }

        this.mQuestionTextView = findViewById(R.id.question_text_view)
        mQuestionTextView.setText(mQuestionBank[mCurrentIndex].textResId)

        // 确认
        findViewById<Button>(R.id.true_button).setOnClickListener {
            checkAnswer(true)
        }

        // 否认
        findViewById<Button>(R.id.false_button).setOnClickListener {
            //            val toast = Toast.makeText(this, R.string.incorrect_toast, Toast.LENGTH_SHORT)
            //原始用法
//            toast.setGravity(Gravity.TOP, 0, 50)
//            toast.show()
            // with作用域用法
//            with(toast) {
//                this.setGravity(Gravity.TOP, 0, 50)
//                this.show()
//            }
            // let作用域用法
//            toast.let {
//                it.setGravity(Gravity.TOP, 0, 50)
//                it.show()
//            }
            checkAnswer(false)
        }

        // 下一题
        findViewById<Button>(R.id.next_button).setOnClickListener {
            updateQuestion()
        }
    }

    /**
     * 更新问题内容
     */
    private fun updateQuestion() {
        mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.size
        mQuestionTextView.setText(mQuestionBank[mCurrentIndex].textResId)
    }

    /**
     * 选择验证
     */
    private fun checkAnswer(userPressedTrue: Boolean) {
        val answerIsTrue = mQuestionBank[mCurrentIndex].answerTrue
        val messageResId =
            if (userPressedTrue == answerIsTrue) {
                updateQuestion()
                R.string.correct_toast
            } else R.string.incorrect_toast
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_INDEX, mCurrentIndex)
    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG, "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, "onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy()")
    }
}

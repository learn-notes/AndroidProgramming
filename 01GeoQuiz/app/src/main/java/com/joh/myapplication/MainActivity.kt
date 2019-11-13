package com.joh.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

/**
 * Android编程权威指南
 * 读书笔记首页
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 首个例子
        findViewById<Button>(R.id.btn_first).setOnClickListener {
            startActivity(Intent(this, QuizActivity::class.java))
        }
    }
}

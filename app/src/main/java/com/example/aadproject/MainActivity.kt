package com.example.aadproject

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.view.View
import android.view.Window
import android.view.WindowManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*  window.apply {
            //  addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
             addFlags(WindowManager.LayoutParams.TYPE_STATUS_BAR)

             // decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
             // decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
          }*/
        /*  window.attributes.apply {
              flags=WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS

          }.also {
              window.attributes=it
              window.decorView.systemUiVisibility=View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
          }*/
    }

    override fun onResume() {
        super.onResume()
        Handler().apply {
            postDelayed({ goToLeaderBoardActivity() }, 5000)
        }
    }

    private fun goToLeaderBoardActivity() {
        Intent(this.baseContext, LeaderBoardActivity::class.java).apply {
          startActivity(this)
            finish()
        }
    }
}
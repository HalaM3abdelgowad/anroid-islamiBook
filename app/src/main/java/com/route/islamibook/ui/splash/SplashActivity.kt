package com.route.islamibook.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.route.islamibook.R
import com.route.islamibook.ui.home.HomeActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper())
            .postDelayed(
                {
                startHomeActivity()

                },3000)
    }

     fun startHomeActivity() {
        val intent =Intent(this, HomeActivity::class.java)
         startActivity(intent)
         finish()
    }
}
package com.soptcode.yilassignment.base

import android.content.pm.ActivityInfo
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.soptcode.yilassignment.utils.SharedPreferenceUtil

abstract class BaseActivity : AppCompatActivity() {

    lateinit var sharedPreference: SharedPreferenceUtil

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        sharedPreference = SharedPreferenceUtil.getInstance(this)
   //     apiViewModel = ViewModelProvider(this).get(ApiViewModel::class.java)
        backGroundColor()
    }

    val prefs by lazy {
        SharedPreferenceUtil.getInstance(applicationContext)
    }

    //BackGround Color
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun backGroundColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(this, android.R.color.transparent)
   //    window.setBackgroundDrawableResource(R.drawable.sccc)
    }

   // abstract fun initViews()
   // abstract fun initControl()

    private var back_pressed: Long = 0

    override fun onBackPressed() {
        when {
            isTaskRoot -> {
                if (back_pressed + 2000 > System.currentTimeMillis()) {
                    finishAffinity()
                    super.onBackPressed()
                } else Toast.makeText(
                    baseContext,
                    "Press once again to exit!",
                    Toast.LENGTH_SHORT
                ).show()
                back_pressed = System.currentTimeMillis()
            }
            else -> super.onBackPressed()
        }
    }
}
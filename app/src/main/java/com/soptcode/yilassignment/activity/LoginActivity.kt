package com.soptcode.yilassignment.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.soptcode.yilassignment.R
import com.soptcode.yilassignment.base.BaseActivity
import com.soptcode.yilassignment.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
         inItViews()
    }

    private fun inItViews() {
        binding.login.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }
}
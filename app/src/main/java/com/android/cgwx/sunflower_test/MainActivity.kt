package com.android.cgwx.sunflower_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.cgwx.sunflower_test.databinding.ActivityMainBinding
import androidx.databinding.DataBindingUtil.setContentView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView<ActivityMainBinding>(this, R.layout.activity_main)
//        setContentView<
    }
}
package com.example.countersmvp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.countersmvp.databinding.ActivityMainBinding
import com.example.countersmvp.view.FragmentMain

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().setCustomAnimations(
                R.anim.slide_in,
                R.anim.slide_out
            ).replace(R.id.container, FragmentMain.newInstance())
                .commit()
        }
    }
}
package com.mehedi.simplequiz2302

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mehedi.simplequiz2302.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)

        setContentView(binding.root)


        val result = intent.getStringExtra("rslt")

        binding.resultTv.text = result


    }
}
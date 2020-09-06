package com.example.aadproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.aadproject.databinding.ActivitySubmissionBinding

class SubmissionActivity : AppCompatActivity() {

    lateinit var binding:ActivitySubmissionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_submission)

        binding=DataBindingUtil.setContentView(this,R.layout.activity_submission)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
                title=""
       setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_white_24)



        }

    }
}
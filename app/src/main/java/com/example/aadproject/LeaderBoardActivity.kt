package com.example.aadproject

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.aadproject.adapters.LeaderBoardPagerAdapter
import com.example.aadproject.data.EntityGads
import com.example.aadproject.databinding.ActivityLeaderboardBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class LeaderBoardActivity:AppCompatActivity() {
    lateinit var binding: ActivityLeaderboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
         binding=DataBindingUtil.setContentView(this,R.layout.activity_leaderboard)

        binding.viewpager.adapter=LeaderBoardPagerAdapter(this)


           TabLayoutMediator(binding.tabLayout,binding.viewpager,
               TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                   when(position){
                       0-> tab.text = "Learning Leaders"
                       else -> tab.text = "Skill IQ Leaders"
                   }
               }).attach()
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            this.title = "LEADERBOARD"

        }

        binding.submit.setOnClickListener {
            Toast.makeText(this,"Submit button",Toast.LENGTH_LONG).show()
            goToSubmissionActivity()
        }


    }

    private fun goToSubmissionActivity() {
       Intent(this,SubmissionActivity::class.java).apply {
           startActivity(this)
       }
    }
}
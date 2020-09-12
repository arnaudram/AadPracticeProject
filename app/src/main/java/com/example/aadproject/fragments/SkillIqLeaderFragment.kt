package com.example.aadproject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.aadproject.adapters.TopSkillIqAdapter
import com.example.aadproject.databinding.FragmentLearningLeaderBinding
import com.example.aadproject.databinding.FragmentSkillIqLeaderBinding
import com.example.aadproject.viewmodelfactory.LearningLeaderViewModelFactory
import com.example.aadproject.viewmodelfactory.SkillIqLeaderViewModelFactory
import com.example.aadproject.viewmodels.LearningLeaderViewModel
import com.example.aadproject.viewmodels.SkillIqLeaderViewModel

class SkillIqLeaderFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding=FragmentSkillIqLeaderBinding.inflate(inflater)


        val skillIqLeaderViewModelFactory= SkillIqLeaderViewModelFactory()

        val skillIqLeaderViewModel by lazy {
            ViewModelProvider(this,skillIqLeaderViewModelFactory)[SkillIqLeaderViewModel::class.java]
        }


        binding.lifecycleOwner=this
        binding.skillIqViewModel=skillIqLeaderViewModel


        skillIqLeaderViewModel.topTwentySkillIQ.observe(viewLifecycleOwner, Observer {
            TopSkillIqAdapter().apply {
                this.submitList(it)
            }.also {adapter ->
                binding.recycleviewSkillIqLeader.setHasFixedSize(true)
                binding.recycleviewSkillIqLeader.adapter=adapter
            }


        })


        return binding.root
    }
}
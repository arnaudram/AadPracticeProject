package com.example.aadproject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.aadproject.databinding.FragmentLearningLeaderBinding

class LearningLeaderFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding=FragmentLearningLeaderBinding.inflate(inflater)

        return binding.root
    }
}
package com.example.aadproject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aadproject.adapters.ToplearnersAdapter
import com.example.aadproject.databinding.FragmentLearningLeaderBinding
import com.example.aadproject.viewmodelfactory.LearningLeaderViewModelFactory
import com.example.aadproject.viewmodels.LearningLeaderViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_learning_leader.view.*

class LearningLeaderFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding=FragmentLearningLeaderBinding.inflate(inflater)



        val learningLeaderViewModelFactory=LearningLeaderViewModelFactory()

        val learningLeaderViewModel=ViewModelProvider(this,learningLeaderViewModelFactory)[LearningLeaderViewModel::class.java]

        binding.lifecycleOwner=this
        binding.learningLeaderViewModel=learningLeaderViewModel


         learningLeaderViewModel.topTwentyLearners.observe(viewLifecycleOwner, Observer {

             //view?.let { it1 -> Snackbar.make(it1,"firstLearner is ${it[0].name}",Snackbar.LENGTH_LONG).show() }
           //  Toast.makeText(context,"list size is ${it.size}",Toast.LENGTH_LONG).show()
            // adapter.submitList(it)
            ToplearnersAdapter(it).also {adapter->
                 binding.recycleviewLearningLeader.setHasFixedSize(true)
                binding.recycleviewLearningLeader.adapter=adapter
            }
         })

        return binding.root
    }
}
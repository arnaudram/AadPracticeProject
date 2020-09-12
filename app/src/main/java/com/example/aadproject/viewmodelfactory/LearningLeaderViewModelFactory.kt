package com.example.aadproject.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aadproject.viewmodels.LearningLeaderViewModel

class LearningLeaderViewModelFactory:ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
      if(modelClass.isAssignableFrom(LearningLeaderViewModel::class.java)){
          return LearningLeaderViewModel() as T
      }
        else throw IllegalArgumentException("wrong view model class")
    }
}
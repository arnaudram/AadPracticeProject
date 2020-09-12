package com.example.aadproject.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import com.example.aadproject.viewmodels.SkillIqLeaderViewModel

class SkillIqLeaderViewModelFactory:ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SkillIqLeaderViewModel::class.java)){
            return SkillIqLeaderViewModel() as T
        }
        else throw IllegalArgumentException("wrong view model class")
    }
}
package com.example.aadproject.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ObserveDialog : ViewModel() {
    private var _continueSubmission = MutableLiveData<Boolean>()
    val continueSubmissiion: LiveData<Boolean>
        get() = _continueSubmission
    init {

        _continueSubmission.value=false
    }

    fun onPossive(){
        _continueSubmission.value=true
    }
   fun onNegative(){
       _continueSubmission.value=false
   }


}
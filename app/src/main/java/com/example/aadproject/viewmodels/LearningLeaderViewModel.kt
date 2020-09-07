package com.example.aadproject.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.aadproject.data.EntityGads
import com.example.aadproject.services.GadsApi
import kotlinx.coroutines.*

class LearningLeaderViewModel:ViewModel() {

    private var _topTwentyLearners=MutableLiveData<List<EntityGads>>()
     val topTwentyLearners:LiveData<List<EntityGads>>
         get() = _topTwentyLearners

private val viewModelJob= Job() 
private val uiScope= CoroutineScope(Dispatchers.Main + viewModelJob)
    
    init {
        getTopTwentyLearners()
    }
    private fun getTopTwentyLearners(){
       uiScope.launch {
           val job=GadsApi.retrofitService.getLearningLeaders().await()
           _topTwentyLearners.value=job
       }
    }

    override fun onCleared() {
        super.onCleared()
        uiScope.cancel()
    }
}
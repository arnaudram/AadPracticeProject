package com.example.aadproject.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.aadproject.data.EntityGads
import com.example.aadproject.data.EntityGadsSkill
import com.example.aadproject.services.GadsApi
import kotlinx.coroutines.*

class SkillIqLeaderViewModel:ViewModel() {

    private val viewModelJob= Job()
    private val uiScope= CoroutineScope(Dispatchers.Main + viewModelJob)


    private var _topTwentySkillIQ= MutableLiveData<List<EntityGadsSkill>>()
    val topTwentySkillIQ: LiveData<List<EntityGadsSkill>>
        get() = _topTwentySkillIQ


    init {
        getTopTwentySkillIQ()
    }
    private fun getTopTwentySkillIQ(){
        uiScope.launch {
            val job= GadsApi.retrofitService.getSkillIQLeaders().await()
            _topTwentySkillIQ.value=job
        }
    }


    override fun onCleared() {
        super.onCleared()

        uiScope.cancel()
    }

}
package com.example.aadproject.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.aadproject.data.EntryGoogleForm
import com.example.aadproject.services.GadsApi
import com.example.aadproject.services.GoogleFormApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SubmissionViewModel:ViewModel() {
lateinit var job:Call<EntryGoogleForm>
    private var _onSubmit=MutableLiveData<Boolean>()
         val onSubmit:LiveData<Boolean>
              get() = _onSubmit
      // response
    private var _response=MutableLiveData<Boolean>()
          val response:LiveData<Boolean>
      get() = _response

    init {
        _response.value=false
        _onSubmit.value=false
    }

    fun submitEvent(){
        _onSubmit.value=true
    }
    fun doneSubmitting(){
        _onSubmit.value=false
    }
    fun sendProject(entryGoogleForm: EntryGoogleForm){
      job=   GoogleFormApi.retrofitService.sendCurrentProject(entryGoogleForm.fisrtName,entryGoogleForm.lastName
         ,entryGoogleForm.emailAddress,entryGoogleForm.linkToProject)
       job.enqueue(object:Callback<EntryGoogleForm>{
           override fun onFailure(call: Call<EntryGoogleForm>, t: Throwable) {
               _response.value=false
           }

           override fun onResponse(
               call: Call<EntryGoogleForm>,
               response: Response<EntryGoogleForm>
           ) {
               _response.value=true
           }
       })
    }


    override fun onCleared() {
        super.onCleared()

        if (this::job.isInitialized){
            job.cancel()
        }
    }
}
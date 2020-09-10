package com.example.aadproject

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.aadproject.data.EntryGoogleForm
import com.example.aadproject.databinding.ActivitySubmissionBinding
import com.example.aadproject.fragments.ProceedSubmissionDialog
import com.example.aadproject.viewmodels.ObserveDialog
import com.example.aadproject.viewmodels.SubmissionViewModel

class SubmissionActivity : AppCompatActivity() {
    lateinit var entryGoogleForm: EntryGoogleForm
    lateinit var binding: ActivitySubmissionBinding
    lateinit var observeDialog: ObserveDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_submission)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_submission)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = ""
            setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_white_24)
        }
        // viewModel
        val submissionViewModel by lazy { ViewModelProvider(this)[SubmissionViewModel::class.java] }

        binding.submissionViewModel=submissionViewModel
        binding.lifecycleOwner=this
        //observing dialog viewModel
        observeDialog=ViewModelProvider(this)[ObserveDialog::class.java]
         submissionViewModel.onSubmit.observe(this, Observer {
                 if(it){
                          if (proceed()){
                              if (fieldChecked()){
                                     showProgressBar()
                                  submissionViewModel.apply {
                                      sendProject(entryGoogleForm)
                                      hideProgressBar()
                                       showUpResult(this)

                                  }

                              }

                          }

                     submissionViewModel.doneSubmitting()

                 }
         })


    }

    private fun showUpResult(submissionViewModel: SubmissionViewModel) {
        submissionViewModel.response.observe(this, Observer {
             if (it){
                 showSubmissionSuccessfulDialog()
             }else{
                 showSubmissionFailledDialog()
             }
        })
    }

    private fun showSubmissionFailledDialog() {
        Dialog(this).apply {
            setContentView(R.layout.submission_failled)

        }.show()
    }

    private fun showSubmissionSuccessfulDialog() {
      Dialog(this).apply {
          setContentView(R.layout.submission_successful)
          setCancelable(true)
      }.show()

    }

    private fun hideProgressBar() {
        binding.progressBar.visibility= View.INVISIBLE
    }

    private fun showProgressBar() {
        binding.progressBar.visibility= View.VISIBLE

    }

    private fun proceed(): Boolean {
        var areYouSure=false
             ProceedSubmissionDialog().show(supportFragmentManager,"dialog_Proceed")
              observeDialog.continueSubmissiion.observe(this, Observer {
                  areYouSure=it
              })


     return areYouSure
    }

    private fun fieldChecked(): Boolean {
        var requirementMet=false
          var firstName=binding.editFirstName.toString()
        var lastName=binding.editLastName.toString()
        var emailAddress=binding.editEmailAdress.toString()
        var linkToProject=binding.editGithubLink.toString()
        if (firstName.isNotEmpty()){
            requirementMet=true
        }
        if (lastName.isNotEmpty()){
            requirementMet=true
        }
        if (emailAddress.isNotEmpty()){
            requirementMet=true
        }
        if (linkToProject.isNotEmpty()){
            requirementMet=true
        }

            if (requirementMet){
              entryGoogleForm=  EntryGoogleForm(firstName,lastName,emailAddress,linkToProject)
            }
        return  requirementMet
    }
}
package com.example.aadproject

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import android.widget.ProgressBar

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.aadproject.data.EntryGoogleForm
import com.example.aadproject.databinding.ActivitySubmissionBinding
import com.example.aadproject.fragments.ProceedSubmissionDialog
import com.example.aadproject.services.GoogleFormApi
import com.example.aadproject.viewmodels.ObserveDialog

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

        observeDialog = ViewModelProvider(this)[ObserveDialog::class.java]



    }



    private fun showSubmissionFailedDialog() {
        Dialog(this).apply {
            setContentView(R.layout.submission_failed)

        }.show()
    }

    private fun showSubmissionSuccessfulDialog() {
        Dialog(this).apply {
            setContentView(R.layout.submission_successful)
            setCancelable(true)
        }.show()

    }

    private fun hideProgressBar() {
        binding.progressBar.visibility = ProgressBar.INVISIBLE
    }

    private fun showProgressBar() {
        binding.progressBar.visibility = ProgressBar.VISIBLE

    }




    fun sendProject(view: View) {
        var requirementMet = true

        var firstName = binding.editFirstName.text.toString()
        var lastName = binding.editLastName.text.toString()
        var emailAddress = binding.editEmailAdress.text.toString()
        var linkToProject = binding.editGithubLink.text.toString()
        requirementMet =
            checkField(firstName, requirementMet, lastName, emailAddress, linkToProject)
        if (requirementMet) {
            entryGoogleForm = EntryGoogleForm(firstName, lastName, emailAddress, linkToProject)

            ProceedSubmissionDialog().show(supportFragmentManager, "dialog_Proceed")

            observeDialog.continueSubmissiion.observe(this, Observer {
                if (it) {
                        send(entryGoogleForm)

                    observeDialog.onNegative()
                }

            })


        }
    }

    private fun checkField(
        firstName: String,
        requirementMet: Boolean,
        lastName: String,
        emailAddress: String,
        linkToProject: String
    ): Boolean {
        var requirementMet1 = requirementMet
        if (firstName.isEmpty()) {
            requirementMet1 = false
            binding.textInputLayout.error = " required* "


        }

        if (lastName.isEmpty()) {
            requirementMet1 = false
            binding.inputLayoutLastName.error = " required* "
        }

        if (emailAddress.isEmpty()) {
            requirementMet1 = false
            binding.inputLayoutAdressEmail.error = " required* "
        }
        if (linkToProject.isEmpty()) {
            requirementMet1 = false
            binding.inputLayoutGithub.error = " required* "
        }
        return requirementMet1
    }


    private fun send(entryGoogleForm: EntryGoogleForm){
        showProgressBar()
          GoogleFormApi.retrofitService.sendCurrentProject(entryGoogleForm.fisrtName,entryGoogleForm.lastName
            ,entryGoogleForm.emailAddress,entryGoogleForm.linkToProject)
        .enqueue(object: Callback<EntryGoogleForm> {
            override fun onFailure(call: Call<EntryGoogleForm>, t: Throwable) {
                hideProgressBar()
                showSubmissionFailedDialog()

            }

            override fun onResponse(
                call: Call<EntryGoogleForm>,
                response: Response<EntryGoogleForm>
            ) {
                hideProgressBar()
                showSubmissionSuccessfulDialog()
            }
        })
    }
}
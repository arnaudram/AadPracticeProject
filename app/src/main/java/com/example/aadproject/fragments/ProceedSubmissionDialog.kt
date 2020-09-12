package com.example.aadproject.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.aadproject.R
import com.example.aadproject.databinding.AreYouSureBinding
import com.example.aadproject.viewmodels.ObserveDialog
import kotlinx.android.synthetic.main.are_you_sure.view.*

class ProceedSubmissionDialog:DialogFragment() {
    lateinit  var observeDialog:ObserveDialog
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding=DataBindingUtil.inflate<AreYouSureBinding>(inflater,R.layout.are_you_sure,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         observeDialog=ViewModelProvider(requireActivity())[ObserveDialog::class.java]
            setUpClickEvent(view)
    }

    private fun setUpClickEvent(view: View) {
        view.dialog_cancel.setOnClickListener {
            observeDialog.onNegative()
            dismiss()
        }
        view.dialog_yes.setOnClickListener {
            observeDialog.onPossive()
            dismiss()
        }
    }

    override fun onStart() {
        super.onStart()
       /* dialog?.window?.setLayout(
            WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT
        )*/
        dialog?.let {
            it.setCancelable(false)
            it.window?.setLayout(
                WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT
            )
        }
    }


}
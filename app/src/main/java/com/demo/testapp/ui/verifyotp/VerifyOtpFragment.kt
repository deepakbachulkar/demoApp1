package com.demo.testapp.ui.verifyotp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.demo.testapp.databinding.FragmentVerifyOtpBinding

class VerifyOtpFragment : Fragment() {

    private var _binding: FragmentVerifyOtpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel = ViewModelProvider(this).get(VerifyOtpViewModel::class.java)
        _binding = FragmentVerifyOtpBinding.inflate(inflater, container, false)
        val root: View = binding.root
        _binding?.submit?.setOnClickListener {
            viewModel.otp.value = _binding?.otp1?.text.toString() +  _binding?.otp1?.text.toString()+ _binding?.otp1?.text.toString()+ _binding?.otp1?.text.toString()
            if(viewModel.otp.value.isNullOrEmpty() || viewModel.otp.value?.length != 4)
                Toast.makeText(requireContext(), "Please enter valid mobile number.", Toast.LENGTH_SHORT).show()
            else{
                viewModel.apiCall()
            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.demo.testapp.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.demo.testapp.MainActivity
import com.demo.testapp.R
import com.demo.testapp.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val root: View = binding.root

        _binding?.submit?.setOnClickListener {
            loginViewModel.phoneNumber.value = _binding?.editTextPhone?.text.toString()
            if(loginViewModel.phoneNumber.value.isNullOrEmpty() || loginViewModel.phoneNumber.value?.length != 10)
                Toast.makeText(requireContext(), "Please enter valid mobile number.", Toast.LENGTH_SHORT).show()
            else{
                loginViewModel.apiCall()
            }
        }

        loginViewModel.mutableLiveData.observe(requireActivity()) {
            if(it is String){
                Toast.makeText(requireContext(), "Something was wrong", Toast.LENGTH_SHORT).show()
            }else{
                (requireActivity() as MainActivity).navController?.navigate(R.id.nav_verifyotp)
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
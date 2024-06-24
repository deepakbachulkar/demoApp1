package com.demo.testapp.ui.splash

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.demo.testapp.MainActivity
import com.demo.testapp.R
import com.demo.testapp.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        val root: View = binding.root
        Handler().postDelayed({
            (requireActivity() as MainActivity).navController?.navigate(R.id.nav_login)
        }, 1000)
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
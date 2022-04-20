package com.example.academynotesapp

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.view.*

class LoginFragment : Fragment() {
    private var email: String? = null
    private var password: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view =  inflater.inflate(R.layout.fragment_login, container, false)
        view.loginButton.setOnClickListener {
            loginToContinue()
        }
        view.regButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_regFragment)
        }
        return view
    }
    private fun loginToContinue() {
        val email = editEmail.text.toString()
        val password = editPassword.text.toString()
        if (inputCheck(email, password)) {

            Toast.makeText(requireContext(), "Logged as $email", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_loginFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Please, complete the fields", Toast.LENGTH_LONG).show()
        }
    }
    private fun inputCheck(email:String, password:String):Boolean {
        return!(TextUtils.isEmpty(email) || TextUtils.isEmpty(password))
    }
}
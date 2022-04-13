package com.example.academynotesapp

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_reg.*
import kotlinx.android.synthetic.main.fragment_reg.view.*

class RegFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_reg, container, false)
        view.signButton.setOnClickListener {
            addUserToDatabase()
        }
        return view

    }
    private fun addUserToDatabase() {
        val email = newEmail.text.toString()
        val password = newPassword.text.toString()
        if (inputCheck(email, password)) {

            Toast.makeText(requireContext(), "You're signed up!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_regFragment_to_loginFragment)
        } else {
            Toast.makeText(requireContext(), "Fill out blank fields", Toast.LENGTH_LONG).show()
        }
    }
    private fun inputCheck(email:String, password: String): Boolean {
        return !(TextUtils.isEmpty(email) && TextUtils.isEmpty(password))
    }
}
package com.example.academynotesapp

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.navigation.PopUpToBuilder
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_new_item.*
import kotlinx.android.synthetic.main.fragment_new_item.view.*

class NewItemFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_new_item, container, false)
        view.add_btn.setOnClickListener {
            addPersonToDatabase()
        }
        return view
    }
    private fun addPersonToDatabase() {
        val name = addName.text.toString()
        val birthday = selectDate.text

        if (inputCheck(name, birthday)) {

            Toast.makeText(requireContext(), "Successfully added", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_newItemFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Fill out blank fields", Toast.LENGTH_LONG).show()
        }

    }
    private fun inputCheck(name:String, birthday: Editable): Boolean {
        return!(TextUtils.isEmpty(name) && birthday.isEmpty())
    }

}
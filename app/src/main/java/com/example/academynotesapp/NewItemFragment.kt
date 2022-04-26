package com.example.academynotesapp

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.academynotesapp.appdata.User
import com.example.academynotesapp.appdata.UserViewModel
import kotlinx.android.synthetic.main.fragment_new_item.*
import kotlinx.android.synthetic.main.fragment_new_item.view.*
import java.util.*

class NewItemFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_new_item, container, false)
        // connecting to Database
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.add_btn.setOnClickListener {
            addPersonToDatabase()
        }

        class DatePickerFragment: DialogFragment(), DatePickerDialog.OnDateSetListener {
            override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
                val c = Calendar.getInstance()
                val day = c.get(Calendar.DAY_OF_MONTH)
                val month = c.get(Calendar.MONTH)
                val year = c.get(Calendar.YEAR)
                return DatePickerDialog(requireActivity(), this, day, month, year)
            }
            override fun onDateSet(view: DatePicker?, day: Int, month: Int, year: Int) {
                Toast.makeText(requireContext(), "You're selected $day of $month year of $year", Toast.LENGTH_SHORT).show()
            }
        }

        view.testtt.setOnClickListener {

        }

        return view
    }
    private fun addPersonToDatabase() {
        val name = addName.text.toString()
        val birthday = selectDate.text

        if (inputCheck(name, birthday)) {
            //Create new item
            val user = User(0, name, Integer.parseInt(birthday.toString()))
            // Add to database
            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(), "Successfully added", Toast.LENGTH_LONG).show()
            // Go back
            Navigation.findNavController(requireView()).navigateUp()
        } else {
            Toast.makeText(requireContext(), "Fill out blank fields", Toast.LENGTH_LONG).show()
        }

    }
    private fun inputCheck(name:String, birthday: Editable): Boolean {
        return!(TextUtils.isEmpty(name) || birthday.isEmpty())
    }

}
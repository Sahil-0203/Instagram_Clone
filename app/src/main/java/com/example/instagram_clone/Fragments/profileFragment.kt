package com.example.instagram_clone.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.instagram_clone.AccountSettingsActivity
import com.example.instagram_clone.R

class profileFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_profile, container, false)


        val edit_account_btn=view.findViewById<Button>(R.id.edit_account_settings)

        edit_account_btn.setOnClickListener {

            startActivity(Intent(context,AccountSettingsActivity::class.java))

        }

        return view
    }
}
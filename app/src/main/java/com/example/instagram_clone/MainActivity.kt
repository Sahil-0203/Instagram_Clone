package com.example.instagram_clone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.instagram_clone.Fragments.homeFragment
import com.example.instagram_clone.Fragments.notificationFragment
import com.example.instagram_clone.Fragments.profileFragment
import com.example.instagram_clone.Fragments.searchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        replacementFragment(homeFragment())


        val navView=findViewById<BottomNavigationView>(R.id.nav_view)

     navView.setOnItemSelectedListener {item ->

         when(item.itemId)
         {
            R.id.nav_home ->
            {
                replacementFragment(homeFragment())
            }
             R.id.nav_search->
             {
                 replacementFragment(searchFragment())
             }
             R.id.nav_add_post ->
             {
                 return@setOnItemSelectedListener true
             }
             R.id.nav_notifications ->
             {
                replacementFragment(notificationFragment())
             }
             R.id.nav_profile ->
             {
                 replacementFragment(profileFragment())
             }

         }
         true

     }

    }
    fun replacementFragment(fragment: Fragment){
        val FragmentManager=supportFragmentManager
        val FragmentTransaction=FragmentManager.beginTransaction()
        FragmentTransaction.replace(R.id.framelayout,fragment)
        FragmentTransaction.commit()
    }
}
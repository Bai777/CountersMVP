package com.example.countersmvp.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

class UserScreen(private val user: String, private val userPassword: String) : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment =
        DetailsUserFragment.newInstance(user, userPassword)
}
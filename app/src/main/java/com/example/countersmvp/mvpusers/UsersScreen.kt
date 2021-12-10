package com.example.countersmvp.mvpusers

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

class UsersScreen(private val userLogo: String, private val userPassword: String) : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment =
        UsersFragment.newInstance(userLogo, userPassword)
}
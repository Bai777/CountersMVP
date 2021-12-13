package com.example.countersmvp.mvpdisplay

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

class UsersScreenDisplay(private val login: String, private val password: String) : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment =
        UsersFragmentDisplay.newInstance(login, password)
}
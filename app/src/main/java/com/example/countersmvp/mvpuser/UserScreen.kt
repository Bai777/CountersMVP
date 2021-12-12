package com.example.countersmvp.mvpuser

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.countersmvp.mvpuser.UserFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object UserScreen: FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment = UserFragment.newInstance()
}
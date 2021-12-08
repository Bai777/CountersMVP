package com.example.countersmvp.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

object LogoScreen: FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment = UserFragment.newInstance()
}
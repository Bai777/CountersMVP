package com.example.countersmvp.mvpautorization

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

object UserScreenAutorization: FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment = UserFragmentAutorization.newInstance()
}
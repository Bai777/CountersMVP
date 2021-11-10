package com.example.countersmvp.view

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IUsersScreens {
    override fun users(): Screen = FragmentScreen { UsersFragment.newInstance() }

    override fun userDetail(user: String): Screen =
        FragmentScreen { DetailsUsersFragment.newInstance() }
}
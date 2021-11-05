package com.example.countersmvp.view

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens: IScreens {
    override fun users(): Screen {
        return FragmentScreen{UsersFragment.newInstance()}
    }
}
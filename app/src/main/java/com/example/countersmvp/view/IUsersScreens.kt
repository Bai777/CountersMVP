package com.example.countersmvp.view

import com.github.terrakok.cicerone.Screen

interface IUsersScreens {
    fun users(): Screen
    fun userDetail(user: String): Screen
}
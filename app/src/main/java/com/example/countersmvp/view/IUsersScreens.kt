package com.example.countersmvp.view

import com.example.countersmvp.model.GithubUser
import com.github.terrakok.cicerone.Screen

interface IUsersScreens {
    fun users(): Screen
    fun userDetail(user: GithubUser): Screen
}
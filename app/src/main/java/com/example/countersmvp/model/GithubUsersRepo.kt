package com.example.countersmvp.model

import com.github.terrakok.cicerone.Screen

class GithubUsersRepo {
    private val users =
        (0..10).map { GithubUser("login$it") }


    fun getUsers() = users
}

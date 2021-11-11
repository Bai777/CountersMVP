package com.example.countersmvp.model

class GithubUsersRepo {
    private val users =
        (0..10).map { GithubUser("login$it") }
    fun getUsers() = users
}

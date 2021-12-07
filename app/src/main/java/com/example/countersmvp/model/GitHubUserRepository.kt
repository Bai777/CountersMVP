package com.example.countersmvp.model

class GitHubUserRepository {

    private val users =
        (0..10).map { GitHubUser("login$it") }

   fun getUsers() = users
}

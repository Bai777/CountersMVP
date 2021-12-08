package com.example.countersmvp.model

class GitHubUserRepository {
    private val users = { GitHubUser("login","password") }

   fun getUsers() = users
}

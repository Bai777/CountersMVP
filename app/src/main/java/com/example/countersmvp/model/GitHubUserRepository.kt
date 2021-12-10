package com.example.countersmvp.model

import com.example.countersmvp.R

class GitHubUserRepository {
    private val login get() = R.id.et_login
    private val password get() = R.id.et_login

    private val users = { GitHubUser(login.toString(), password.toString()) }

    fun getUsers() = users
}

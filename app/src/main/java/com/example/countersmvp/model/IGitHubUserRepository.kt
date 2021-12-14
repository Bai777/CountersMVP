package com.example.countersmvp.model

interface IGitHubUserRepository {
    fun getUsers(): List<GitHubUser>
    fun getUserByLogin(loginUser: String, passwordUser: String): GitHubUser?
}

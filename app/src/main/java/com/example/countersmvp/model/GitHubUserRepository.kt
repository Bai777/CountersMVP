package com.example.countersmvp.model

import com.example.countersmvp.R
import java.util.ArrayList

class GitHubUserRepository {
    private val login = R.id.et_login
    private val password = R.id.et_password

//    private val users = { GitHubUser(login.toString(), password.toString()) }
//
//    fun getUsers() = users

    fun set():ArrayList<out String> {
        val list = ArrayList<String>()
        val userLogin = login.toString()
        val userPassword = password.toString()
        list.add(userLogin)
        list.add(userPassword)
        return list
    }
}

package com.example.countersmvp.model

import io.reactivex.rxjava3.core.Observable

interface IGitHubUserRepository {
    fun getUsers(login: String, password: String):Observable<List<GitHubUser>>
}

package com.example.countersmvp.model

import io.reactivex.rxjava3.core.Observable

interface GitHubUserRepository {
    fun getUsers():Observable<List<GitHubUser>>
}

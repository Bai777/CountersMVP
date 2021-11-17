package com.example.countersmvp.model
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single
interface GitHubUserRepository {
    fun getUsers(): Single<List<GithubUser>>
    fun getUserByLogin(userId: String): Maybe<GithubUser>
}
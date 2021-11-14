package com.example.countersmvp.model

import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single

class GithubUsersRepo : GitHubUserRepository {
    private val users =
        (0..10).map { GithubUser("login$it") }


    override fun getUsers(): Single<List<GithubUser>> = Single.just(users)
    override fun getUserByLogin(login: String): Maybe<GithubUser> =
        users.firstOrNull() { user -> user.login = login }
            ?.let { Maybe.just(it) }
            ?: Maybe.empty()
}

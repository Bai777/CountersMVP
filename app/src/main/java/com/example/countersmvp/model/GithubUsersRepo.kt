package com.example.countersmvp.model

import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single

class GithubUsersRepo : GitHubUserRepository {
    private val users =
        (0..10).map { GithubUser("login$it") }


    override fun getUsers(): Single<List<GithubUser>> = Single.just(users)
        .map { users -> users.map { it.copy(login = it.login.lowercase()) } }

    override fun getUserByLogin(userId: String): Maybe<GithubUser> =
        users.firstOrNull() { user -> user.login.contentEquals(userId, ignoreCase = true) }
            ?.let { user -> Maybe.just(user) }
            ?: Maybe.empty()
}

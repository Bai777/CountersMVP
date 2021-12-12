package com.example.countersmvp.model

import android.widget.Toast
import com.example.countersmvp.view.App
import io.reactivex.rxjava3.core.Observable

class GitHubUserRepositoryImpl : IGitHubUserRepository {


    private val users = listOf(
        GitHubUser("user1", "12345"),
        GitHubUser("user2", "11111"),
        GitHubUser("user3", "22222"),
        GitHubUser("user4", "33333"),
        GitHubUser("user5", "44444")
    )

    override fun getUsers(login: String, password: String): Observable<List<GitHubUser>> {

        val result = listOf(
            login, password
        )
        return if (result == users)
            Observable.just(users)
        else showMessage()
    }

    private fun showMessage(): Observable<List<GitHubUser>> {
        Toast.makeText(
            App.instance.getContext(),
            "Такого пользователя не существует!!!",
            Toast.LENGTH_SHORT
        ).show()
        return showMessage()
    }
}
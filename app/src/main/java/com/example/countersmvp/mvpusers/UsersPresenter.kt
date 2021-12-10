package com.example.countersmvp.mvpusers

import com.example.countersmvp.model.GitHubUserRepository
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UsersPresenter(
    private val userRepository: GitHubUserRepository,
    private val router: Router,
) : MvpPresenter<IUsersView>() {


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}







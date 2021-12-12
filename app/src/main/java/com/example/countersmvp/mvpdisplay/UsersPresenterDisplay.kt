package com.example.countersmvp.mvpdisplay

import com.example.countersmvp.model.GitHubUserRepository
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UsersPresenterDisplay(
    private val userRepository: GitHubUserRepository,
    private val router: Router,
) : MvpPresenter<IUsersViewDisplay>() {


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}







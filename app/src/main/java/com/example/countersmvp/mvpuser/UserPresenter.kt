package com.example.countersmvp.mvpuser

import com.example.countersmvp.model.GitHubUserRepository
import com.example.countersmvp.view.IMainView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UserPresenter(
    private val userRepository: GitHubUserRepository,
    private val router: Router,
) : MvpPresenter<IUserView>() {


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        userRepository
            .getUsers()
            .let { viewState::showUser }
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}







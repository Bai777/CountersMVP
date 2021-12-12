package com.example.countersmvp.mvpdisplay

import com.example.countersmvp.model.GitHubUserRepositoryImpl
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UsersPresenterDisplay(
    private val loginUser: String,
    private val passwordUser: String,
    private val userRepositoryImpl: GitHubUserRepositoryImpl,
    private val router: Router,
) : MvpPresenter<IUsersViewDisplay>() {


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        super.onFirstViewAttach()
        userRepositoryImpl.getUsers(loginUser, passwordUser)
            .subscribe({ users ->
                viewState.showUsers(users)
            }, {})
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}







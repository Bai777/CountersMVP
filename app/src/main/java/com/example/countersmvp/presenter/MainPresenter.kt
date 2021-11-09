package com.example.countersmvp.presenter

import com.example.countersmvp.view.IMainView
import com.example.countersmvp.view.IUsersScreens
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class MainPresenter(private val router: Router, private val usersScreens: IUsersScreens)
    : MvpPresenter<IMainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(usersScreens.users())
    }

    fun backClicked() {
        router.exit()
    }
}


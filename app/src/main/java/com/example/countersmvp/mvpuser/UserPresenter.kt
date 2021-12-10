package com.example.countersmvp.mvpuser

import com.example.countersmvp.model.GitHubUserRepository
import com.example.countersmvp.mvpusers.UsersScreen
import com.example.countersmvp.view.App
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import java.util.ArrayList

class UserPresenter(
    private val userRepository: GitHubUserRepository,
    private val router: Router,
) : MvpPresenter<IUserView>() {


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
//        userRepository
//            .getUsers()
//            .let { viewState::showUser }
    }

    fun setText(){
        displayUser(userRepository.set())
    }
        private fun displayUser(set: ArrayList<out String>) =
        App.instance.router.navigateTo(UsersScreen(set))

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}







package com.example.countersmvp.mvpautorization

import android.widget.Toast
import com.example.countersmvp.model.GitHubUserRepositoryImpl
import com.example.countersmvp.mvpdisplay.UsersScreenDisplay
import com.example.countersmvp.view.App
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UserPresenterAutorization(
    private val userRepositoryImpl: GitHubUserRepositoryImpl,
    private val router: Router,
) : MvpPresenter<IUserViewAutorization>() {

    private val context = App.instance.getContext()
    private val usersRepositoryImpl = GitHubUserRepositoryImpl()
    override fun onFirstViewAttach() {

    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    fun validateData(login: String, password: String) {
        if (login.isNullOrEmpty() && password.isNullOrEmpty()) {
            Toast.makeText(context, "Все поля должны быть заполнены!!!", Toast.LENGTH_SHORT).show()
        } else {
            usersRepositoryImpl.getUsers(login, password)
            App.instance.router.navigateTo(UsersScreenDisplay(login, password))
        }
    }

}







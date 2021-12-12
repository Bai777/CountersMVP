package com.example.countersmvp.mvpuser

import android.widget.Toast
import com.example.countersmvp.model.GitHubUserRepository
import com.example.countersmvp.mvpusers.UsersFragment
import com.example.countersmvp.mvpusers.UsersScreen
import com.example.countersmvp.view.App
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UserPresenter(
    private val userRepository: GitHubUserRepository,
    private val router: Router,
) : MvpPresenter<IUserView>() {

    private val context = App.instance.getContext()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }


    fun validateData(login: String, password: String) {
        if (login.isNullOrEmpty() && password.isNullOrEmpty()) {
            Toast.makeText(context, "Все поля должны быть заполнены!!!", Toast.LENGTH_SHORT).show()
        } else {
            App.instance.router.navigateTo(UsersScreen(login, password))
        }
    }
}







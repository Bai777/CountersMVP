package com.example.countersmvp.mvpautorization

import com.example.countersmvp.model.GitHubUser
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface IUserViewAutorization: MvpView {
    fun showUser(login: () -> GitHubUser, password:() -> GitHubUser)
}
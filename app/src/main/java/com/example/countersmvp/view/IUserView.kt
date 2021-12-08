package com.example.countersmvp.view

import com.example.countersmvp.model.GitHubUser
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface IUserView: MvpView {
    fun showUser(login: GitHubUser, password: GitHubUser)
}
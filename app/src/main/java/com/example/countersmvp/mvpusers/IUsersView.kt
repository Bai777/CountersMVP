package com.example.countersmvp.mvpusers

import com.example.countersmvp.model.GitHubUser
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface IUsersView: MvpView{
    fun showUser(login: GitHubUser, password: GitHubUser)
}


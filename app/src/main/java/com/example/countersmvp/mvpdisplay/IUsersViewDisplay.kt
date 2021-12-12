package com.example.countersmvp.mvpdisplay

import com.example.countersmvp.model.GitHubUser
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface IUsersViewDisplay: MvpView{
    fun showUsers(users: List<GitHubUser>)

}


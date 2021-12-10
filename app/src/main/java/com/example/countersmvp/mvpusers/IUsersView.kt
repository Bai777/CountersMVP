package com.example.countersmvp.mvpusers

import com.example.countersmvp.model.GitHubUser
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface IUsersView: MvpView{
    fun showUser(login: GitHubUser, password: GitHubUser)
}


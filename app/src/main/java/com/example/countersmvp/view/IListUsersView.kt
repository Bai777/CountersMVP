package com.example.countersmvp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface IListUsersView: MvpView {
    fun init()
    fun updateList()
}
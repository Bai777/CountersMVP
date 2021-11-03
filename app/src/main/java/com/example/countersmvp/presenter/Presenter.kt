package com.example.countersmvp.presenter

import com.example.countersmvp.model.GithubUser
import com.example.countersmvp.model.GithubUsersRepo
import com.example.countersmvp.view.IListUsersView
import com.example.countersmvp.view.IUserItemView
import moxy.MvpPresenter

class Presenter(private val usersRepo: GithubUsersRepo) : MvpPresenter<IListUsersView>() {

    class UsersListPresenter : IUserListPresenter {
        val users = mutableListOf<GithubUser>()

        override var itemClickListener: ((IUserItemView) -> Unit)? = null

        override fun getCount() = users.size

        override fun bindView(view: IUserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }
    }

    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        usersListPresenter.itemClickListener = { itemView ->
            //TODO: переход на экран пользователя c помощью router.navigateTo
        }
    }

    fun loadData() {
        val users = usersRepo.getUsers()
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }



}


package com.example.countersmvp.presenter

import com.example.countersmvp.model.GitHubUserRepository
import com.example.countersmvp.model.GithubUser
import com.example.countersmvp.model.GithubUsersRepo
import com.example.countersmvp.view.IUsersScreens
import com.example.countersmvp.view.IUsersView
import com.example.countersmvp.view.IUserItemView
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Single
import moxy.MvpPresenter

class UsersPresenter(private val usersRepo: GithubUsersRepo,
                     private val userRepository: GitHubUserRepository,
                     private val router: Router,
                     private val usersScreens: IUsersScreens) : MvpPresenter<IUsersView>() {

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
          val user = usersListPresenter.users[itemView.pos]
            router.navigateTo(usersScreens.userDetail(user.login))
        }
    }

    private fun loadData() {
        val users = usersRepo.getUsers()
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

}




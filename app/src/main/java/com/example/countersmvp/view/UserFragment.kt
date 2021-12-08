package com.example.countersmvp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.countersmvp.databinding.FragmentUsersBinding
import com.example.countersmvp.model.GitHubUser
import com.example.countersmvp.model.GitHubUserRepository
import com.example.countersmvp.presenter.UserPresenter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment : MvpAppCompatFragment(), IMainView, IBackButtonListener {
    companion object {
        fun newInstance() = UserFragment()
    }

    private val presenter: UserPresenter by moxyPresenter { UserPresenter(GitHubUserRepository(),
        App.instance.router) }

    private var binding: FragmentUsersBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        FragmentUsersBinding.inflate(inflater, container, false).also {
            binding = it
        }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val login = binding?.etLogin?.text.toString()
        val password = binding?.etPassword?.text.toString()
        binding!!.buttonProceed.setOnClickListener{
            displayUser(login, password)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun displayUser(user: String, passwordUser: String) =
        App.instance.router.navigateTo(UserScreen(user, passwordUser))

    override fun backPressed() = presenter.backPressed()
    override fun showUser(login: GitHubUser, password: GitHubUser) {
        TODO("Not yet implemented")
    }
}
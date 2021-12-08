package com.example.countersmvp.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.countersmvp.databinding.FragmentUserDetailsBinding
import com.example.countersmvp.model.GitHubUser
import com.example.countersmvp.model.GitHubUserRepository
import com.example.countersmvp.presenter.UserPresenter
import com.github.terrakok.cicerone.Screen
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class DetailsUserFragment(login: String, password: String) : MvpAppCompatFragment(), IUserView, IBackButtonListener, Screen {
    companion object {
        fun newInstance(user: String, userPassword: String) = DetailsUserFragment(user, userPassword)
    }

    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter(
            GitHubUserRepository(),
            App.instance.router
        )
    }

    private var binding: FragmentUserDetailsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        FragmentUserDetailsBinding.inflate(inflater, container, false).also {
            binding = it
        }.root


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun backPressed() = presenter.backPressed()


    @SuppressLint("SetTextI18n")
    override fun showUser(login: GitHubUser, password: GitHubUser) {
        binding?.tvUser?.text = "login $login, password $password"
    }

}
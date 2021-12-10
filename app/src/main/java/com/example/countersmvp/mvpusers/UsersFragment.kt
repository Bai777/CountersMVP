package com.example.countersmvp.mvpusers

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.countersmvp.databinding.FragmentUserDetailsBinding
import com.example.countersmvp.model.GitHubUser
import com.example.countersmvp.model.GitHubUserRepository
import com.example.countersmvp.mvpuser.IUserView
import com.example.countersmvp.mvpuser.UserPresenter
import com.example.countersmvp.view.App
import com.example.countersmvp.view.IBackButtonListener
import com.github.terrakok.cicerone.Screen
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment() : MvpAppCompatFragment(), IUserView, IBackButtonListener, Screen {


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

    private val userLogin: String by lazy {
        arguments?.getString(ARG_USER_LOGIN, ARG_USER_PASSWORD).orEmpty()
    }
    @SuppressLint("SetTextI18n")
    override fun showUser(login: GitHubUser, password: GitHubUser) {
        binding?.tvUser?.text = "login $login, password $password"
    }

    companion object {
        private const val ARG_USER_LOGIN = "arg_user_login"
        private const val ARG_USER_PASSWORD = "arg_user_password"

        fun newInstance(userId: String, userPassword: String): Fragment =
            UsersFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_USER_LOGIN, userId)
                    putString(ARG_USER_PASSWORD, userPassword)
                }
            }
    }

}
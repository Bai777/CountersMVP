package com.example.countersmvp.mvpdisplay

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.countersmvp.databinding.FragmentUserDisplayBinding
import com.example.countersmvp.model.GitHubUser
import com.example.countersmvp.model.GitHubUserRepositoryImpl
import com.example.countersmvp.mvpautorization.UserPresenterAutorization
import com.example.countersmvp.view.App
import com.example.countersmvp.view.IBackButtonListener
import com.github.terrakok.cicerone.Screen
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragmentDisplay() : MvpAppCompatFragment(), IUsersViewDisplay, IBackButtonListener, Screen {


    private val presenterAutorization: UserPresenterAutorization by moxyPresenter {
        UserPresenterAutorization(
            userRepositoryImpl = GitHubUserRepositoryImpl(),
            App.instance.router
        )
    }

    private var binding: FragmentUserDisplayBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        FragmentUserDisplayBinding.inflate(inflater, container, false).also {
            binding = it
        }.root

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val login = arguments?.getString(ARG_USER_LOGIN).orEmpty()
        val password = arguments?.getString(ARG_USER_PASSWORD).orEmpty()
        binding?.tvUser?.text = "Логин $login Пароль $password"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun backPressed() = presenterAutorization.backPressed()


    companion object {
        private const val ARG_USER_LOGIN = "arg_user_login"
        private const val ARG_USER_PASSWORD = "arg_user_password"

        fun newInstance(login: String, password: String): Fragment =
            UsersFragmentDisplay().apply {
                arguments = Bundle().apply {
                    putString(ARG_USER_LOGIN, login)
                    putString(ARG_USER_PASSWORD, password)
                }
            }
    }



    override fun showUsers(users: List<GitHubUser>) {
        TODO("Not yet implemented")
    }


}
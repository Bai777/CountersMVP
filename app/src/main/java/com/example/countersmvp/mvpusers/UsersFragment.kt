package com.example.countersmvp.mvpusers

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.countersmvp.databinding.FragmentUserDetailsBinding
import com.example.countersmvp.model.GitHubUser
import com.example.countersmvp.model.GitHubUserRepository
import com.example.countersmvp.mvpuser.UserPresenter
import com.example.countersmvp.view.App
import com.example.countersmvp.view.IBackButtonListener
import com.github.terrakok.cicerone.Screen
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment() : MvpAppCompatFragment(), IUsersView, IBackButtonListener, Screen {


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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val yourArray = arguments?.getStringArrayList(ARG_USER_RESULT).orEmpty()
        binding?.tvUser?.text = yourArray.toString()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun backPressed() = presenter.backPressed()


    @SuppressLint("SetTextI18n")
    override fun showUser(login: GitHubUser, password: GitHubUser) {
        binding?.tvUser?.text = "login $login, password $password"
    }

    companion object {
        private const val ARG_USER_RESULT = "arg_user_requireResult"

        fun newInstance(set: ArrayList<String>): Fragment =
            UsersFragment().apply {
                arguments = Bundle().apply {
                    putStringArrayList(ARG_USER_RESULT, set)
                }
            }
    }

}
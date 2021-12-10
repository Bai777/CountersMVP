package com.example.countersmvp.mvpuser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.countersmvp.databinding.FragmentUsersBinding
import com.example.countersmvp.model.GitHubUserRepository
import com.example.countersmvp.mvpusers.UsersFragment
import com.example.countersmvp.view.App
import com.example.countersmvp.view.IBackButtonListener
import com.example.countersmvp.view.IMainView
import com.example.countersmvp.mvpusers.UsersScreen
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment : MvpAppCompatFragment(), IMainView, IBackButtonListener {
    companion object {
        fun newInstance() = UserFragment()
    }

    private val presenter: UserPresenter by moxyPresenter { UserPresenter(
        userRepository = GitHubUserRepository(),
        App.instance.router) }

    private var binding: FragmentUsersBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        FragmentUsersBinding.inflate(inflater, container, false).also {
            binding = it
        }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding!!.buttonProceed.setOnClickListener{
            presenter.setText()
           // displayUser("login", "password")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

//    private fun displayUser(userLogo: String, passwordUser: String) =
//        App.instance.router.navigateTo(UsersScreen(userLogo, passwordUser))

    override fun backPressed() = presenter.backPressed()

}
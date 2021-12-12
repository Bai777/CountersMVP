package com.example.countersmvp.mvpautorization

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.countersmvp.databinding.FragmentUserAutorizationBinding
import com.example.countersmvp.model.GitHubUserRepositoryImpl
import com.example.countersmvp.view.App
import com.example.countersmvp.view.IBackButtonListener
import com.example.countersmvp.view.IMainView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragmentAutorization : MvpAppCompatFragment(), IMainView, IBackButtonListener {
    companion object {
        fun newInstance() = UserFragmentAutorization()
    }

    private val presenterAutorization: UserPresenterAutorization by moxyPresenter { UserPresenterAutorization(
        userRepositoryImpl = GitHubUserRepositoryImpl(),
        App.instance.router) }

    private var binding: FragmentUserAutorizationBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        FragmentUserAutorizationBinding.inflate(inflater, container, false).also {
            binding = it
        }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding!!.buttonProceed.setOnClickListener{
            val login = binding?.etLogin?.text.toString()
            val password = binding?.etPassword?.text.toString()
            presenterAutorization.validateData(login, password)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun backPressed() = presenterAutorization.backPressed()

}
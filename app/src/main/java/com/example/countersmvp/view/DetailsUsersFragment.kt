package com.example.countersmvp.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countersmvp.databinding.FragmentUserDetailsBinding
import com.example.countersmvp.databinding.FragmentUsersBinding
import com.example.countersmvp.model.GithubUser
import com.example.countersmvp.model.GithubUsersRepo
import com.example.countersmvp.presenter.UsersPresenter
import com.github.terrakok.cicerone.Screen
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class DetailsUsersFragment : MvpAppCompatFragment(), IUsersView, IBackButtonListener, ShowUser {
    companion object {
        fun newInstance() = DetailsUsersFragment()
    }

    private val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter(
            GithubUsersRepo(),
            App.instance.router, AndroidScreens()
        )
    }
    private var adapter: UsersRVAdapter? = null

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

    override fun init() {
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backPressed()

    override fun showUser(user: GithubUser) {
        binding?.tvLogin?.text = user.login
    }
}
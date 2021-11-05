package com.example.countersmvp.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countersmvp.databinding.FragmentUsersBinding
import com.example.countersmvp.model.GithubUsersRepo
import com.example.countersmvp.presenter.UsersPresenter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment : MvpAppCompatFragment(),
    IUsersView {
    private var _binding: FragmentUsersBinding? = null
    private val binding: FragmentUsersBinding
        get() {
            return _binding!!
        }
    private val presenter by moxyPresenter { UsersPresenter(GithubUsersRepo(), App.instance.router) }
    private var adapter: UsersRVAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUsersBinding.inflate(inflater)
        return binding.root
    }

    companion object {
        fun newInstance() = UsersFragment()
    }


    override fun init() {
        binding.run {
            this.rvUsers.layoutManager = LinearLayoutManager(context)
            adapter = UsersRVAdapter(presenter.usersListPresenter)
            this.rvUsers.adapter = adapter
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }
}
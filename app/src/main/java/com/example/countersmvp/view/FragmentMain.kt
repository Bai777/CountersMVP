package com.example.countersmvp.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countersmvp.databinding.FragmentMainBinding
import com.example.countersmvp.model.GithubUsersRepo
import com.example.countersmvp.presenter.Presenter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class FragmentMain : MvpAppCompatFragment(),
    IListUsersView {
    private var _binding: FragmentMainBinding? = null
    val binding: FragmentMainBinding
        get() {
            return _binding!!
        }
    private val presenter by moxyPresenter { Presenter(GithubUsersRepo()) }
    private var adapter: UsersRVAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    companion object {
        fun newInstance() = FragmentMain()
    }


    override fun init() {
        binding.rvUsers.layoutManager = LinearLayoutManager(context)
        adapter = UsersRVAdapter(presenter.usersListPresenter)
        binding.rvUsers.adapter = adapter
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }
}
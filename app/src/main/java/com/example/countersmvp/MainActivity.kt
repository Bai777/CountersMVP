package com.example.countersmvp

import android.os.Bundle
import com.example.countersmvp.databinding.ActivityMainBinding
import com.example.countersmvp.model.GitHubUserRepository
import com.example.countersmvp.mvpautorization.UserPresenterAutorization
import com.example.countersmvp.mvpautorization.UserScreenAutorization
import com.example.countersmvp.view.App
import com.example.countersmvp.view.IBackButtonListener
import com.example.countersmvp.view.IMainView
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), IMainView, IBackButtonListener {

    private val navigator = AppNavigator(this, R.id.container)

    private val presenter by moxyPresenter { UserPresenterAutorization(
        GitHubUserRepository(),
        App.instance.router) }
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        App.instance.router.navigateTo(UserScreenAutorization)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.instance.navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it is IBackButtonListener && it.backPressed()){
                return
            }
        }

    }
    override fun backPressed() = presenter.backPressed()

}
package com.example.countersmvp.view

import android.os.Bundle
import android.view.View
import com.example.countersmvp.databinding.FragmentMainBinding
import com.example.countersmvp.model.CountersModel
import com.example.countersmvp.presenter.Presenter
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class FragmentMain : MvpAppCompatActivity(),
    IMainView {
    private lateinit var binding: FragmentMainBinding
    private val presenter by moxyPresenter { Presenter(CountersModel()) }

    override fun onCreate(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.btnCounter1.setOnClickListener { presenter.counterOneClick() }
        binding.btnCounter2.setOnClickListener { presenter.counterTwoClick() }
        binding.btnCounter3.setOnClickListener { presenter.counterThreeClick() }
    }

    companion object {
        fun newInstance() = FragmentMain()
    }


    override fun setButtonTextOne(text: String) {
        binding.btnCounter1.text = text
    }

    override fun setButtonTextTwo(text: String) {
        binding.btnCounter2.text = text
    }

    override fun setButtonTextThree(text: String) {
        binding.btnCounter3.text = text
    }
}
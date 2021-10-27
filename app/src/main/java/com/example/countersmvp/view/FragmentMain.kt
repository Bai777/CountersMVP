package com.example.countersmvp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.countersmvp.ViewBindingFragment
import com.example.countersmvp.databinding.FragmentMainBinding
import com.example.countersmvp.model.CountersModel
import com.example.countersmvp.presenter.Presenter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class FragmentMain : MvpAppCompatFragment(),
    IMainView {
    private var _binding: FragmentMainBinding? = null
    val binding: FragmentMainBinding
        get() {
            return _binding!!
        }
    private val presenter by moxyPresenter { Presenter(CountersModel()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
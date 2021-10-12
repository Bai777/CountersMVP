package com.example.countersmvp.view

import android.os.Bundle
import android.view.View
import com.example.countersmvp.ViewBindingFragment
import com.example.countersmvp.databinding.FragmentMainBinding
import com.example.countersmvp.presenter.Presenter

class FragmentMain : ViewBindingFragment<FragmentMainBinding>(FragmentMainBinding::inflate),
    MainView {

    private val presenter = Presenter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listener = View.OnClickListener {
            presenter.counterClick(it.id)
        }

        binding.btnCounter1.setOnClickListener(listener)
        binding.btnCounter2.setOnClickListener(listener)
        binding.btnCounter3.setOnClickListener(listener)
    }


    companion object {
        fun newInstance() = FragmentMain()
    }

    override fun setButtonText(index: Int, text: String) {
        when (index) {
            0 -> binding.btnCounter1.text = text
            1 -> binding.btnCounter2.text = text
            2 -> binding.btnCounter3.text = text
        }
    }

}
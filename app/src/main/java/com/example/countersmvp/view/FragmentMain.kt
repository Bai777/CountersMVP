package com.example.countersmvp.view

import android.os.Bundle
import android.view.View
import com.example.countersmvp.R
import com.example.countersmvp.ViewBindingFragment
import com.example.countersmvp.databinding.FragmentMainBinding
import com.example.countersmvp.model.CounterType
import com.example.countersmvp.presenter.Presenter
import java.lang.IllegalStateException

class FragmentMain : ViewBindingFragment<FragmentMainBinding>(FragmentMainBinding::inflate),
    IMainView {

    private val presenter = Presenter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listener = View.OnClickListener {
            val type = when(it.id){
                R.id.btn_counter1->CounterType.ONE
                R.id.btn_counter2->CounterType.TWO
                R.id.btn_counter3->CounterType.THREE
                else->throw IllegalStateException("no this button!!!")
            }
            presenter.counterClick(type)
        }

        binding.btnCounter1.setOnClickListener(listener)
        binding.btnCounter2.setOnClickListener (listener)
        binding.btnCounter3.setOnClickListener (listener)
    }

    companion object {
        fun newInstance() = FragmentMain()
    }

    override fun setButtonText(type: CounterType, text: String) {
        when (type) {
            CounterType.ONE -> binding.btnCounter1.text = text
            CounterType.TWO -> binding.btnCounter2.text = text
            CounterType.THREE -> binding.btnCounter3.text = text
        }
    }
}
package com.example.countersmvp.view

import com.example.countersmvp.ViewBindingFragment
import com.example.countersmvp.databinding.FragmentMainBinding

class FragmentMain:ViewBindingFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {
    companion object {
        fun newInstance() = FragmentMain()
    }
}
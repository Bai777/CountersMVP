package com.example.countersmvp.view

import com.example.countersmvp.model.CounterType

interface IMainView {
    fun setButtonText(type: CounterType, text:String)
}
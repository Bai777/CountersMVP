package com.example.countersmvp.view

import com.example.countersmvp.model.CounterType
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface IMainView: MvpView {
    fun setButtonTextOne(text: String)
    fun setButtonTextTwo(text: String)
    fun setButtonTextThree(text: String)
}
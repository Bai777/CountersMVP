package com.example.countersmvp.presenter

import com.example.countersmvp.model.CounterType
import com.example.countersmvp.model.CountersModel
import com.example.countersmvp.view.IMainView

class Presenter(private val view: IMainView) {
    private val model = CountersModel()

    fun counterClick(type: CounterType) {
        val dataFromModel = when (type) {
            CounterType.ONE -> model.next(0)
            CounterType.TWO -> model.next(1)
            CounterType.THREE -> model.next(2)
        }
        view.setButtonText(type, dataFromModel.toString())
    }
}


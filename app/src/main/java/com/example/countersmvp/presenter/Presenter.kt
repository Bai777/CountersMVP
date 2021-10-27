package com.example.countersmvp.presenter

import com.example.countersmvp.model.CountersModel
import com.example.countersmvp.view.IMainView
import moxy.MvpPresenter

class Presenter(private val model: CountersModel) : MvpPresenter<IMainView>() {

    fun counterOneClick() {
        val nextValue = model.next(0)
           viewState.setButtonTextOne(nextValue.toString())
        }
    fun counterTwoClick() {
        val nextValue = model.next(1)
           viewState.setButtonTextTwo(nextValue.toString())
        }
    fun counterThreeClick() {
        val nextValue = model.next(2)
           viewState.setButtonTextThree(nextValue.toString())
        }


}


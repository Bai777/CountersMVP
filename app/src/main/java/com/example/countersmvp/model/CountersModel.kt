package com.example.countersmvp.model

class CountersModel {
    private val counters = mutableListOf(0, 0, 0)

    private fun getCurrent(currentIndex:Int):Int{
        return counters[currentIndex]
    }

    fun next(nextIndex:Int):Int{
        counters[nextIndex]++
        return getCurrent(nextIndex)
    }

    fun set(setIndex:Int, newValue:Int){
        counters[setIndex] = newValue
    }
}
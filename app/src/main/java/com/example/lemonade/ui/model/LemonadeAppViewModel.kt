package com.example.lemonade.ui.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.lemonade.state.*

class LemonadeAppViewModel : ViewModel() {
    val lemonTreeState: LemonadeAppState = LemonTreeState(this)
    val lemonState: LemonadeAppState = LemonState(this)
    val lemonadeState: LemonadeAppState = LemonadeState(this)
    val emptyGlassState: LemonadeAppState = EmptyGlassState(this)

    var currentState by mutableStateOf(lemonTreeState)
    var remainingTaps by mutableStateOf(1)
    private var hasSetRemainingTaps by mutableStateOf(false)

    fun changeState(lemonadeAppState: LemonadeAppState) {
        currentState = lemonadeAppState
    }

    fun setValueRemainingTaps() {
        if (!hasSetRemainingTaps) {
            remainingTaps = (1..4).random()
            hasSetRemainingTaps = true
        }
    }

    fun removeValueRemainingTaps() {
        hasSetRemainingTaps = false
    }

    fun reduceValueRemainingTaps() {
        remainingTaps--
    }
}

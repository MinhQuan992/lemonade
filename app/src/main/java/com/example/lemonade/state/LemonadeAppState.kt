package com.example.lemonade.state

import androidx.compose.runtime.Composable

interface LemonadeAppState {
    @Composable
    fun LemonadeAppUi()

    fun onImageClick()
}
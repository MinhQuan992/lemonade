package com.example.lemonade.state

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.lemonade.R
import com.example.lemonade.ui.component.ClickableImageWithText
import com.example.lemonade.ui.model.LemonadeAppViewModel

class LemonState(private val lemonadeAppViewModel: LemonadeAppViewModel) : LemonadeAppState {
    @Composable
    override fun LemonadeAppUi() {
        val lemonTree = painterResource(id = R.drawable.lemon_squeeze)
        val text = stringResource(id = R.string.tap_lemon)

        lemonadeAppViewModel.setValueRemainingTaps()

        ClickableImageWithText(
            image = lemonTree,
            imageDescription = "Lemon",
            text = "$text\n${lemonadeAppViewModel.remainingTaps} "
                    + "${if (lemonadeAppViewModel.remainingTaps > 1) "taps" else "tap"} remaining.",
            handler = { onImageClick() }
        )
    }

    override fun onImageClick() {
        lemonadeAppViewModel.reduceValueRemainingTaps()
        if (lemonadeAppViewModel.remainingTaps == 0) {
            lemonadeAppViewModel.changeState(lemonadeAppViewModel.lemonadeState)
        }
    }
}
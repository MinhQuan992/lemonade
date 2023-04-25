package com.example.lemonade.state

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.lemonade.R
import com.example.lemonade.ui.component.ClickableImageWithText
import com.example.lemonade.ui.model.LemonadeAppViewModel

class LemonadeState(private val lemonadeAppViewModel: LemonadeAppViewModel) : LemonadeAppState {
    @Composable
    override fun LemonadeAppUi() {
        val lemonTree = painterResource(id = R.drawable.lemon_drink)
        val text = stringResource(id = R.string.tap_lemonade)

        ClickableImageWithText(
            image = lemonTree,
            imageDescription = "Lemonade",
            text = text,
            handler = { onImageClick() }
        )
    }

    override fun onImageClick() {
        lemonadeAppViewModel.changeState(lemonadeAppViewModel.emptyGlassState)
    }
}
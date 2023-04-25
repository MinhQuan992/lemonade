package com.example.lemonade.state

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.lemonade.R
import com.example.lemonade.ui.component.ClickableImageWithText
import com.example.lemonade.ui.model.LemonadeAppViewModel

class LemonTreeState(private val lemonadeAppViewModel: LemonadeAppViewModel) : LemonadeAppState {
    @Composable
    override fun LemonadeAppUi() {
        val lemonTree = painterResource(id = R.drawable.lemon_tree)
        val text = stringResource(id = R.string.tap_lemon_tree)

        ClickableImageWithText(
            image = lemonTree,
            imageDescription = "Lemon tree",
            text = text,
            handler = { onImageClick() }
        )
    }

    override fun onImageClick() {
        lemonadeAppViewModel.changeState(lemonadeAppViewModel.lemonState)
    }
}
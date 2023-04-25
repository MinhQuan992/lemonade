package com.example.lemonade.state

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.lemonade.R
import com.example.lemonade.ui.component.ClickableImageWithText
import com.example.lemonade.ui.model.LemonadeAppViewModel

class EmptyGlassState(private val lemonadeAppViewModel: LemonadeAppViewModel) : LemonadeAppState {
    @Composable
    override fun LemonadeAppUi() {
        val lemonTree = painterResource(id = R.drawable.lemon_restart)
        val text = stringResource(id = R.string.tap_empty_glass)
        val context = LocalContext.current

        ClickableImageWithText(
            image = lemonTree,
            imageDescription = "Empty glass",
            text = text,
            handler = {
                onImageClick()
                Toast.makeText(
                    context,
                    "Do those steps again to have a new lemonade.",
                    Toast.LENGTH_LONG
                ).show()
            }
        )
    }

    override fun onImageClick() {
        lemonadeAppViewModel.removeValueRemainingTaps()
        lemonadeAppViewModel.changeState(lemonadeAppViewModel.lemonTreeState)
    }
}
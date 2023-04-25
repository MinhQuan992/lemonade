package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lemonade.ui.model.LemonadeAppViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeMainActivity()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeMainActivity(lemonadeAppViewModel: LemonadeAppViewModel = viewModel()) {
    lemonadeAppViewModel.currentState.LemonadeAppUi()
}
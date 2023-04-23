package com.example.lemonade.ui.component

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.R
import com.example.lemonade.ui.theme.LemonadeTheme

@Composable
fun ClickableImageWithText(
    image: Painter,
    imageDescription: String,
    text: String,
    handler: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = text,
            fontSize = 18.sp
        )
        Spacer(modifier = modifier.requiredHeight(10.dp))
        Image(
            painter = image,
            contentDescription = imageDescription,
            modifier = modifier
                .border(2.dp, Color.Blue)
                .padding(15.dp)
                .clickable { handler() }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ClickableImageWithTextPreview() {
    val image = painterResource(id = R.drawable.lemon_drink)
    val text = stringResource(id = R.string.tap_lemonade)
    val context = LocalContext.current
    val handler = {
        Toast.makeText(context, "This is a sample toast", Toast.LENGTH_LONG).show()
    }

    LemonadeTheme {
        ClickableImageWithText(
            image = image,
            imageDescription = "Lemonade",
            text = text,
            handler = handler
        )
    }
}
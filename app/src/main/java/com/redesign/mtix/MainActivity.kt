package com.redesign.mtix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.redesign.mtix.ui.components.button.*
import com.redesign.mtix.ui.components.card.HorizontalMovieCard
import com.redesign.mtix.ui.components.card.VerticalMovieCard
import com.redesign.mtix.ui.screen.MtixApp
import com.redesign.mtix.ui.theme.Dimens
import com.redesign.mtix.ui.theme.MtixTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MtixTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MtixApp()
                }
            }
        }
    }
}

@Composable
fun Greeting() {

    LazyColumn() {
        item() {
            MyButton(label = "Label", onClick = {})
            Spacer(modifier = Modifier.height(Dimens.spacing_8))
            MyButton(label = "Label", state = ButtonState.SECONDARY, onClick = {})
            Spacer(modifier = Modifier.height(Dimens.spacing_8))
            MyButton(label = "Label", state = ButtonState.LINK, onClick = {})

            Row {
                Column() {
                    MyIconButton(
                        icon = painterResource(id = R.drawable.outline_heart),
                        onClick = {},
                        type = IconButtonType.Rounded,
                        size = ButtonSize.LARGE
                    )
                    MyIconButton(
                        icon = painterResource(id = R.drawable.outline_heart),
                        onClick = {},
                        type = IconButtonType.Rounded,
                        size = ButtonSize.SMALL
                    )
                    MyIconButton(
                        icon = painterResource(id = R.drawable.outline_heart),
                        onClick = {},
                        type = IconButtonType.Circle,
                        size = ButtonSize.LARGE
                    )
                    MyIconButton(
                        icon = painterResource(id = R.drawable.outline_heart),
                        onClick = {},
                        type = IconButtonType.Circle,
                        size = ButtonSize.SMALL
                    )
                }
                Spacer(modifier = Modifier.width(Dimens.spacing_8))
                Column() {
                    MyIconButton(
                        icon = painterResource(id = R.drawable.outline_heart),
                        onClick = {},
                        type = IconButtonType.Rounded,
                        state = ButtonState.SECONDARY,
                        size = ButtonSize.LARGE
                    )
                    MyIconButton(
                        icon = painterResource(id = R.drawable.outline_heart),
                        onClick = {},
                        type = IconButtonType.Rounded,
                        state = ButtonState.SECONDARY,
                        size = ButtonSize.SMALL
                    )
                    MyIconButton(
                        icon = painterResource(id = R.drawable.outline_heart),
                        onClick = {},
                        type = IconButtonType.Circle,
                        state = ButtonState.SECONDARY,
                        size = ButtonSize.LARGE
                    )
                    MyIconButton(
                        icon = painterResource(id = R.drawable.outline_heart),
                        onClick = {},
                        type = IconButtonType.Circle,
                        state = ButtonState.SECONDARY,
                        size = ButtonSize.SMALL
                    )
                }
            }

            LabelButton(onClick = { /*TODO*/ }, title = "IMAX 2D")
            Spacer(modifier = Modifier.height(Dimens.spacing_8))
            LabelButton(onClick = { /*TODO*/ }, title = "IMAX 2D", state = ButtonState.SECONDARY)

            Spacer(modifier = Modifier.height(Dimens.spacing_8))
            HorizontalMovieCard(
                imageUrl = "https://i.pinimg.com/736x/a8/34/0f/a8340fcf1622ce504f83c922cfe60f46.jpg",
                title = "Mission Impossible : Dead reckoning - Part One",
                ageRating = "13+",
                genre = "Action, Adventure",
                duration = "163",
                studio = ""
            )
            Spacer(modifier = Modifier.height(Dimens.spacing_8))
            VerticalMovieCard(
                imageUrl = "https://i.pinimg.com/736x/a8/34/0f/a8340fcf1622ce504f83c922cfe60f46.jpg",
                studio = "IMAX 2D"
            )
            Spacer(modifier = Modifier.height(Dimens.spacing_16))
            VerticalMovieCard(
                imageUrl = "https://i.pinimg.com/736x/a8/34/0f/a8340fcf1622ce504f83c922cfe60f46.jpg",
                studio = "IMAX 2D",
                title = "Mission: IMPOSSIBLE - Dead Reckoning"
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MtixTheme {
        Greeting()
    }
}
package com.redesign.mtix.ui.components.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.redesign.mtix.R
import com.redesign.mtix.ui.components.button.ButtonState
import com.redesign.mtix.ui.components.button.LabelButton
import com.redesign.mtix.ui.theme.*

@Composable
fun HorizontalMovieCard(
    modifier: Modifier = Modifier,
    imageUrl: String,
    title: String,
    genre: String,
    duration: String,
    ageRating: String,
    studio: String,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current).data(imageUrl).crossfade(true)
                .build(),
            contentDescription = title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(104.dp)
                .height(144.dp)
                .clip(Shapes.large)
        )
        Spacer(modifier = Modifier.width(Dimens.spacing_16))
        Column {
            Text(
                text = title,
                style = typography.bodySmall.copy(
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Bold,
                ),
                modifier = Modifier.padding(bottom = Dimens.spacing_8)
            )
            Text(
                text = "$genre ~ $duration minutes",
                style = typography.labelLarge.copy(
                    color = MaterialTheme.colorScheme.surfaceTint
                ),
                modifier = Modifier.padding(bottom = Dimens.spacing_8)
            )
            Text(
                text = ageRating,
                style = typography.labelLarge.copy(
                    color = Error300
                ),
                modifier = Modifier.padding(bottom = Dimens.spacing_16)
            )
            GenreList()
        }
    }

}

@Composable
private fun GenreList(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LabelButton(onClick = { /*TODO*/ }, title = "2D", state = ButtonState.SECONDARY)
        Spacer(modifier = Modifier.width(Dimens.spacing_8))
        LabelButton(onClick = { /*TODO*/ }, title = "IMAX 2D", state = ButtonState.SECONDARY)
        Spacer(modifier = Modifier.width(Dimens.spacing_8))
        LabelButton(onClick = { /*TODO*/ }, title = "PREMIERE ", state = ButtonState.SECONDARY)
    }
}

@Preview(showBackground = true)
@Composable
private fun HorizontalMovieCardPreview() {
    MtixTheme() {
        HorizontalMovieCard(
            imageUrl = "https://i.pinimg.com/736x/a8/34/0f/a8340fcf1622ce504f83c922cfe60f46.jpg",
            title = "Mission Impossible : Dead reckoning - Part One",
            ageRating = "13+",
            genre = "Action, Adventure",
            duration = "163",
            studio = ""
        )
    }
}
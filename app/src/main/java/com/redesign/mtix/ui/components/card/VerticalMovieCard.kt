package com.redesign.mtix.ui.components.card

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.redesign.mtix.ui.components.button.LabelButton
import com.redesign.mtix.ui.theme.Dimens
import com.redesign.mtix.ui.theme.MtixTheme
import com.redesign.mtix.ui.theme.Shapes

@Composable
fun VerticalMovieCard(
    modifier: Modifier = Modifier,
    imageUrl: String,
    title: String? = null,
    studio: String,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current).data(imageUrl).crossfade(true)
                    .build(),
                contentDescription = title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(if (title != null) 180.dp else 200.dp)
                    .clip(Shapes.large)
            )
            LabelButton(
                onClick = { /* Do Nothing */ },
                title = studio,
                modifier = Modifier.padding(Dimens.spacing_8)
            )
        }
        if (title != null) {
            Spacer(modifier = Modifier.height(Dimens.spacing_8))
            Text(
                text = title,
                style = typography.bodyMedium.copy(fontWeight = FontWeight.Medium),
                textAlign = TextAlign.Center,
                modifier=Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun VerticalMovieCardPreview() {
    MtixTheme {
        Column {
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
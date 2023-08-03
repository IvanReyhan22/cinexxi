package com.redesign.mtix.ui.screen.home

//import androidx.compose.foundation.pager.HorizontalPager

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.redesign.mtix.R
import com.redesign.mtix.ui.components.card.VerticalMovieCard
import com.redesign.mtix.ui.components.other.MyCarousel
import com.redesign.mtix.ui.theme.Dimens
import com.redesign.mtix.ui.theme.MtixTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    val configuration = LocalConfiguration.current
    val navigationBarHeight = configuration.navigation

    val images = listOf(
        R.drawable.template_image,
        R.drawable.horizontal_image_template,
    )
    LazyColumn(
        modifier = modifier
//            .padding(bottom = )
            .fillMaxSize(),
    ) {
        item {
            MyCarousel(
                itemsCount = images.size,
                itemContent = {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.template_image),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                        Box(
                            modifier = Modifier
                                .matchParentSize()
                                .background(
                                    Brush.verticalGradient(
                                        listOf(
                                            Color.Transparent,
                                            MaterialTheme.colorScheme.background
                                        ),
                                        0F,
                                        LocalConfiguration.current.screenHeightDp.toFloat() * 0.85F
                                    )
                                ),
                        )
                    }
                },
            )

            // Now Showing
            SectionHeading(
                text = stringResource(R.string.now_showing),
                onAllClicked = {},
                modifier = Modifier.padding(bottom = Dimens.spacing_16)
            )
            MovieCarousel(
                modifier = Modifier.padding(bottom = Dimens.spacing_24)
            )

            // Advance Ticket
            SectionHeading(
                text = stringResource(R.string.advance_ticket),
                onAllClicked = {},
                modifier = Modifier.padding(bottom = Dimens.spacing_16)
            )
            AdvanceTicket()
        }
    }
}

@Composable
private fun SectionHeading(
    modifier: Modifier = Modifier,
    text: String,
    onAllClicked: () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(horizontal = Dimens.spacing_24)
            .fillMaxWidth()
    ) {
        Text(
            text = text,
            style = typography.bodyLarge.copy(
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onBackground
            )
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable {
                onAllClicked()
            }
        ) {
            Text(
                text = stringResource(R.string.all),
                style = typography.bodySmall.copy(
                    color = MaterialTheme.colorScheme.surfaceTint
                )
            )
            Spacer(modifier = Modifier.width(Dimens.spacing_4))
            Image(
                painter = painterResource(id = R.drawable.ic_outline_chevron_right),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surfaceTint),
                modifier = Modifier.size(Dimens.spacing_14)
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun MovieCarousel(
    modifier: Modifier = Modifier,
) {
    /* TODO: Carousel is working ok but still not as expected, run it and you'll now */
    HorizontalPager(
        count = 10,
        modifier = modifier.fillMaxSize()
    ) { page ->
        Card(
            colors = CardDefaults.cardColors(Color.Transparent),
            modifier = Modifier
                .graphicsLayer {
                    val pageOffset = calculateCurrentOffsetForPage(page)
                    lerp(
                        start = 0.85f.dp,
                        stop = 1f.dp,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    ).also { scale ->
                        scaleX = scale.value
                        scaleY = scale.value
                    }
                    alpha = lerp(
                        start = 0.5f.dp,
                        stop = 1f.dp,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    ).value
                }
                .fillMaxWidth(0.88f)
        ) {
            VerticalMovieCard(
                imageUrl = "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fimages.wallpapersden.com%2Fimage%2Fwxl-mission-impossible-dead-reckoning-official-poster_90699.jpg&f=1&nofb=1&ipt=81c6cf3f06bfab5cf0b7d03e0ceb34bf933ba9ad39b91f79b3ed96c54e665325&ipo=images",
                studio = "2D",
                title = "Mission: IMPOSSIBLE - Dead Reckoning",
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
private fun AdvanceTicket(
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = Dimens.spacing_24)
    ) {
        item {
            VerticalMovieCard(
                imageUrl = "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fimages.wallpapersden.com%2Fimage%2Fwxl-mission-impossible-dead-reckoning-official-poster_90699.jpg&f=1&nofb=1&ipt=81c6cf3f06bfab5cf0b7d03e0ceb34bf933ba9ad39b91f79b3ed96c54e665325&ipo=images",
                studio = "2D",
                modifier = Modifier.fillMaxWidth(0.5f)
            )
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL)
@Composable
private fun HomeScreenPreview() {
    MtixTheme {
        HomeScreen(navController = rememberNavController())
    }
}
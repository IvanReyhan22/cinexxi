package com.redesign.mtix.ui.screen.movie.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.redesign.mtix.R
import com.redesign.mtix.ui.components.button.ButtonSize
import com.redesign.mtix.ui.components.button.ButtonState
import com.redesign.mtix.ui.components.button.MyButton
import com.redesign.mtix.ui.navigation.Screen
import com.redesign.mtix.ui.theme.Dimens
import com.redesign.mtix.ui.theme.MtixTheme
import com.redesign.mtix.ui.theme.Shades0

@Composable
fun MovieDetailScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    LazyColumn(modifier = modifier) {
        item {
            Heading(modifier = Modifier.padding(bottom = Dimens.spacing_16))
        }
        item {
            MovieData()
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(Dimens.spacing_24),
                color = MaterialTheme.colorScheme.surfaceVariant,
                thickness = Dimens.spacing_1,
            )
            Ticket(
                modifier = Modifier.padding(bottom = Dimens.spacing_16)
            )
        }
        items(4) {
            Theater(onTimeClicked = {
                navController.navigate(Screen.SelectSeat.route)
            })
        }
    }
}

@Composable
private fun Heading(
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.BottomStart,
        modifier = modifier
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
        IconButton(
            onClick = { /*TODO*/ },
            colors = IconButtonDefaults.iconButtonColors(MaterialTheme.colorScheme.primary),
            content = {
                Image(
                    painter = painterResource(id = R.drawable.ic_solid_play),
                    colorFilter = ColorFilter.tint(Shades0),
                    contentDescription = null
                )
            },
            modifier = Modifier
                .size(Dimens.spacing_48)
                .offset(x = Dimens.spacing_24, y = Dimens.zero)
        )

    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun MovieData(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(horizontal = Dimens.spacing_24)) {
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(bottom = Dimens.spacing_16)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    "Mission: IMPOSSIBLE - Dead Reckoning",
                    style = typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground
                    ),
                    modifier = Modifier.padding(bottom = Dimens.spacing_4)
                )
                Text(
                    "Part One ~ 163 minutes",
                    style = typography.bodySmall.copy(
                        color = MaterialTheme.colorScheme.surfaceTint
                    ),
                    modifier = Modifier.weight(1f)
                )
            }
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .border(
                        width = Dimens.spacing_2,
                        color = MaterialTheme.colorScheme.surface,
                        shape = CircleShape
                    )
                    .size(Dimens.spacing_40)
            ) {
                Text(
                    text = "13+",
                    style = typography.bodySmall.copy(
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                )
            }
        }

        // Genre List
        FlowRow(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Top,
            modifier = Modifier.padding(bottom = Dimens.spacing_24)
        ) {
            MyButton(
                label = "Action",
                state = ButtonState.SECONDARY,
                size = ButtonSize.SMALL,
                modifier = Modifier.padding(end = Dimens.spacing_8),
                onClick = {})
            MyButton(
                label = "Adventure",
                state = ButtonState.SECONDARY,
                size = ButtonSize.SMALL,
                modifier = Modifier.padding(end = Dimens.spacing_8),
                onClick = {})
            MyButton(
                label = "Adventure",
                state = ButtonState.SECONDARY,
                size = ButtonSize.SMALL,
                modifier = Modifier.padding(end = Dimens.spacing_8),
                onClick = {})
        }

        val desc = buildAnnotatedString {
            withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.surfaceTint)) {
                append("In Mission: Impossible - Dead Reckoning Part One, Ethan Hunt (Tom Cruise) ... ")
            }
            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.SemiBold,
                )
            ) {
                append("Read More")
            }
        }

        Text(text = desc, style = typography.bodySmall, modifier = Modifier.fillMaxWidth())
    }
}

@Composable
private fun Ticket(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(start = Dimens.spacing_24, end = Dimens.spacing_24, bottom = Dimens.spacing_16)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(bottom = Dimens.spacing_16)
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.ticket),
                style = typography.bodyLarge.copy(
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onBackground
                )
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable {

                }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_outline_location),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary),
                    modifier = Modifier.size(Dimens.spacing_18)
                )
                Spacer(modifier = Modifier.width(Dimens.spacing_4))
                Text(
                    text = "Malang",
                    style = typography.bodySmall.copy(
                        color = MaterialTheme.colorScheme.primary
                    )
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            MyButton(
                label = "CINEMA XX",
                state = ButtonState.ACTIVE,
                size = ButtonSize.SMALL,
                modifier = Modifier.padding(end = Dimens.spacing_8),
                onClick = {})
            MyButton(
                label = "PREMIERE",
                state = ButtonState.SECONDARY,
                size = ButtonSize.SMALL,
                modifier = Modifier.padding(end = Dimens.spacing_8),
                onClick = {})
            MyButton(
                label = "IMAX 2D",
                state = ButtonState.SECONDARY,
                size = ButtonSize.SMALL,
                modifier = Modifier.padding(end = Dimens.spacing_8),
                onClick = {})
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun Theater(
    modifier: Modifier = Modifier,
    onTimeClicked: () -> Unit,
) {
    Column(
        modifier = modifier.padding(
            start = Dimens.spacing_24,
            end = Dimens.spacing_24,
            bottom = Dimens.spacing_16,
        )
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(bottom = Dimens.spacing_16)
                .fillMaxWidth()
        ) {
            Text(
                text = "Dieng",
                style = typography.bodyMedium.copy(
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onBackground
                )
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable {

                }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_outline_location),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surfaceTint),
                    modifier = Modifier.size(Dimens.spacing_18)
                )
                Spacer(modifier = Modifier.width(Dimens.spacing_4))
                Text(
                    text = "1.5 km",
                    style = typography.bodySmall.copy(
                        color = MaterialTheme.colorScheme.surfaceTint
                    )
                )
            }
        }
        FlowRow(maxItemsInEachRow = 5) {
            MyButton(
                label = "09:00",
                state = ButtonState.SECONDARY,
                size = ButtonSize.SMALL,
                modifier = Modifier.padding(end = Dimens.spacing_8, bottom = Dimens.spacing_8),
                onClick = {
                    onTimeClicked()
                })
            MyButton(
                label = "11:00",
                state = ButtonState.SECONDARY,
                size = ButtonSize.SMALL,
                modifier = Modifier.padding(end = Dimens.spacing_8, bottom = Dimens.spacing_8),
                onClick = { onTimeClicked() })
            MyButton(
                label = "13:00",
                state = ButtonState.SECONDARY,
                size = ButtonSize.SMALL,
                modifier = Modifier.padding(end = Dimens.spacing_8, bottom = Dimens.spacing_8),
                onClick = { onTimeClicked() })
            MyButton(
                label = "15:20",
                state = ButtonState.SECONDARY,
                size = ButtonSize.SMALL,
                modifier = Modifier.padding(end = Dimens.spacing_8, bottom = Dimens.spacing_8),
                onClick = { onTimeClicked() })
            MyButton(
                label = "18:40",
                state = ButtonState.SECONDARY,
                size = ButtonSize.SMALL,
                modifier = Modifier.padding(end = Dimens.spacing_8, bottom = Dimens.spacing_8),
                onClick = { onTimeClicked() })
            MyButton(
                label = "21:00",
                state = ButtonState.SECONDARY,
                size = ButtonSize.SMALL,
                modifier = Modifier.padding(end = Dimens.spacing_8, bottom = Dimens.spacing_8),
                onClick = { onTimeClicked() })
        }
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = Dimens.spacing_8),
            color = MaterialTheme.colorScheme.surfaceVariant,
            thickness = Dimens.spacing_1,
        )
    }
}

@Preview(showBackground = true, device = Devices.PIXEL)
@Composable
fun MovieDetailScreenPreview() {
    MtixTheme {
        MovieDetailScreen(navController = rememberNavController())
    }
}
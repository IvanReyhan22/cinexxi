package com.redesign.mtix.ui.screen.movie.seat

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.redesign.mtix.R
import com.redesign.mtix.data.dummy.DummyData
import com.redesign.mtix.data.dummy.Seat
import com.redesign.mtix.ui.components.button.*
import com.redesign.mtix.ui.navigation.Screen
import com.redesign.mtix.ui.theme.*

@Composable
fun SelectSeatScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Column(
        modifier = modifier
            .padding(horizontal = Dimens.spacing_24, vertical = Dimens.spacing_24)
            .fillMaxSize()
    ) {
        Column(
            modifier = modifier.weight(1f)
        ) {
            TopBar(
                onBackClicked = {
                    navController.popBackStack()
                },
                title = "Mission Impossible - Dead Reckoning",
                onClockClicked = {/*TODO*/ },
                modifier = Modifier.padding(bottom = Dimens.spacing_24)
            )

            // Location
            Box(
                contentAlignment = Alignment.TopCenter,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = Dimens.spacing_24)
            ) {
                MyButton(
                    label = "ARAYA XXI",
                    onClick = {},
                    size = ButtonSize.SMALL,
                    prefixIcon = painterResource(id = R.drawable.ic_outline_location)
                )
            }

            //Screen Indicator
            Image(
                painter = painterResource(id = R.drawable.screen_indicator),
                contentDescription = stringResource(
                    R.string.screen_indicator
                ),
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = Dimens.spacing_48)
            )
            LazyVerticalGrid(columns = GridCells.Fixed(9)) {
                items(DummyData.seatData) { item ->
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.padding(bottom = Dimens.spacing_8)
                    ) {
                        MovieSeats(seat = item, modifier = Modifier.size(30.dp))
                    }
                }
            }
        }
        Column {
            SeatInfo(modifier = Modifier.padding(bottom = Dimens.spacing_16))
            MyButton(
                label = stringResource(R.string.select_a_seat),
                onClick = {
                    navController.navigate(Screen.TicketPayment.route)
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }

}

@Composable
private fun TopBar(
    modifier: Modifier = Modifier,
    onBackClicked: () -> Unit,
    title: String,
    onClockClicked: () -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        MyIconButton(
            onClick = onBackClicked,
            icon = painterResource(id = R.drawable.ic_outline_arrow_left),
            type = IconButtonType.Rounded,
            state = ButtonState.SECONDARY,
            size = ButtonSize.LARGE
        )
        Spacer(modifier = Modifier.width(Dimens.spacing_24))
        Text(
            text = title,
            style = typography.bodyMedium.copy(
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onBackground
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(Dimens.spacing_24))
        MyIconButton(
            onClick = onClockClicked,
            icon = painterResource(id = R.drawable.ic_outline_clock),
            type = IconButtonType.Rounded,
            state = ButtonState.SECONDARY,
            size = ButtonSize.LARGE
        )
    }
}

@Composable
private fun SeatInfo(
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        SeatIndicator(type = 1)
        SeatIndicator(type = 2)
        SeatIndicator(type = 3)
    }
}

@Composable
private fun SeatIndicator(modifier: Modifier = Modifier, type: Int) {
    val color = when (type) {
        1 -> Neutral200
        2 -> Error500
        3 -> Alpine400
        else -> Neutral200
    }

    val text: String = when (type) {
        1 -> stringResource(R.string.available_seats)
        2 -> stringResource(R.string.booked_seats)
        3 -> stringResource(R.string.selected_seats)
        else -> stringResource(R.string.unidentified)
    }

    Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier) {
        Box(
            modifier = Modifier
                .background(color = color, shape = Shapes.small)
                .size(Dimens.spacing_12)
        ) {}
        Spacer(modifier = Modifier.width(Dimens.spacing_4))
        Text(
            text = text,
            style = typography.labelLarge.copy(color = MaterialTheme.colorScheme.onBackground)
        )
    }
}

@Composable
private fun MovieSeats(
    modifier: Modifier = Modifier,
    seat: Seat
) {
    val color = when (seat.state) {
        0 -> MaterialTheme.colorScheme.surfaceVariant
        1 -> Error500
        2 -> Alpine400
        else -> Neutral200
    }

    val textColor = when (seat.state) {
        0 -> MaterialTheme.colorScheme.onBackground
        else -> Shades0
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .width(30.dp)
            .height(30.dp)
            .background(
                color = if (seat.type == 0) Color.Transparent else color,
                shape = Shapes.large
            )
    ) {
        Text(
            text = seat.title,
            style = typography.labelLarge.copy(color = textColor, fontWeight = FontWeight.SemiBold)
        )
    }
}

@Preview(showBackground = true, device = Devices.PIXEL)
@Composable
fun SelectSeatScreenPreview() {
    MtixTheme {
        SelectSeatScreen(navController = rememberNavController())
    }
}
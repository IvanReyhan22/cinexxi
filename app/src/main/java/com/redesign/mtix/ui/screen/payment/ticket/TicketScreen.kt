package com.redesign.mtix.ui.screen.payment.ticket

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.redesign.mtix.R
import com.redesign.mtix.ui.components.button.MyButton
import com.redesign.mtix.ui.components.card.HorizontalMovieCard
import com.redesign.mtix.ui.navigation.Screen
import com.redesign.mtix.ui.theme.Dimens
import com.redesign.mtix.ui.theme.MtixTheme
import com.redesign.mtix.ui.theme.Shapes

@Composable
fun TicketScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Column(
        modifier = modifier.padding(
            start = Dimens.spacing_24,
            end = Dimens.spacing_24,
            bottom = Dimens.spacing_24,
        )
    ) {
        Column(modifier= Modifier
            .weight(1f)
            .verticalScroll(rememberScrollState())) {
            Spacer(modifier = Modifier.height(Dimens.spacing_24))
            Row(horizontalArrangement = Arrangement.Center) {
                Text(
                    text = stringResource(R.string.your_ticket),
                    style = typography.bodyMedium.copy(
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onBackground
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f)
                )
            }
            Spacer(modifier = Modifier.height(Dimens.spacing_24))
            HorizontalMovieCard(
                imageUrl = "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fimages.wallpapersden.com%2Fimage%2Fwxl-mission-impossible-dead-reckoning-official-poster_90699.jpg&f=1&nofb=1&ipt=81c6cf3f06bfab5cf0b7d03e0ceb34bf933ba9ad39b91f79b3ed96c54e665325&ipo=images",
                title = "Mission: IMPOSSIBLE - Dead Reckoning",
                genre = "Action, Adventure",
                duration = "162",
                ageRating = "13",
                studio = "2D",
            )
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = Dimens.spacing_24),
                color = MaterialTheme.colorScheme.surfaceVariant,
                thickness = Dimens.spacing_1,
            )

            // Ticket Information
            Row {
                TicketInformation(
                    label = stringResource(id = R.string.seats),
                    value = "C2, C3, C4",
                    modifier = Modifier.weight(1f)
                )
                TicketInformation(
                    label = stringResource(id = R.string.time), value = "17:45",
                    modifier = Modifier.weight(1f)
                )
            }
            Spacer(modifier = Modifier.height(Dimens.spacing_16))
            Row() {
                TicketInformation(
                    label = stringResource(id = R.string.date),
                    value = "Monday, 20 June",
                    modifier = Modifier.weight(1f)
                )
                TicketInformation(
                    label = stringResource(R.string.ticket_id),
                    value = "00167254378",
                    modifier = Modifier.weight(1f)
                )
            }

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = Dimens.spacing_24),
                color = MaterialTheme.colorScheme.surfaceVariant,
                thickness = Dimens.spacing_1,
            )

            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Image(
                    painter = painterResource(R.drawable.qr_template),
                    contentDescription = "QR Code",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(180.dp)
                        .border(
                            width = Dimens.spacing_2,
                            color = MaterialTheme.colorScheme.surface,
                            shape = Shapes.large
                        )
                        .padding(Dimens.spacing_8)
                )
            }
            Spacer(modifier = Modifier.height(Dimens.spacing_24))
        }
        Column {
            MyButton(
                label = stringResource(R.string.select_a_seat),
                onClick = {
                    navController.navigate(Screen.Home.route)
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
private fun TicketInformation(modifier: Modifier = Modifier, label: String, value: String) {
    Column(modifier = modifier) {
        Text(
            text = label,
            style = typography.bodySmall.copy(color = MaterialTheme.colorScheme.surfaceTint)
        )
        Spacer(modifier = Modifier.height(Dimens.spacing_8))
        Text(
            text = value,
            style = typography.bodyMedium.copy(
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.SemiBold
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TicketScreenPreview() {
    MtixTheme {
        TicketScreen(navController = rememberNavController())
    }
}
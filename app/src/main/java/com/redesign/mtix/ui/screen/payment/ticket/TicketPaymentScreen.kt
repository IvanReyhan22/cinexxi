package com.redesign.mtix.ui.screen.payment.ticket

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.redesign.mtix.R
import com.redesign.mtix.ui.components.button.*
import com.redesign.mtix.ui.components.card.HorizontalMovieCard
import com.redesign.mtix.ui.components.input.MyTextField
import com.redesign.mtix.ui.navigation.Screen
import com.redesign.mtix.ui.theme.Dimens
import com.redesign.mtix.ui.theme.MtixTheme

@Composable
fun TicketPaymentScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    LazyColumn(
        modifier = modifier.padding(
            start = Dimens.spacing_24,
            end = Dimens.spacing_24,
        )
    ) {
        item {
            Spacer(modifier = Modifier.height(Dimens.spacing_24))
            TopBar(onBackClicked = {
                navController.popBackStack()
            }, title = stringResource(R.string.payment))
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

            TransactionDetail()

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = Dimens.spacing_24),
                color = MaterialTheme.colorScheme.surfaceVariant,
                thickness = Dimens.spacing_1,
            )

            MyTextField(
                onValueChange = {},
                value = "",
                placeholder = stringResource(R.string.voucher),
                label = stringResource(R.string.voucher),
                trailingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.ic_outline_chevron_down),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surfaceTint),
                        modifier = Modifier.size(Dimens.spacing_16)
                    )
                }
            )
            Spacer(modifier = Modifier.height(Dimens.spacing_24))
            MyTextField(
                onValueChange = {},
                value = "Mtix Point",
                placeholder = stringResource(R.string.voucher),
                label = stringResource(R.string.payment_method),
                trailingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.ic_outline_chevron_down),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surfaceTint),
                        modifier = Modifier.size(Dimens.spacing_16)
                    )
                }
            )
            Spacer(modifier = Modifier.height(Dimens.spacing_24))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(R.string.total_payment),
                    style = typography.bodySmall.copy(
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onBackground
                    ),
                )
                Text(
                    text = "Rp 75.000",
                    style = typography.bodyMedium.copy(
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onBackground
                    ),
                )
            }
            Spacer(modifier = Modifier.height(Dimens.spacing_24))
            Text(
                text = stringResource(id = R.string.payment_terms),
                style = typography.labelLarge.copy(color = MaterialTheme.colorScheme.surfaceTint)
            )
            Spacer(modifier = Modifier.height(Dimens.spacing_24))
            MyButton(
                label = stringResource(R.string.proceed),
                onClick = {
                    navController.navigate(Screen.MovieTicket.route)
                },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(Dimens.spacing_24))
        }
    }
}

@Composable
private fun TopBar(
    modifier: Modifier = Modifier,
    onBackClicked: () -> Unit,
    title: String,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
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
        Box(modifier = Modifier.width(Dimens.spacing_40)) {}
    }
}

@Composable
private fun TransactionDetail(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = stringResource(R.string.transaction_detail),
            style = typography.bodyMedium.copy(
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onBackground
            ),
        )
        Spacer(modifier = Modifier.height(Dimens.spacing_16))

        TransactionItem(
            name = stringResource(id = R.string.theater),
            value = "Dieng, Malang",
            modifier = Modifier.padding(bottom = Dimens.spacing_8)
        )
        TransactionItem(
            name = stringResource(R.string.time),
            value = "17:45",
            modifier = Modifier.padding(bottom = Dimens.spacing_8)
        )
        TransactionItem(
            name = stringResource(R.string.date),
            value = "Monday, 20 June",
            modifier = Modifier.padding(bottom = Dimens.spacing_8)
        )
        TransactionItem(
            name = stringResource(R.string.seats),
            value = "C2, C3, C4",
            modifier = Modifier.padding(bottom = Dimens.spacing_8)
        )
        TransactionItem(
            name = stringResource(R.string.fee),
            value = "Rp 2.000",
            modifier = Modifier.padding(bottom = Dimens.spacing_8)
        )
        TransactionItem(
            name = stringResource(R.string.ticket_price),
            value = "Rp 25.000 x 3",
            modifier = Modifier.padding(bottom = Dimens.spacing_8)
        )
    }
}

@Composable
private fun TransactionItem(
    modifier: Modifier = Modifier,
    name: String,
    value: String,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = name,
            style = typography.bodySmall.copy(color = MaterialTheme.colorScheme.surfaceTint)
        )
        Spacer(modifier = Modifier.width(Dimens.spacing_16))
        Text(
            text = value,
            style = typography.bodySmall.copy(
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.SemiBold
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TicketPaymentPreview() {
    MtixTheme {
        TicketPaymentScreen(
            navController = rememberNavController()
        )
    }
}
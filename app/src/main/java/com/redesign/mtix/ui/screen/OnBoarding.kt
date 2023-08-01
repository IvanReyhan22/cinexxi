package com.redesign.mtix.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.redesign.mtix.R
import com.redesign.mtix.ui.components.button.ButtonState
import com.redesign.mtix.ui.components.button.MyButton
import com.redesign.mtix.ui.navigation.Screen
import com.redesign.mtix.ui.theme.Dimens
import com.redesign.mtix.ui.theme.MtixTheme

@Composable
fun OnBoarding(
    modifier: Modifier = Modifier, navController: NavController
) {
    Box(modifier = modifier, contentAlignment = Alignment.BottomCenter) {
        Image(
            painter = painterResource(id = R.drawable.template_image),
            contentDescription = stringResource(
                R.string.background_image
            ),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier
                .matchParentSize()
                .background(
                    Brush.verticalGradient(
                        listOf(Color.Transparent, MaterialTheme.colorScheme.background),
                        0F,
                        LocalConfiguration.current.screenHeightDp.toFloat() * 1.8F
                    )
                ),
        ) {
            Content(
                onSignUpClicked = {
                    navController.navigate(Screen.Register.route)
                },
                onSignInClicked = {
                    navController.navigate(Screen.Login.route)
                },
                onSkipClicked = {},
            )
        }
    }
}

@Composable
private fun Content(
    modifier: Modifier = Modifier,
    onSignUpClicked: () -> Unit,
    onSignInClicked: () -> Unit,
    onSkipClicked: () -> Unit,
) {
    Column(modifier = modifier.padding(Dimens.spacing_24)) {
        Text(
            text = stringResource(R.string.welcome).uppercase(),
            style = typography.bodySmall.copy(fontWeight = FontWeight.SemiBold),
            modifier = Modifier.padding(bottom = Dimens.spacing_16),
        )
        Image(
            painter = painterResource(id = R.drawable.logo_dark),
            contentDescription = stringResource(
                R.string.logo_desc
            ),
            modifier = Modifier
                .width(180.dp)
                .height(Dimens.spacing_36)
        )
        Text(
            text = stringResource(R.string.motto),
            style = typography.bodyMedium.copy(MaterialTheme.colorScheme.surfaceTint),
            modifier = Modifier.padding(vertical = Dimens.spacing_24),
        )
        Row(
            modifier = Modifier.padding(bottom = Dimens.spacing_24)
        ) {
            MyButton(
                label = stringResource(R.string.sign_up),
                state = ButtonState.SECONDARY,
                modifier = Modifier
                    .weight(1F)
                    .padding(end = Dimens.spacing_16),
                onClick = onSignUpClicked
            )
            MyButton(
                label = stringResource(R.string.sign_in),
                modifier = Modifier.weight(1F),
                onClick = onSignInClicked,
            )
        }
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            Text(
                text = stringResource(R.string.skip_sign_in),
                style = typography.bodyMedium.copy(MaterialTheme.colorScheme.surfaceTint),
                modifier = Modifier.padding(end = Dimens.spacing_2)
            )
            Text(text = stringResource(R.string.browse_first), style = typography.bodyMedium.copy(
                MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Medium
            ), modifier = Modifier.clickable { onSkipClicked() })
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun OnBoardingPreview() {
    MtixTheme {
        OnBoarding(navController = rememberNavController())
    }
}
package com.redesign.mtix.ui.screen.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.redesign.mtix.R
import com.redesign.mtix.ui.components.button.MyButton
import com.redesign.mtix.ui.components.input.MyTextField
import com.redesign.mtix.ui.components.other.AuthenticationHeading
import com.redesign.mtix.ui.navigation.Screen
import com.redesign.mtix.ui.theme.Dimens
import com.redesign.mtix.ui.theme.MtixTheme

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    val phone by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }
    val password by remember { mutableStateOf("") }

    LazyColumn(
        modifier=modifier.fillMaxSize(),
        contentPadding = PaddingValues(Dimens.spacing_24),
        verticalArrangement = Arrangement.Center
    ) {
        item {
            AuthenticationHeading(
                title = stringResource(id = R.string.sign_in), subTitle = stringResource(
                    id = R.string.motto
                ),
                modifier = Modifier.padding(bottom = Dimens.spacing_32)
            )
            LoginForm(
                phone = phone,
                password = password,
                onPhoneChanged = {},
                isPasswordVisible = isPasswordVisible,
                onPasswordChanged = {},
                modifier = Modifier.padding(bottom = Dimens.spacing_32)
            )
            MyButton(
                label = stringResource(id = R.string.sign_in),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = Dimens.spacing_32),
                onClick = {
                    navController.navigate(Screen.Home.route)
                }
            )
            Separator(modifier = Modifier.padding(bottom = Dimens.spacing_32))
            SocialMedia(
                modifier = Modifier.padding(bottom = Dimens.spacing_32),
                onGoogleClicked = { /*TODO*/ },
                onFacebookClicked = { /*TODO*/ },
                onTwitterClicked = { /*TODO*/ },
            )
            SignUpAccess(onSignUpClicked = {
                navController.navigate(Screen.Register.route)
            })
        }
    }
}

@Composable
private fun LoginForm(
    modifier: Modifier = Modifier,
    phone: String,
    password: String,
    onPhoneChanged: (String) -> Unit,
    isPasswordVisible: Boolean = false,
    onPasswordChanged: (String) -> Unit
) {
    Column(modifier = modifier) {
        MyTextField(
            onValueChange = onPhoneChanged,
            value = phone,
            placeholder = stringResource(R.string.phone_number),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.ic_outline_phone),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surfaceTint),
                    modifier = Modifier.size(Dimens.spacing_16)
                )
            },
        )
        Spacer(modifier = Modifier.height(Dimens.spacing_16))
        MyTextField(
            onValueChange = onPasswordChanged,
            value = password,
            isPassword = true,
            placeholder = stringResource(
                R.string.password
            ),
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.ic_outline_lock),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surfaceTint),
                    modifier = Modifier.size(Dimens.spacing_16)
                )
            },
            trailingIcon = {
                Image(
                    painter = painterResource(id = if (isPasswordVisible) R.drawable.ic_outline_eye_off else R.drawable.ic_outline_eye_on),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surfaceTint),
                    modifier = Modifier.size(Dimens.spacing_16)
                )
            }
        )
    }
}

@Composable
private fun Separator(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Divider(
            modifier = Modifier.weight(1F),
            color = MaterialTheme.colorScheme.surfaceVariant,
            thickness = Dimens.spacing_1,
        )
        Text(
            text = stringResource(R.string.or),
            style = typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurface),
            modifier = Modifier.padding(horizontal = Dimens.spacing_16)
        )
        Divider(
            modifier = Modifier.weight(1F),
            color = MaterialTheme.colorScheme.surfaceVariant,
            thickness = Dimens.spacing_1
        )
    }
}

@Composable
fun SocialMedia(
    modifier: Modifier = Modifier,
    onGoogleClicked: () -> Unit,
    onFacebookClicked: () -> Unit,
    onTwitterClicked: () -> Unit,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_fill_google),
            contentDescription = stringResource(
                R.string.google_login
            ),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(Dimens.spacing_56)
                .clickable {
                    onGoogleClicked()
                }
        )
        Spacer(modifier = Modifier.width(Dimens.spacing_24))
        Image(
            painter = painterResource(id = R.drawable.ic_fill_facebook),
            contentDescription = stringResource(R.string.facebook_login),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(Dimens.spacing_56)
                .clickable {
                    onFacebookClicked()
                }
        )
        Spacer(modifier = Modifier.width(Dimens.spacing_24))
        Image(
            painter = painterResource(id = R.drawable.ic_fill_twitter),
            contentDescription = stringResource(R.string.twitter_login),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(Dimens.spacing_56)
                .clickable {
                    onTwitterClicked()
                }
        )
    }
}

@Composable
private fun SignUpAccess(
    modifier: Modifier = Modifier,
    onSignUpClicked: () -> Unit,
) {
    val terms = buildAnnotatedString {
        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.surfaceTint)) {
            append(stringResource(R.string.new_to_cinexxi))
        }
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Medium,
            )
        ) {
            append(stringResource(R.string.sign_up))
        }
    }

    Text(
        text = terms,
        style = typography.bodyMedium,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )

//    Row(horizontalArrangement = Arrangement.Center, modifier = modifier.fillMaxWidth()) {
//        Text(
//            text = stringResource(R.string.new_to_cinexxi),
//            style = typography.bodyMedium.copy(MaterialTheme.colorScheme.surfaceTint),
//            modifier = Modifier.padding(end = Dimens.spacing_2)
//        )
//        Text(text = stringResource(R.string.sign_up), style = typography.bodyMedium.copy(
//            MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Medium
//        ), modifier = Modifier.clickable { onSignUpClicked() })
//    }
}

@Preview(showBackground = true, device = Devices.PIXEL)
@Composable
private fun LoginScreenPreview() {
    MtixTheme {
        LoginScreen(navController = rememberNavController())
    }
}
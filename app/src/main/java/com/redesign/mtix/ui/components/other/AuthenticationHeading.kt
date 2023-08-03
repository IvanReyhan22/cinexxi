package com.redesign.mtix.ui.components.other

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.redesign.mtix.R
import com.redesign.mtix.ui.theme.Dimens
import com.redesign.mtix.ui.theme.MtixTheme

@Composable
fun AuthenticationHeading(
    modifier: Modifier = Modifier,
    title: String,
    subTitle: String,
) {
    Column(modifier = modifier) {
        Text(
            text = title,
            style = typography.titleLarge.copy(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            ),
            modifier = Modifier.padding(bottom = Dimens.spacing_32)
        )
        Image(
            painter = painterResource(id = R.drawable.logo_dark),
            contentDescription = stringResource(
                id = R.string.logo_desc
            ),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .width(180.dp)
                .height(Dimens.spacing_36),
        )
        Text(
            text = subTitle,
            style = typography.bodyMedium.copy(
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.surfaceTint
            ),
            modifier = Modifier.padding(top = Dimens.spacing_32)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun AuthenticationHeadingPreview() {
    MtixTheme {
        AuthenticationHeading(
            title = "Sign In",
            subTitle = "Your tickets to Movie Paradise. Instant access to movie and your snack."
        )
    }
}
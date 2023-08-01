package com.redesign.mtix.ui.components.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.redesign.mtix.R
import com.redesign.mtix.ui.theme.Dimens
import com.redesign.mtix.ui.theme.MtixTheme
import com.redesign.mtix.ui.theme.Neutral100
import com.redesign.mtix.ui.theme.Shapes

enum class ButtonState {
    ACTIVE,
    DISABLE,
    SECONDARY,
    LINK,
    LOADING
}

enum class ButtonSize {
    LARGE,
    SMALL
}

@Composable
fun MyButton(
    modifier: Modifier = Modifier,
    label: String,
    prefixIcon: Painter? = null,
    suffixIcon: Painter? = null,
    size: ButtonSize = ButtonSize.LARGE,
    state: ButtonState = ButtonState.ACTIVE,
    onClick: () -> Unit,
) {

    // Color
    val btnColors = ButtonDefaults.buttonColors(
        when (state) {
            ButtonState.DISABLE -> MaterialTheme.colorScheme.surfaceVariant
            ButtonState.SECONDARY -> MaterialTheme.colorScheme.background
            ButtonState.LINK -> Color.Transparent
            else -> MaterialTheme.colorScheme.primary
        }
    )
    val contentColor = when (state) {
        ButtonState.DISABLE -> MaterialTheme.colorScheme.surfaceTint
        ButtonState.SECONDARY -> MaterialTheme.colorScheme.onBackground
        ButtonState.LINK -> MaterialTheme.colorScheme.primary
        else -> MaterialTheme.colorScheme.onPrimary
    }

    // Sizing
    val btnSize = if (size == ButtonSize.LARGE) Dimens.spacing_48 else Dimens.spacing_28
    val btnPadding = if (size == ButtonSize.LARGE) Dimens.spacing_24 else Dimens.spacing_16

    Button(
        onClick = { onClick() },
        colors = btnColors,
        shape = Shapes.large,
        border = if (state == ButtonState.SECONDARY) BorderStroke(
            Dimens.spacing_2,
            Neutral100
        ) else null,
        modifier = modifier
            .height(btnSize)
            .widthIn(min = Dimens.spacing_64),
        contentPadding = PaddingValues(horizontal = btnPadding)
    ) {
        if (state == ButtonState.LOADING) { // On Loading
            CircularProgressIndicator(
                strokeWidth = Dimens.spacing_2,
                modifier = Modifier.size(
                    Dimens.spacing_24,
                )
            )
        } else { // On Default
            if (prefixIcon != null) Icon(
                modifier = modifier.padding(end = Dimens.spacing_8),
                color = contentColor,
                size = size,
                icon = prefixIcon
            )
            Text(
                text = label,
                style = if (size == ButtonSize.LARGE) typography.bodyLarge else typography.labelLarge,
                fontWeight = FontWeight.Medium,
                color = contentColor
            )
            if (suffixIcon != null) Icon(
                modifier = modifier.padding(start = Dimens.spacing_8),
                color = contentColor,
                size = size,
                icon = suffixIcon
            )
        }
    }
}

@Composable
private fun Icon(
    modifier: Modifier = Modifier,
    color: Color,
    size: ButtonSize,
    icon: Painter,
) {
    Image(
        modifier = modifier.size(if (size == ButtonSize.LARGE) Dimens.spacing_24 else Dimens.spacing_16),
        painter = icon,
        contentDescription = stringResource(R.string.default_content_description),
        colorFilter = ColorFilter.tint(color)
    )
}

@Preview
@Composable
private fun MyButtonPreview() {
    MtixTheme {
        Column {
            MyButton(label = "Label", onClick = {})
            Spacer(modifier = Modifier.height(Dimens.spacing_8))
            MyButton(label = "Label", state = ButtonState.SECONDARY, onClick = {})
            Spacer(modifier = Modifier.height(Dimens.spacing_8))
            MyButton(label = "Label", state = ButtonState.LINK, onClick = {})
        }
    }
}
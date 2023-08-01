package com.redesign.mtix.ui.components.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.redesign.mtix.R
import com.redesign.mtix.ui.theme.Dimens
import com.redesign.mtix.ui.theme.MtixTheme
import com.redesign.mtix.ui.theme.Shapes

enum class IconButtonType {
    Rounded,
    Circle
}

@Composable
fun MyIconButton(
    modifier: Modifier = Modifier,
    icon: Painter,
    type: IconButtonType = IconButtonType.Rounded,
    size: ButtonSize = ButtonSize.LARGE,
    state: ButtonState = ButtonState.ACTIVE,
    onClick: () -> Unit,
) {
    val btnSize = when (size) {
        ButtonSize.LARGE -> Dimens.spacing_40
        ButtonSize.SMALL -> Dimens.spacing_20
    }

    val btnColor = ButtonDefaults.buttonColors(
        if (state == ButtonState.ACTIVE) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.background
    )

    val btnBorder = if (state == ButtonState.SECONDARY) BorderStroke(
        if(size == ButtonSize.LARGE) Dimens.spacing_2 else Dimens.spacing_1,
        MaterialTheme.colorScheme.surface
    ) else null

    val colorFilter = ColorFilter.tint(
        if (state == ButtonState.SECONDARY) MaterialTheme.colorScheme.onBackground else MaterialTheme.colorScheme.background
    )

    val iconSize = when (size) {
        ButtonSize.LARGE -> Dimens.spacing_24
        ButtonSize.SMALL -> Dimens.spacing_12
    }

    val contentPadding = if (size == ButtonSize.LARGE) Dimens.spacing_8 else Dimens.spacing_4

    val btnShape = when (type) {
        IconButtonType.Rounded -> when (size) {
            ButtonSize.SMALL -> Shapes.medium
            else -> Shapes.large
        }
        else -> Shapes.extraLarge
    }

    Button(
        onClick = onClick,
        colors = btnColor,
        shape = btnShape,
        border = btnBorder,
        contentPadding = PaddingValues(contentPadding),
        modifier = modifier.size(btnSize)
    ) {
        Image(
            modifier = Modifier.size(iconSize),
            painter = icon,
            contentDescription = stringResource(R.string.rounded_icon_button),
            contentScale = ContentScale.Fit,
            colorFilter = colorFilter,
        )
    }

}

@Preview
@Composable
private fun MyIconButtonPreview() {
    MtixTheme {
        Row {
            Column() {
                MyIconButton(
                    icon = painterResource(id = R.drawable.outline_heart),
                    onClick = {},
                    type = IconButtonType.Rounded,
                    size = ButtonSize.LARGE
                )
                MyIconButton(
                    icon = painterResource(id = R.drawable.outline_heart),
                    onClick = {},
                    type = IconButtonType.Rounded,
                    size = ButtonSize.SMALL
                )
                MyIconButton(
                    icon = painterResource(id = R.drawable.outline_heart),
                    onClick = {},
                    type = IconButtonType.Circle,
                    size = ButtonSize.LARGE
                )
                MyIconButton(
                    icon = painterResource(id = R.drawable.outline_heart),
                    onClick = {},
                    type = IconButtonType.Circle,
                    size = ButtonSize.SMALL
                )
            }
            Spacer(modifier = Modifier.width(Dimens.spacing_8))
            Column() {
                MyIconButton(
                    icon = painterResource(id = R.drawable.outline_heart),
                    onClick = {},
                    type = IconButtonType.Rounded,
                    state = ButtonState.SECONDARY,
                    size = ButtonSize.LARGE
                )
                MyIconButton(
                    icon = painterResource(id = R.drawable.outline_heart),
                    onClick = {},
                    type = IconButtonType.Rounded,
                    state = ButtonState.SECONDARY,
                    size = ButtonSize.SMALL
                )
                MyIconButton(
                    icon = painterResource(id = R.drawable.outline_heart),
                    onClick = {},
                    type = IconButtonType.Circle,
                    state = ButtonState.SECONDARY,
                    size = ButtonSize.LARGE
                )
                MyIconButton(
                    icon = painterResource(id = R.drawable.outline_heart),
                    onClick = {},
                    type = IconButtonType.Circle,
                    state = ButtonState.SECONDARY,
                    size = ButtonSize.SMALL
                )
            }
        }

    }
}
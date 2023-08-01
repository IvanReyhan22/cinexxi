package com.redesign.mtix.ui.components.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.redesign.mtix.ui.theme.Dimens
import com.redesign.mtix.ui.theme.MtixTheme
import com.redesign.mtix.ui.theme.Neutral100
import com.redesign.mtix.ui.theme.Shapes

@Composable
fun LabelButton(
    modifier: Modifier = Modifier,
    state: ButtonState = ButtonState.ACTIVE,
    onClick: () -> Unit,
    title: String,
) {
    //Color
    val btnColor = ButtonDefaults.buttonColors(
        when (state) {
            ButtonState.ACTIVE -> MaterialTheme.colorScheme.primary
            else -> MaterialTheme.colorScheme.background
        }
    )

    val contentColor = when (state) {
        ButtonState.ACTIVE -> MaterialTheme.colorScheme.background
        else -> MaterialTheme.colorScheme.primary
    }

    Button(
        onClick = onClick,
        colors = btnColor,
        shape = Shapes.large,
        border = if (state == ButtonState.SECONDARY) BorderStroke(
            Dimens.spacing_1,
            Neutral100
        ) else null,
        contentPadding = PaddingValues(horizontal = Dimens.spacing_12),
        modifier = modifier
            .height(Dimens.spacing_20)
    ) {
        Text(
            text = title,
            style = typography.labelSmall.copy(
                fontWeight = FontWeight.Medium,
                color = contentColor
            ),
        )
    }
}

@Preview
@Composable
private fun LabelButtonPreview() {
    MtixTheme {
        Column {
            LabelButton(onClick = { /*TODO*/ }, title = "IMAX 2D")
            Spacer(modifier = Modifier.height(Dimens.spacing_8))
            LabelButton(onClick = { /*TODO*/ }, title = "IMAX 2D", state = ButtonState.SECONDARY)
        }
    }
}
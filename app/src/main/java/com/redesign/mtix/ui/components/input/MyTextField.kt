package com.redesign.mtix.ui.components.input

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.redesign.mtix.R
import com.redesign.mtix.ui.components.button.MyButton
import com.redesign.mtix.ui.theme.Dimens
import com.redesign.mtix.ui.theme.MtixTheme
import com.redesign.mtix.ui.theme.Shapes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
    value: String,
    placeholder: String = stringResource(R.string.placeholder_template),
    label: String? = null,
    hint: String? = null,
    isPassword: Boolean = false,
    isTextArea: Boolean = false,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    readOnly: Boolean = false,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val visualTransformation =
        if (isPassword) PasswordVisualTransformation() else VisualTransformation.None
    val maxLines = if (isTextArea) 8 else 1

    Column(
        modifier = modifier
            .heightIn(min = 48.dp, max = 104.dp)
    ) {

        // Label
        if (!label.isNullOrEmpty()) {
            Text(
                modifier = Modifier.padding(bottom = Dimens.spacing_8),
                text = label,
                style = typography.bodyMedium.copy(
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Medium
                ),
            )
        }


        // Input
        BasicTextField(
            value = value,
            modifier = Modifier
                .defaultMinSize(
                    minWidth = TextFieldDefaults.MinWidth,
                    minHeight = Dimens.spacing_48,
                )
                .fillMaxWidth()
                .height(Dimens.spacing_48)
                .border(
                    BorderStroke(
                        Dimens.spacing_2,
                        MaterialTheme.colorScheme.surface
                    ),
                    shape = Shapes.large
                ),
            onValueChange = { onValueChange(it) },
            enabled = true,
            readOnly = readOnly,
            textStyle = typography.bodyMedium,
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            interactionSource = interactionSource,
            singleLine = !isTextArea,
            maxLines = maxLines,
            minLines = 1,
            decorationBox = @Composable { innerTextField ->
                TextFieldDefaults.DecorationBox(
                    value = value,
                    innerTextField = innerTextField,
                    enabled = true,
                    singleLine = !isTextArea,
                    visualTransformation = visualTransformation,
                    interactionSource = interactionSource,
                    placeholder = {
                        Text(
                            text = placeholder,
                            style = typography.bodyMedium.copy(color = MaterialTheme.colorScheme.onSurface),
                        )
                    },
                    shape = Shapes.large,
                    leadingIcon = leadingIcon,
                    trailingIcon=trailingIcon,
                    contentPadding = PaddingValues(
                        horizontal = Dimens.spacing_24,
                        vertical = Dimens.spacing_8
                    ),
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        unfocusedContainerColor = MaterialTheme.colorScheme.background,
                    ),
                )
            }
        )

        // Hint
        if (!hint.isNullOrEmpty()) {
            Text(
                modifier = Modifier.padding(top = Dimens.spacing_4),
                text = hint,
                style = typography.bodyMedium.copy(color = MaterialTheme.colorScheme.onSurface),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MyTextFieldPreview() {
    MtixTheme {
        Column {
            MyTextField(
                value = "", onValueChange = {}
            )
            Spacer(modifier = Modifier.height(Dimens.spacing_16))
            MyTextField(value = "Search Movie Name", label = "Search", onValueChange = {})
            Spacer(modifier = Modifier.height(Dimens.spacing_16))
            MyTextField(
                value = "Search Movie Name",
                label = "Search",
                hint = "Lowercase only",
                onValueChange = {})
            Spacer(modifier = Modifier.height(Dimens.spacing_16))
        }
    }
}

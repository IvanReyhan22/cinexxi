package com.redesign.mtix.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf


private val LightColorPalette = lightColorScheme(
    primary = Alpine400,
    onPrimary = Shades0,

    secondary = Alpine300,
    onSecondary = Alpine400,

    background = Shades0,
    onBackground = Shades100,

    surface = Neutral100,
    onSurface = Neutral400,
    surfaceVariant = Neutral200,
    surfaceTint = Neutral500,
    inverseSurface = Shades100
)

private val DarkColorPalette = darkColorScheme(
    primary = Alpine400,
    onPrimary = Shades0,

    secondary = Alpine300,
    onSecondary = Alpine400,

    background = Dark900,
    onBackground = Dark200,

    surface = Dark700,
    onSurface = Dark300,
    surfaceVariant = Dark300,
    surfaceTint = Dark300,
    inverseSurface = Dark200
)

private val LocalAppDimens = staticCompositionLocalOf { sw360Dimensions }

@Composable
fun ProvideDimens(
    dimensions: Dimensions,
    content: @Composable () -> Unit
) {
    val dimensionSet = remember { dimensions }
    CompositionLocalProvider(LocalAppDimens provides dimensionSet, content = content)
}

@Composable
fun MtixTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
//        DarkColorPalette
        LightColorPalette
    } else {
        LightColorPalette
    }

    val dimensions = sw360Dimensions
    ProvideDimens(dimensions = dimensions) {
        MaterialTheme(
            colorScheme = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}

object AppTheme {
    val dimens: Dimensions
        @Composable
        get() = LocalAppDimens.current
}

val Dimens: Dimensions
    @Composable
    get() = AppTheme.dimens
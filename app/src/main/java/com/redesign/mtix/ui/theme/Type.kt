package com.redesign.mtix.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.redesign.mtix.R


val Outfit = FontFamily(
    Font(R.font.outfit_light, FontWeight.Light),
    Font(R.font.outfit_regular, FontWeight.Normal),
    Font(R.font.outfit_medium, FontWeight.Medium),
    Font(R.font.outfit_semibold, FontWeight.SemiBold),
    Font(R.font.outfit_bold, FontWeight.Bold),
    Font(R.font.outfit_black, FontWeight.Black),
)

private val defaultTypography = Typography()

val Typography = Typography(
    displayLarge = defaultTypography.displayLarge.copy(fontFamily = Outfit, fontSize = 48.sp, fontWeight = FontWeight.Bold),
    displayMedium = defaultTypography.displayMedium.copy(fontFamily = Outfit, fontSize = 44.sp, fontWeight = FontWeight.Bold),
    displaySmall = defaultTypography.displaySmall.copy(fontFamily = Outfit, fontSize = 40.sp, fontWeight = FontWeight.Bold),

    headlineLarge = defaultTypography.headlineLarge.copy(fontFamily = Outfit, fontSize = 36.sp, fontWeight = FontWeight.Bold),
    headlineMedium = defaultTypography.headlineMedium.copy(fontFamily = Outfit, fontSize = 32.sp, fontWeight = FontWeight.Bold),
    headlineSmall = defaultTypography.headlineSmall.copy(fontFamily = Outfit, fontSize = 28.sp, fontWeight = FontWeight.Bold),

    titleLarge = defaultTypography.titleLarge.copy(fontFamily = Outfit, fontSize = 24.sp, fontWeight = FontWeight.Bold),
    titleSmall = defaultTypography.titleSmall.copy(fontFamily = Outfit, fontSize = 20.sp, fontWeight = FontWeight.Bold),

    bodyLarge = defaultTypography.bodyLarge.copy(fontFamily = Outfit, fontSize = 18.sp, fontWeight = FontWeight.Normal),
    bodyMedium = defaultTypography.bodyMedium.copy(fontFamily = Outfit, fontSize = 16.sp, fontWeight = FontWeight.Normal),
    bodySmall = defaultTypography.bodySmall.copy(fontFamily = Outfit, fontSize = 14.sp, fontWeight = FontWeight.Normal),

    labelLarge = defaultTypography.labelLarge.copy(fontFamily = Outfit, fontSize = 12.sp, fontWeight = FontWeight.Normal),
    labelMedium = defaultTypography.labelMedium.copy(fontFamily = Outfit, fontSize = 14.sp, fontWeight = FontWeight.Normal),
    labelSmall = defaultTypography.labelLarge.copy(fontFamily = Outfit, fontSize = 10.sp, fontWeight = FontWeight.Normal),
)
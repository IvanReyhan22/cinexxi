package com.redesign.mtix.ui.screen.login

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.redesign.mtix.ui.theme.MtixTheme

@Composable
fun LoginScreen(
    modifier: Modifier=Modifier,
) {
    Text("Login")
}

@Preview
@Composable
private fun LoginScreenPreview(){
    MtixTheme {

    }
}
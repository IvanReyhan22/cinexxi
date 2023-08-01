package com.redesign.mtix.ui.screen.register

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.redesign.mtix.ui.theme.MtixTheme

@Composable
fun RegisterScreen(modifier: Modifier=Modifier){
    Text(text = "Register")
}

@Preview
@Composable
private fun RegisterScreenPreview(){
    MtixTheme {
        RegisterScreen()
    }
}
package com.example.tugasil

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.tugasil.ui.theme.TugasILTheme
import component.MainTopBar


@Composable
fun MainMenu() {
    MainTopBar()
}


@Preview(showBackground = true, device = Devices.DEFAULT)
@Composable
fun MainMenuPreview() {
    TugasILTheme {
        MainMenu()
    }
}
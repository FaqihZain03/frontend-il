package com.example.tugasil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.tugasil.ui.theme.TugasILTheme
import component.MainTopBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TugasILTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MarketApp()
                }
            }
        }
    }
}

@Composable
fun MarketApp(modifier: Modifier = Modifier) {
    Column  (
        modifier = modifier
            .verticalScroll(rememberScrollState())
    ) {
        MainTopBar()
        FoodMenuScreen()
    }
}

@Composable
fun FoodMenuScreen(modifier: Modifier = Modifier) {
    LazyColumn {
        val foodList = 0
        items(foodList) { FoodMenuScreen() }
    }
}



@Preview(showBackground = true, device = Devices.DEFAULT)
@Composable
fun MarketAppPreview() {
    TugasILTheme {
        MarketApp()
    }
}
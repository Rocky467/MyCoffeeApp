package com.example.mycoffeeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.mycoffeeapp.presentation.navigation.NavGraph
import com.example.mycoffeeapp.presentation.screens.cartScreen.CartScreen
import com.example.mycoffeeapp.presentation.screens.cartScreen.CartScreenCard
import com.example.mycoffeeapp.presentation.theme.MyCoffeeAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyCoffeeAppTheme {
                NavGraph()
            }
        }
    }
}

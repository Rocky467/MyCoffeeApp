package com.example.mycoffeeapp.presentation.screens.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mycoffeeapp.R
import com.example.mycoffeeapp.presentation.navigation.BottomNavBar

@Composable
fun HomeScreen(navController: NavHostController) {

    Scaffold(
        bottomBar = { BottomNavBar(navController, BottomNavBar.Home.name) }
    ) { paddingValues ->

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(1f / 3f)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF303030),
                            Color(0xFF1F1F1F),
                            Color(0xFF121212)
                        )
                    )
                )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(paddingValues)
        ) {

            ProductsList(
                navController = navController,
                topContent = {
                    Text(
                        text = "Location",
                        color = Color.LightGray
                    )

                    Spacer(Modifier.height(8.dp))

                    Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Bhukum, Star Tower",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(Modifier.height(8.dp))

                        Icon(
                            imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = "",
                            tint = Color.White
                        )
                    }

                    Spacer(Modifier.height(32.dp))

                    SearchBar()

                    Spacer(Modifier.height(32.dp))

                    Image(
                        painter = painterResource(R.drawable.banner_1),
                        contentDescription = "img"
                    )

                    Spacer(Modifier.height(16.dp))

                    CoffeeFilters()

                    Spacer(Modifier.height(8.dp))
                }
            )
        }
    }
}
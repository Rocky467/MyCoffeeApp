package com.example.mycoffeeapp.presentation.screens.detailScreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.mycoffeeapp.domain.models.Util

@Composable
fun DetailScreen(navController: NavHostController, productId: Int) {

    val selectedProduct = Util.products.find { it.id == productId }

    Scaffold(
        topBar = { DetailScreenTopBar(navController) },
        bottomBar = { DetailScreenBottomBar() }
    ) { paddingValues ->

        LazyColumn {

            item {
                selectedProduct?.let { DetailScreenContent(it, paddingValues) }
            }
        }
    }
}

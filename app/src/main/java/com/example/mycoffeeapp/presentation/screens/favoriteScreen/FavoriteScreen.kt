package com.example.mycoffeeapp.presentation.screens.favoriteScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mycoffeeapp.R
import com.example.mycoffeeapp.domain.models.Product
import com.example.mycoffeeapp.domain.models.Util
import com.example.mycoffeeapp.presentation.navigation.BottomNavBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoriteScreen(navController: NavHostController) {

    var favoriteItems by remember {
        mutableStateOf(
            listOf(
                Product(
                    id = 1,
                    name = "Caffe Latte",
                    description = "with Oat Milk",
                    price = 4.53,
                    imageResourceId = R.drawable.coffee_1
                ),
                Product(
                    id = 2,
                    name = "Cappuccino",
                    description = "with Chocolate",
                    price = 3.90,
                    imageResourceId = R.drawable.coffee_2
                )
            )
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Wishlist",
                        fontWeight = FontWeight.Bold
                    )
                }
            )
        },
        bottomBar = { BottomNavBar(navController, BottomNavBar.Favorites.name) }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(paddingValues)
        ) {

            item {

                favoriteItems.forEach { product ->
                    FavoriteScreenCard(
                        product = product,
                        onDelete = { favoriteItems = favoriteItems - product })
                }
            }
        }
    }
}


@Composable
fun FavoriteScreenCard(product: Product, onDelete: () -> Unit) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.elevatedCardElevation(4.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {

            Image(
                painter = painterResource(product.imageResourceId),
                contentDescription = "img",
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .size(80.dp)
            )

            Spacer(Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f),
            ) {
                Text(
                    text = product.name,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(Modifier.height(4.dp))

                Text(
                    text = product.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
            }

            IconButton(
                onClick = { onDelete() },
                modifier = Modifier.size(32.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "ic",
                    tint = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}

package com.example.mycoffeeapp.presentation.screens.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mycoffeeapp.R
import com.example.mycoffeeapp.domain.models.Util
import com.example.mycoffeeapp.domain.models.Product
import com.example.mycoffeeapp.presentation.navigation.Routes
import com.example.mycoffeeapp.presentation.theme.IvoryWhite
import com.example.mycoffeeapp.presentation.theme.LightBrown
import com.example.mycoffeeapp.presentation.theme.LightGray

@Composable
fun ProductsList(navController: NavHostController, topContent: @Composable () -> Unit) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {

        item { topContent() }

        items(Util.products.chunked(2)) { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                ProductCard(rowItems[0], Modifier.weight(1f), navController)
                if (rowItems.size == 2) {
                    ProductCard(rowItems[1], Modifier.weight(1f), navController)
                } else {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}


@Composable
fun ProductCard(product: Product, modifier: Modifier, navController: NavHostController) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { navController.navigate(Routes.DetailScreen(product.id)) },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = LightGray
        )
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
            ) {
                Image(
                    painter = painterResource(product.imageResourceId),
                    contentDescription = "img",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(16.dp))
                )

                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(4.dp)
                        .background(
                            color = LightGray.copy(0.7f),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(4.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.regular_outline_heart),
                        contentDescription = "ic",
                        modifier = Modifier.size(24.dp),
                        tint = LightBrown,
                    )
                }
            }

            Spacer(Modifier.height(8.dp))

            Text(
                text = product.name,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(Modifier.height(8.dp))

            Text(
                text = product.description,
                style = MaterialTheme.typography.bodySmall,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$${product.price}",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = LightBrown
                )

                IconButton(
                    onClick = { },
                    modifier = Modifier
                        .background(
                            color = LightBrown,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .size(32.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add to cart",
                        tint = IvoryWhite
                    )
                }
            }
        }
    }
}

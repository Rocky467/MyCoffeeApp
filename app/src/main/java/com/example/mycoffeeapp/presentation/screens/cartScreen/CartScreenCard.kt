package com.example.mycoffeeapp.presentation.screens.cartScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycoffeeapp.R
import com.example.mycoffeeapp.domain.models.Product
import com.example.mycoffeeapp.presentation.theme.LightBrown

@Composable
fun CartScreenCard(product: Product) {

    var qty by remember { mutableIntStateOf(1) }

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

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                IconButton(
                    onClick = { qty-- },
                    modifier = Modifier
                        .background(
                            color = LightBrown.copy(0.2f),
                            shape = CircleShape
                        )
                        .size(32.dp),
                    enabled = qty > 1
                ) {
                    Icon(
                        imageVector = Icons.Default.Remove,
                        contentDescription = "ic",
                        tint = LightBrown
                    )
                }

                Text(
                    text = "$qty",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold
                )

                IconButton(
                    onClick = { qty++ }, modifier = Modifier
                        .background(
                            color = LightBrown.copy(0.2f),
                            shape = CircleShape
                        )
                        .size(32.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "ic",
                        tint = LightBrown
                    )
                }
            }
        }
    }
}

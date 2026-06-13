package com.example.mycoffeeapp.presentation.screens.detailScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycoffeeapp.R
import com.example.mycoffeeapp.domain.models.Product
import com.example.mycoffeeapp.presentation.theme.CharcoalGray
import com.example.mycoffeeapp.presentation.theme.IvoryWhite
import com.example.mycoffeeapp.presentation.theme.LightBrown
import com.example.mycoffeeapp.presentation.theme.LightGray

@Composable
fun DetailScreenContent(product: Product, paddingValues: PaddingValues) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .padding(paddingValues)
    ) {

        Image(
            painter = painterResource(product.imageResourceId),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = product.name,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Ice / Hot",
                fontSize = 16.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Medium
            )

            Icon(
                painter = painterResource(R.drawable.default_bean),
                contentDescription = "ic",
                tint = LightBrown,
                modifier = Modifier
                    .size(40.dp)
                    .background(color = IvoryWhite, shape = RoundedCornerShape(8.dp))
                    .padding(8.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        HorizontalDivider(color = Color.LightGray.copy(alpha = 0.5f))

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Description",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = product.description,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Size",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        var selectedSize by remember { mutableStateOf("M") }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            listOf("S", "M", "L").forEach {
                SelectSizeChip(
                    size = it,
                    isSelect = selectedSize == it,
                    onClick = { selectedSize = it },
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp)
                )
            }
        }
    }
}


@Composable
fun SelectSizeChip(size: String, isSelect: Boolean, onClick: () -> Unit, modifier: Modifier) {

    Box(
        modifier = modifier
            .background(
                color = Color.White,
                shape = RoundedCornerShape(8.dp)
            )
            .border(
                width = 1.dp,
                color = if (isSelect) LightBrown else LightGray,
                shape = RoundedCornerShape(8.dp)
            )
            .height(48.dp)
            .clickable(onClick = { onClick() }),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = size,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = if (isSelect) LightBrown else CharcoalGray
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DetailScreenContentPreview() {
    val sampleProduct = Product(
        id = 1,
        name = "Cappuccino",
        description = "A classic espresso-based drink prepared with steamed milk foam.",
        price = 4.50,
        imageResourceId = R.drawable.coffee_1 // Ensure this resource exists
    )
    MaterialTheme {
        DetailScreenContent(product = sampleProduct, paddingValues = PaddingValues(16.dp))
    }
}

package com.example.mycoffeeapp.presentation.screens.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycoffeeapp.presentation.theme.LightBrown
import com.example.mycoffeeapp.presentation.theme.LightGray

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CoffeeFilters() {

    val categories = listOf("All Coffees", "Macchiato", "Latte", "Americano", "Snacks", "Desert")

    var selectedCategory by remember { mutableStateOf(categories.first()) }

    LazyRow(
        modifier = Modifier.padding(horizontal = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(categories) { category ->
            CategoryChip(
                text = category,
                isSelected = category == selectedCategory,
                onSelected = { selectedCategory = category }
            )
        }
    }
}


@Composable
fun CategoryChip(text: String, isSelected: Boolean, onSelected: () -> Unit) {

    Box(
        modifier = Modifier
            .width(90.dp)
            .height(32.dp)
            .clip(shape = RoundedCornerShape(8.dp))
            .clickable { onSelected() }
            .background(color = if (isSelected) LightBrown else LightGray.copy(alpha = 0.6f)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            maxLines = 1,
            color = if (isSelected) Color.White else Color.Black
        )
    }
}

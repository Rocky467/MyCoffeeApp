package com.example.mycoffeeapp.presentation.screens.cartScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mycoffeeapp.R
import com.example.mycoffeeapp.domain.models.Util
import com.example.mycoffeeapp.presentation.theme.CreamBeige
import com.example.mycoffeeapp.presentation.theme.LightBrown
import com.example.mycoffeeapp.presentation.navigation.BottomNavBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(navController: NavHostController) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Order",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    )
                }
            )
        },
        bottomBar = { BottomNavBar(navController, BottomNavBar.Cart.name) }

    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(paddingValues)
        ) {

            item {
                Row {
                    Text(
                        text = "Deliver",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = LightBrown
                    )
                }

                Spacer(Modifier.height(16.dp))

                Util.products.take(3).forEach {
                    CartScreenCard(it)
                }

                Spacer(Modifier.height(16.dp))

                PaymentSummary()

                Spacer(Modifier.height(16.dp))

                PaymentCard()
            }
        }
    }
}


@Composable
fun PaymentSummary() {

    Text(
        text = "Payment summary",
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold
    )

    Spacer(Modifier.height(8.dp))

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = "Price",
            style = MaterialTheme.typography.titleMedium,
        )

        Text(
            text = "$3.14",
            style = MaterialTheme.typography.titleMedium
        )
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = "Delivery fee",
            style = MaterialTheme.typography.titleMedium,
        )

        Text(
            text = "$1.0",
            style = MaterialTheme.typography.titleMedium
        )

    }
}


@Composable
fun PaymentCard() {

    var isDropDownExpanded by remember { mutableStateOf(false) }
    var selectedMode by remember { mutableStateOf("Online") }

    val paymentModesList = listOf("Online", "Cash")

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {

        Column(modifier = Modifier.padding(16.dp)) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(if (selectedMode == "Online") R.drawable.mobile_banking else R.drawable.wallet),
                    contentDescription = "",
                    tint = LightBrown,
                    modifier = Modifier.size(32.dp)
                )

                Spacer(Modifier.width(8.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = selectedMode,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(Modifier.height(4.dp))

                    Text(
                        text = "$3.14",
                        style = MaterialTheme.typography.bodyMedium,
                        color = LightBrown
                    )
                }

                Box {

                    Icon(
                        painter = painterResource(R.drawable.regular_outline_arrow_down),
                        contentDescription = "",
                        modifier = Modifier
                            .size(24.dp)
                            .clickable {
                                isDropDownExpanded = true
                            }
                    )

                    DropdownMenu(
                        expanded = isDropDownExpanded,
                        onDismissRequest = { isDropDownExpanded = false }
                    ) {
                        paymentModesList.forEach {
                            DropdownMenuItem(
                                text = {
                                    Text(
                                        text = it,
                                        style = MaterialTheme.typography.bodyLarge
                                    )
                                },
                                onClick = {
                                    selectedMode = it
                                    isDropDownExpanded = false
                                },
                                leadingIcon = {
                                    Icon(
                                        painter = painterResource(if (it == "Online") R.drawable.mobile_banking else R.drawable.wallet),
                                        contentDescription = "",
                                        tint = LightBrown,
                                        modifier = Modifier.size(24.dp)
                                    )
                                },
                                modifier = Modifier
                                    .padding(horizontal = 8.dp)
                                    .background(
                                        color = if (selectedMode == it) CreamBeige else Color.Transparent,
                                        shape = RoundedCornerShape(4.dp)
                                    )
                            )
                        }
                    }
                }
            }

            Spacer(Modifier.height(16.dp))

            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = LightBrown),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = "Place Order")
            }
        }
    }
}

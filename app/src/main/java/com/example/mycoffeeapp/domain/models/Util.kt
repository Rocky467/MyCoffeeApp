package com.example.mycoffeeapp.domain.models

import com.example.mycoffeeapp.R

object Util {

    val products = listOf(
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
        ),
        Product(
            id = 3,
            name = "Macchiato",
            description = "with Oat Milk",
            price = 4.53,
            imageResourceId = R.drawable.coffee_3
        ),
        Product(
            id = 4,
            name = "Americano",
            description = "with Chocolate",
            price = 3.90,
            imageResourceId = R.drawable.coffee_4
        ),
        Product(
            id = 5,
            name = "Indiano",
            description = "with Oat Milk",
            price = 4.53,
            imageResourceId = R.drawable.coffee_5
        ),
        Product(
            id = 6,
            name = "Cold coffee",
            description = "with Chocolate",
            price = 3.90,
            imageResourceId = R.drawable.coffee_6
        )
    )
}
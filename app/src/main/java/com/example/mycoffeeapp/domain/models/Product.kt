package com.example.mycoffeeapp.domain.models

data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val imageResourceId: Int
)

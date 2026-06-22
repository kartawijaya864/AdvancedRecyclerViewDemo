package com.example.advancedrecyclerviewdemo.model

sealed class ItemData {

    data class Header(
        val title: String
    ) : ItemData()

    data class ColorItem(
        val id: Int,
        val colorName: String,
        val colorHex: String
    ) : ItemData()
}
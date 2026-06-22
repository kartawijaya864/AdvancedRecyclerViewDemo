package com.example.advancedrecyclerviewdemo.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.advancedrecyclerviewdemo.model.ItemData

class ItemDiffCallback : DiffUtil.ItemCallback<ItemData>() {

    override fun areItemsTheSame(
        oldItem: ItemData,
        newItem: ItemData
    ): Boolean {

        return when {
            oldItem is ItemData.Header &&
                    newItem is ItemData.Header ->
                oldItem.title == newItem.title

            oldItem is ItemData.ColorItem &&
                    newItem is ItemData.ColorItem ->
                oldItem.id == newItem.id

            else -> false
        }
    }

    override fun areContentsTheSame(
        oldItem: ItemData,
        newItem: ItemData
    ): Boolean = oldItem == newItem
}
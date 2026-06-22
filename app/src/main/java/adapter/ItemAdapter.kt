package com.example.advancedrecyclerviewdemo.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.advancedrecyclerviewdemo.R
import com.example.advancedrecyclerviewdemo.model.ItemData

class ItemAdapter :
    ListAdapter<ItemData, RecyclerView.ViewHolder>(
        ItemDiffCallback()
    ) {

    companion object {
        private const val HEADER = 0
        private const val COLOR = 1
    }

    override fun getItemViewType(position: Int): Int {

        return when (getItem(position)) {
            is ItemData.Header -> HEADER
            is ItemData.ColorItem -> COLOR
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {

        return when (viewType) {

            HEADER -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(
                        R.layout.item_header,
                        parent,
                        false
                    )

                HeaderViewHolder(view)
            }

            else -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(
                        R.layout.item_color,
                        parent,
                        false
                    )

                ColorViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {

        when (val item = getItem(position)) {

            is ItemData.Header ->
                (holder as HeaderViewHolder)
                    .bind(item)

            is ItemData.ColorItem ->
                (holder as ColorViewHolder)
                    .bind(item)
        }
    }

    class HeaderViewHolder(view: View)
        : RecyclerView.ViewHolder(view) {

        private val title =
            view.findViewById<TextView>(R.id.headerTitle)

        fun bind(item: ItemData.Header) {
            title.text = item.title
        }
    }

    class ColorViewHolder(view: View)
        : RecyclerView.ViewHolder(view) {

        private val name =
            view.findViewById<TextView>(R.id.colorName)

        fun bind(item: ItemData.ColorItem) {

            name.text = item.colorName

            itemView.setBackgroundColor(
                Color.parseColor(item.colorHex)
            )
        }
    }
}
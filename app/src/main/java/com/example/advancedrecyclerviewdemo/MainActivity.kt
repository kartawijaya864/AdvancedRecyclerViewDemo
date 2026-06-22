package com.example.advancedrecyclerviewdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.advancedrecyclerviewdemo.adapter.ItemAdapter
import com.example.advancedrecyclerviewdemo.databinding.ActivityMainBinding
import com.example.advancedrecyclerviewdemo.model.ItemData

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding =
            ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val adapter = ItemAdapter()

        val layoutManager =
            GridLayoutManager(this, 2)

        layoutManager.spanSizeLookup =
            object : GridLayoutManager.SpanSizeLookup() {

                override fun getSpanSize(position: Int): Int {

                    return when (
                        adapter.currentList[position]
                    ) {

                        is ItemData.Header -> 2

                        else -> 1
                    }
                }
            }

        binding.recyclerView.layoutManager =
            layoutManager

        binding.recyclerView.adapter =
            adapter

        val data = listOf(

            ItemData.Header("Primary Colors"),

            ItemData.ColorItem(
                1,
                "Red",
                "#FF0000"
            ),

            ItemData.ColorItem(
                2,
                "Green",
                "#00FF00"
            ),

            ItemData.ColorItem(
                3,
                "Blue",
                "#0000FF"
            ),

            ItemData.Header("Secondary Colors"),

            ItemData.ColorItem(
                4,
                "Yellow",
                "#FFFF00"
            ),

            ItemData.ColorItem(
                5,
                "Cyan",
                "#00FFFF"
            ),

            ItemData.ColorItem(
                6,
                "Magenta",
                "#FF00FF"
            )
        )

        adapter.submitList(data)
    }
}
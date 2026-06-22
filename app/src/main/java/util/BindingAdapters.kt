package com.example.advancedrecyclerviewdemo.util

import android.graphics.Color
import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("backgroundColor")
fun setBackgroundColor(view: View, colorHex: String?) {

    colorHex?.let {
        view.setBackgroundColor(Color.parseColor(it))
    }
}